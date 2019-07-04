package com.ray.LintCode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ray.io.Dir;
import com.ray.io.In;
import com.ray.io.Out;
import com.ray.net.http.HttpsUtil;

public class L_0000_Assistant {
    
    static String MODEL_FILENAME = "model.ini";
    static String BASE_DIR = Dir.getSourcePath(L_0000_Assistant.class);
    
    
    // 定义返回的json中各个域的主键
    private static String QI_ID             = "id";
    private static String QI_TITLE          = "title";
    private static String QI_BASEURL        = "baseurl";
    private static String QI_DESC           = "description";
    private static String QI_EXAMP          = "example";
    private static String QI_CHAL           = "challenge";

    private static String PH_CLASS          = "%QUESTION_CLASS%";
    private static String PH_BASEURL        = "%BASE_URL%";
    private static String PH_DESC           = "%DESCRIPTION_STRING%";
    private static String PH_EXAMP          = "%EXAMPLE_STRING%";
    private static String PH_CHAL           = "%CHALLENGE_STRING%";
    private static String PH_DATESTRING     = "%DATE_STRING%";
   
    
    private static String replaceHoder(StringBuilder modelString, String className, Map<String, String> questionInfo) {
        
        int start = 0;
        
        // 替换描述信息
        start = modelString.indexOf(PH_DESC);
        modelString.replace(start, start + PH_DESC.length(), questionInfo.get(QI_DESC));
        
        // 替换用例信息
        start = modelString.indexOf(PH_EXAMP);
        modelString.replace(start, start + PH_EXAMP.length(), questionInfo.get(QI_EXAMP));
        
        // 替换挑战信息
        start = modelString.indexOf(PH_CHAL);
        modelString.replace(start, start + PH_CHAL.length(), questionInfo.get(QI_CHAL));
        
        // 替换基础URL
        start = modelString.indexOf(PH_BASEURL);
        modelString.replace(start, start + PH_BASEURL.length(), questionInfo.get(QI_BASEURL));
        
        // 替换时间戳
        start = modelString.indexOf(PH_DATESTRING);
        modelString.replace(start, start + PH_DATESTRING.length(),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        
        // 替换类名
        start = modelString.indexOf(PH_CLASS);
        modelString.replace(start, start + PH_CLASS.length(), className);
        
        return modelString.toString();
    }
    
    private static StringBuilder readModelFromFile(String filename) {
        StringBuilder sb = new StringBuilder();
        try (Scanner sc = In.getClassPathScanner(L_0000_Assistant.class, filename)) {
            while (sc.hasNextLine()) {
                sb.append(sc.nextLine()).append("\r\n");
            }
        }
        return sb;
    }
    
    private static void writeToFile(String filename, String javaString) {
        File f = new File(BASE_DIR + filename + ".java");
        if (f.exists()) return;
        try (FileWriter fw = new FileWriter(f)) {
            fw.write(javaString);
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
    
    public static void createJavaFileFromWeb(String url) throws Exception {
        Map<String, String> questionInfo = getQuestionInfoFromWeb(url);
        String className          = String.format("L_%S_%s", questionInfo.get(QI_ID), questionInfo.get(QI_TITLE).replaceAll(" ", "_"));
        StringBuilder modelString = readModelFromFile(MODEL_FILENAME);
        String javaString = replaceHoder(modelString, className, questionInfo);
        writeToFile(className, javaString);
        Out.p(javaString);
    }
    
    private static Map<String, String> getQuestionInfoFromWeb(String url) throws Exception {
        Map<String, String> map = new HashMap<>();
        
        // 提取 url 中的 问题标题信息
        String title = url.substring(url.indexOf("problem") + "problem".length() + 1, url.indexOf("description") - 1);
        
        // 根据标题获取问题的唯一信息如 ID 等
        String uniqueUrl =  "https://www.lintcode.cn/api/problems/detail/?unique_name_or_alias=%title%&_format=detail";
        uniqueUrl = uniqueUrl.replace("%title%", title);
        Out.p(uniqueUrl);
        Map<String, String> head = new HashMap<String, String>();
        head.put("accept", "application/json, text/plain, */*");
        byte[] rs = HttpsUtil.doGet(uniqueUrl, head);
        int id = new JSONObject(new String(rs)).getInt("id");
        Out.p(new String(rs));
        
        // 根据问题的ID获取问题的详细信息
        String idUrl = "https://www.lintcode.cn/api/translations/?id="+id;
        Out.p(idUrl);
        head.put("accept", "application/json, text/plain, */*");
        rs = HttpsUtil.doGet(idUrl, head);
        Out.p(new String(rs));
        JSONArray arr = new JSONArray(new String(rs));
        
        // 解析信息到 map
        map.put(QI_BASEURL, url);
        map.put(QI_ID, String.format("%04d", id));
        for (int i = 0; i < arr.length(); i++) {
            JSONObject json = arr.getJSONObject(i);
            String key = json.getString("field");
            StringBuilder sb = new StringBuilder();
            for (String line : json.getString("default").split("\r\n")) {
                sb.append(" *   ").append(line).append("\r\n");
            }
            
            String value = sb.substring(" *   ".length(), sb.length()-2).toString();
            map.put(key, value);
        }
        
        return map;
    }
    
    public static void main(String[] args) throws Exception {
        Out.p("please input url:");
        
        byte[] bytes = new byte[100];
        System.in.read(bytes);
        
        int i = 0;
        for (byte b : bytes) {
            i ++;
            if (b == 13) break;
        }
        String url = new String(bytes, 0, i+1);
        
        createJavaFileFromWeb(url);
        
    }
    
}
