package com.ray.LintCode.temp;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.ray.io.In;
import com.ray.io.Out;
import com.ray.util.Timer;

/**
 * 描述：
 *      Given a string s and a dictionary of words dict, determine if s can be break into a space-separated sequence of one or more dictionary words.
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input:  "lintcode", ["lint", "code"]
 *      	Output:  true
 *      
 *      Example 2:
 *      	Input: "a", ["a"]
 *      	Output:  true
 *      	
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/word-break/description
 * @date   2019-07-11 18:30:38
 */
public class L_0107_Word_Break {

    static class Solution {
        
        boolean[] canBreak;
        
        /*
         * @param s: A string
         * @param dict: A dictionary of words dict
         * @return: A boolean
         */
        public boolean wordBreak(String s, Set<String> dict) {
            if (s.length() == 0) return true;
            if (dict.size() == 0) return false;
            canBreak = new boolean[s.length()];
            int m = -1;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = m; j >= -1; j --) {
                    if (j != -1 && !canBreak[j]) continue;
                    if(isInDict(s, j+1, i, dict)){
                        m = i-1;
                        canBreak[m] = true;
                        break;
                    }
                }
            }
            return canBreak[s.length()-1];
        }
        
        public boolean isInDict(String tar, int s, int t, Set<String> dict) {
            
            boolean rs = false;
            for (String src : dict) {
                if (src.length() != t - s) continue;
                int matchIndex = s;
                while (matchIndex < t) {
                    if (tar.charAt(matchIndex) != src.charAt(matchIndex-s)) break;;
                    matchIndex ++;
                }
                if (matchIndex == t) {
                    rs = true;
                    break;
                }
            }
            
            Out.pf("isInDict(%s, %s) = %s\n", s, t, rs);
            return rs;
        }
        
    }
    
    public static String builderFromFile(Set<String> dict) {
        Scanner sc = In.getClassPathScanner(L_0107_Word_Break.class, "L_0107_Word_Break.in");
        String s = sc.nextLine();
        
        sc.useDelimiter(",");
        while (sc.hasNext()) {
            dict.add(sc.next());
        }
        return s;
    }
    
    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        
//        String s = builderFromFile(dict);
        
        String s = "abcde";
        String[] arr = {"aaaa", "aaa"};
        for (String string : arr) dict.add(string);
        
        Out.p(s.length());
        Out.p(dict);
        
        Timer.CLICK();
        Out.p(new Solution().wordBreak(s, dict));
        Timer.STOP();
    }
}
