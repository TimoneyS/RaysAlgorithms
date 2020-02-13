package com.ray.leetcode;

import com.ray.io.Dir;
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
            //Dir.getSourcePath(L0000_Assistant.class);
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
     *
     * @param questionName
     * @return
     */
    private static String getQuestionData(String questionName) {
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
     *
     * @param questionData
     * @return
     */
    private static Map<String, String> parseQuestionData(String questionData) {
        JSONObject json = new JSONObject(questionData);

        String title = json.getJSONObject("data").getJSONObject("question").getString("title");
        String content = json.getJSONObject("data").getJSONObject("question").getString("content");
        content = content.replaceAll("<\\S+?>", "").replaceAll("\r\n", "\n").replaceAll("\n\n", "\n");
        String[] arr = content.split("Example:");
        String detail = arr[0];
        String example = arr[1].trim();
        String difficulty = json.getJSONObject("data").getJSONObject("question").getString("difficulty");
        JSONArray jsonArray = json.getJSONObject("data").getJSONObject("question").getJSONArray("codeSnippets");

        String javaCode = "";
        for (Object o : jsonArray) {
            if (o instanceof JSONObject) {
                JSONObject jsonObject = (JSONObject)o;
                if (jsonObject.getString("lang").equalsIgnoreCase("Java")) {
                    javaCode = jsonObject.getString("code");
                    break;
                }
            }
        }

        String id = json.getJSONObject("data").getJSONObject("question").getString("questionId");
        String questionClass = String.format("L%04d_%s", Integer.valueOf(id), title.replaceAll(" ", "_"));

        Map<String, String> questionInfo = new HashMap<>();
        questionInfo.put(TITLE, title);
        questionInfo.put(DETAIL, detail);
        questionInfo.put(EXAMPLE, example);
        questionInfo.put(DIFFICULTY, difficulty);
        questionInfo.put(DATE, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        questionInfo.put(JAVA_CODE, javaCode);
        questionInfo.put(QUESTION_CLASS, questionClass);
        return questionInfo;
    }

    private static void adjustQuestionData(Map<String, String> map) {
        adjustString(map, DETAIL, " * ");
        adjustString(map, EXAMPLE, " *      ");
        adjustString(map, JAVA_CODE, "    ");
    }

    /**
     * 调整字符串的缩进
     */
    private static void adjustString(Map<String, String> map, String key, String prefix) {
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

    /**
     * 生成文件内容
     *
     * @param map
     * @return
     */
    private static String generateFileContent(Map<String, String> map) {
        adjustQuestionData(map);
        String model = readModel(MODEL_FILENAME);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            model = model.replace(key, value.replaceAll("\r\n$", ""));
        }
        return model;
    }

    /**
     * 读取模板
     *
     * @param filename
     * @return
     */
    private static String readModel(String filename) {
        StringBuilder sb = new StringBuilder();
        try (Scanner sc = In.getClassPathScanner(L0000_Assistant.class, filename)) {
            while (sc.hasNextLine()) {
                sb.append(sc.nextLine()).append("\r\n");
            }
        }
        return sb.toString();
    }

    /**
     * 创建文件
     *
     * @param filename
     * @param javaString
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
        String body = getQuestionData(questionName);
        Map<String, String> map = parseQuestionData(body);
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

    public static void main(String[] args) throws Exception {

        String url = "https://leetcode-cn.com/problems/add-two-numbers/";
        recordQuestionToFileFromWeb(url);
    }

}
