package com.ray.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class In {
    
    /**
     * 
     * @param res
     * @return
     */
    public static Scanner getProjectScanner(String res) {
        Scanner in = null;
        try {
            in = new Scanner(new File(res));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return in;
    }
    
    public static Scanner getClassPathScanner(String res) {
        Scanner in = null;
        String path = In.class.getClassLoader().getResource(res).getFile();
        try {
            in = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return in;
    }
}
