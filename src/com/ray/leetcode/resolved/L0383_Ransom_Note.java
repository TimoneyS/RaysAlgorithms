package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Ransom Note
 * -----------------------------------------------------------------------------
 * 
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom 
 * note can be constructed from the magazines ; otherwise, it will return false. 
 * Each letter in the magazine string can only be used once in your ransom note.
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 *
 * Example:
 *      
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/ransom-note/
 * @since   2020-03-23 21:57:11
 */
public class L0383_Ransom_Note {
    static class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] c =  new int[26];
            int t = 0;
            for (int i = 0; i < ransomNote.length(); i++) {
                if (c[ransomNote.charAt(i) - 'a'] == 0) t ++;
                c[ransomNote.charAt(i) - 'a'] ++;
            }

            for (int i = 0; i < magazine.length(); i++) {
                if (c[magazine.charAt(i) - 'a'] == 1) t --;
                c[magazine.charAt(i) - 'a'] --;
            }
            return t == 0;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
