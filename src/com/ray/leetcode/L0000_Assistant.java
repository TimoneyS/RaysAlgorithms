package com.ray.leetcode;

import com.ray.io.In;
import com.ray.net.http.Https;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class L0000_Assistant {

    private static final String MODEL_FILENAME    = "model.txt";
    private static final String BASE_DIR          = "D:\\workspace\\eclipse_se\\RaysAlgorithms\\src\\com\\ray\\leetcode\\";
    private static final String TITLE             = "$TITLE";
    private static final String DETAIL            = "$DETAIL";
    private static final String EXAMPLE           = "$EXAMPLE";
    private static final String DIFFICULTY        = "$DIFFICULTY";
    private static final String LINK              = "$LINK";
    private static final String DATE              = "$DATE";
    private static final String QUESTION_CLASS    = "$QUESTION_CLASS";
    private static final String JAVA_CODE         = "$JAVA_CODE";

    /**
     * 从网络获取题目的 json
     */
    private static String getQuestionJson(String questionName) {
        Map<String, String> head = new HashMap<>();
        head.put("content-type", "application/json");
        head.put("origin", "https://leetcode-cn.com");
        head.put("referer", String.format("https://leetcode-cn.com/problems/%s/", questionName));

        String data = "{\"operationName\": \"questionData\",\n\"variables\": { \"titleSlug\": \"%s\" }," +
                "\"titleSlug\": \"%s\",\n\"query\": \"query questionData($titleSlug: String!) {  " +
                "question(titleSlug: $titleSlug) {    questionId    questionFrontendId    boundTopicId    title" +
                "    titleSlug    content    translatedTitle    translatedContent    isPaidOnly    difficulty  " +
                "  likes    dislikes    isLiked    similarQuestions    contributors {      username      " +
                "profileUrl      avatarUrl      __typename    }    langToValidPlayground    topicTags {      " +
                "name      slug      translatedName      __typename    }    companyTagStats    codeSnippets {  " +
                "    lang      langSlug      code      __typename    }    stats    hints    solution {      id  " +
                "    canSeeDetail      __typename    }    status    sampleTestCase    metaData    judgerAvailable" +
                "    judgeType    mysqlSchemas    enableRunCode    envInfo    book {      id      bookName      " +
                "pressName      source      shortDescription      fullDescription      bookImgUrl      pressImgUrl" +
                "      productUrl      __typename    }    isSubscribed    __typename  }}\"}";
        String body = null;
        try {
            byte[] rs = Https.doPost("https://leetcode-cn.com/graphql/", String.format(data, questionName, questionName), head);
            body = new String(rs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body;
    }

    /**
     * 解析信息的 json 字符串 保存到 map 中
     */
    private static Map<String, String> parseQuestionJson(String questionData) {
        Map<String, String> questionInfo = new HashMap<>();

        // 去除空行
        JSONObject json = new JSONObject(questionData);
        JSONObject quesJson = json.getJSONObject("data").getJSONObject("question");
        String content = stringRemoveHtml(quesJson.getString("content"));

        String[] arr = content.split("Example\\s*\\d*:");
        // 问题的标题
        questionInfo.put(TITLE, quesJson.getString("title"));
        // 问题的描数信息
        questionInfo.put(DETAIL, arr[0]);
        StringBuilder example = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            example.append("Example ").append(i).append("\r\n").append(arr[i]);
        }
        // 问题的用例
        questionInfo.put(EXAMPLE, example.toString());
        // 问题难度
        questionInfo.put(DIFFICULTY, quesJson.getString("difficulty"));
        // 问题的样板代码
        String javaCode = "";
        for (Object o : quesJson.getJSONArray("codeSnippets")) {
            if (o instanceof JSONObject) {
                JSONObject jsonObject = (JSONObject)o;
                if (jsonObject.getString("lang").equalsIgnoreCase("Java")) {
                    javaCode = jsonObject.getString("code");
                    break;
                }
            }
        }
        javaCode = javaCode.replaceAll("class ", "static class ");
        questionInfo.put(JAVA_CODE, javaCode);
        // 问题建档时间，当前时间
        questionInfo.put(DATE, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        // 问题的类名
        String titleToClass = questionInfo.get(TITLE).replaceAll("[ ()]", "_").replaceAll("[-]", "_");
        String questionClass = String.format("L%04d_%s", Integer.valueOf(quesJson.getString("questionId")), titleToClass);
        questionInfo.put(QUESTION_CLASS, questionClass);

        stringAdjustIndent(questionInfo, DETAIL, " * ");
        stringAdjustIndent(questionInfo, EXAMPLE, " *      ");
        stringAdjustIndent(questionInfo, JAVA_CODE, "    ");
        return questionInfo;
    }

    /**
     * 调整字符串的缩进
     */
    private static void stringAdjustIndent(Map<String, String> map, String key, String prefix) {
        String s = map.get(key);
        StringBuilder sb = new StringBuilder();
        String[] lines = s.split("\r\n|\n");
        sb.append(lines[0]).append("\r\n");
        for (int i = 1; i < lines.length; i++) {
            if (lines[i].trim().length() > 0) {
                sb.append(prefix).append(lines[i]).append("\r\n");
            }
        }
        map.put(key, sb.toString());
    }

    private static String stringRemoveHtml(String str) {
        // 去除 html 标签
        str = str.replaceAll("<.+?>", "");
        str = str.replaceAll("&quot;", "");
        // 去除 html 编码
        str = str.replaceAll("&gt;", ">");
        str = str.replaceAll("&nbsp;", " ");
        str = str.replaceAll("&#39;", "'");
        str = str.replaceAll("&le;", "≤");
        str = str.replaceAll("&rarr;", "→");
        return str;
    }

    /**
     * 生成文件内容
     */
    private static String generateFileContent(Map<String, String> map) {
        String model = readModel();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            model = model.replace(key, value.replaceAll("\r\n$", ""));
        }
        return model;
    }

    /**
     * 读取模板
     */
    private static String readModel() {
        StringBuilder sb = new StringBuilder();
        try (Scanner sc = In.getClassPathScanner(L0000_Assistant.class, L0000_Assistant.MODEL_FILENAME)) {
            while (sc.hasNextLine()) {
                sb.append(sc.nextLine()).append("\r\n");
            }
        }
        return sb.toString();
    }

    /**
     * 创建文件
     */
    private static void createFile(String filename, String javaString) {
        File f = new File(BASE_DIR + filename + ".java");
        try (FileWriter fw = new FileWriter(f)) {
            fw.write(javaString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void recordQuestionToFileFromWeb(String url) {
        String questionName = getQuestionName(url);
        String body = getQuestionJson(questionName);
        Map<String, String> map = parseQuestionJson(body);
        map.put(LINK, url);
        String fileContent = generateFileContent(map);
        createFile(map.get(QUESTION_CLASS), fileContent);
    }

    private static String getQuestionName(String url) {
        if (url.charAt(url.length()-1) == '/') {
            url = url.substring(0, url.length()-1);
        }
        return url.substring(url.lastIndexOf('/')+1);
    }

    public static void main(String[] args) {

//        String url = "https://leetcode-cn.com/problems/add-two-numbers/";
        Scanner sc = new Scanner(System.in);
        String url = sc.nextLine().trim();

        recordQuestionToFileFromWeb(url);

    }

}