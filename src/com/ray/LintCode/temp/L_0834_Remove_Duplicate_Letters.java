package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a string `s` which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: s = "bcabc"
 *      Output: "abc"
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: s = "cbacdcbc"
 *      Output: "acdb"
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/remove-duplicate-letters/description
 * @date   2019-07-11 18:37:15
 */
public class L_0834_Remove_Duplicate_Letters {

    /**
     * 字典序最小表示，越小的字符串越靠前
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public String removeDuplicateLetters(String s) {
            int[] count = new int[26];
            for (int i = 0; i < s.length();i++) count[s.charAt(i)-'a'] ++;
            
            boolean[] marked = new boolean[26];
            StringBuilder sb = new StringBuilder();
            int l = 0;
            for (int i = 0; i < s.length();i++) {
                char c = s.charAt(i);
                count[c-'a'] --;
                if (marked[c - 'a']) continue;
                
                while (l > 0 && c <= sb.charAt(l-1) && count[sb.charAt(l-1)-'a'] > 0) {
                    marked[sb.charAt(l-1)-'a'] = false;
                    sb.deleteCharAt(l-1);
                    l --;
                }
                
                sb.append(c);
                l++;
                marked[c-'a'] = true;
            }
            
            return sb.toString();
        }
        
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
