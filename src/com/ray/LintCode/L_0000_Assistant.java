package com.ray.LintCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ray.io.Dir;
import com.ray.io.Out;

public class L_0000_Assistant {
    
    static String dir = Dir.getSourcePath(L_0000_Assistant.class);
    static String place_class_name = "Lintcode_name";
    static String place_data_string = "Date_String";
    
    private static String getFileName(String title) {
        
        Pattern p = Pattern.compile("^(\\d+)\\.\\s+(.*\\S)\\s*$");
        Matcher m = p.matcher(title);
        m.find();
        
        int id = Integer.valueOf(m.group(1));
        String prob = m.group(2).replaceAll(" ", "_");        
        
        return String.format("L_%04d_%s", id, prob);
    }
    
    private static String javaString(String filename) {
        StringBuilder sb = readFromFile("model.ini");
        
        int start = sb.indexOf(place_class_name);
        sb.replace(start, start + place_class_name.length(), filename);
        
        start = sb.indexOf(place_data_string);
        sb.replace(start, start + place_data_string.length(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        
        return sb.toString();
    }
    
    private static StringBuilder readFromFile(String filename) {
        StringBuilder sb = new StringBuilder();
        try (Scanner sc = new Scanner(new File(dir + filename))) {
            while (sc.hasNextLine()) {
                sb.append(sc.nextLine()).append("\r\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sb;
    }
    
    private static void writeToFile(String filename, String javaString) {
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
    
    public static void main(String[] args) throws IOException {
        
        byte[] bytes = new byte[100];
        System.in.read(bytes);
        
        int i = 0;
        for (byte b : bytes) {
            i ++;
            if (b == 13) break;
        }
        String title = new String(bytes, 0, i+1);
        
        title = title.replaceAll("[\\(\\)]", "");
        
        createJavaFileFromTitle(title);
    }
    
}
