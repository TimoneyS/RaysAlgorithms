package com.rays.algo.string;

import com.ray.io.Out;

/**
 * 暴力字符串搜索
 * @author rays1
 *
 */
public class BruteSearch {
    
    public static int search(String txt, String target) {
        int i = 0, j = 0;
        while (i < txt.length() && j < target.length()) {
            if (txt.charAt(i++) != target.charAt(j++)) {
                i = i - j + 1;
                j = 0;
            }
        }
        return j == target.length() ? i-target.length() : -1;
    }
    
    public static void main(String[] args) {
        
        String txt = "abcdefg";
        String target = "i";
        
        int i = search(txt, target);
        Out.p(i);
        
    }
    
}
