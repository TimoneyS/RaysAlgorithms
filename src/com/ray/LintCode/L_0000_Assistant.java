package com.ray.LintCode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ray.io.Dir;
import com.ray.io.Out;

public class L_0000_Assistant {
    
    public static void main(String[] args) {
        
        String title = "43. Maximum Subarray III";
        
        createJavaFileFromTitle(title);
    }
    
    private static String getFileName(String title) {
        
        Pattern p = Pattern.compile("^(\\d+)\\.\\s+(.*\\S)\\s*$");
        Matcher m = p.matcher(title);
        m.find();
        
        int id = Integer.valueOf(m.group(1));
        String prob = m.group(2).replaceAll(" ", "_");        
        
        return String.format("L%04d_%s", id, prob);
    }
    
    private static String javaString(String filename) {
        StringBuilder sb = new StringBuilder();
        
        sb.append("package com.ray.LintCode;\r\n");
        sb.append("\r\n");        
        sb.append("public class ").append(filename).append(" {\r\n");
        sb.append("\r\n");
        sb.append("\r\n");
        sb.append("\r\n");
        sb.append("}\r\n");
        
        return sb.toString();
    }
    
    private static void writeToFile(String filename, String javaString) {
        String dir = Dir.getSourcePath(L_0000_Assistant.class);
        File f = new File(dir + filename + ".java");
        if (f.exists()) return;
        try (FileWriter fw = new FileWriter(f)) {
            fw.write(javaString);
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
    
    public static void createJavaFileFromTitle(String title) {
        String filename = getFileName(title);
        String javaString = javaString(filename);
        writeToFile(filename, javaString);
        Out.p(javaString);
    }
    
}
