package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Write a method `anagram(s,t)` to decide if two strings are anagrams or not.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: s = "ab", t = "ab"
 *      Output: true
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input:  s = "abcd", t = "dcba"
 *      Output: true
 *      ```
 *      
 *      **Example 3:**
 *      
 *      ```
 *      Input:  s = "ac", t = "ab"
 *      Output: false
 *      ```
 *
 * 挑战：
 *      O(n) time, O(1) extra space
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/valid-anagram/description
 * @date   2019-07-11 18:31:20
 */
public class L_0158_Valid_Anagram {

    static     class Solution {
        
        public boolean anagram(String s, String t) {
            if (s.length() != t.length()) return false;
            
            int[] count = new int[256];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i)] ++;
            }
            
            for (int i = 0; i < t.length(); i++) {
                count[t.charAt(i)] --;
                if (count[t.charAt(i)] < 0) return false;
            }
            return true;
        }
        
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
