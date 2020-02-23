package com.ray.algo.string;

import com.ray.io.Out;

/**
 * 暴力字符串搜索
 * @author rays1
 *
 */
public class BruteSearch {
    
    public static int search(String txt, String target) {
        int i = 0, j = 0;
        while (i <= txt.length()-target.length() && j < target.length()) {
            if (txt.charAt(i+j) != target.charAt(j++)) {
                j = 0;
                i ++;
            }
        }
        return j == target.length() ? i : -1;
    }
    
    public static void main(String[] args) {
        
        String txt = "aaaaab";
        String target = "aab";
        
        int i = search(txt, target);
        Out.p(i);
        
    }
    
}
