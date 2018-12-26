package com.ray.LintCode.resolved;

/**
 * 检测两个字符串的是否由相同的字符组成，字符的顺序可以不一致。 
 *  
 * @author rays1
 *
 */
public class L_0158_Valid_Anagram {

    class Solution {
        
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

}
