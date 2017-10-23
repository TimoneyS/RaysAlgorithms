package com.ray.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class In {
    
    public static Scanner getScanner(String res) {
        Scanner in = null;
        try {
            in = new Scanner(new File(res));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return in;
    }
    
}
