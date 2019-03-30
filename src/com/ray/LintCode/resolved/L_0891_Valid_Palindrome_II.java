package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 *
 * @author rays1
 * @url    https://www.lintcode.com/problem/valid-palindrome-ii/description
 * @date   2019-03-30 18:20:20
 */
public class L_0891_Valid_Palindrome_II {

    /**
     * 直接检测是否是回文，如果不是，则再检测到不是回文的提放，分别跳过左侧和右侧再检测
     * @author rays1
     *
     */
    static class Solution {
    
        public boolean validPalindrome(String s) {
            int i = 0, j = s.length()-1;
            while (i < j && s.charAt(i++) == s.charAt(j--)) {
                
            }
            if (i < j) {
                return isPal(s, i+1, j) || isPal(s, i, j-1);
            } else {
                return true;
            }
        }
        
        public boolean isPal(String s, int i, int j) {
            while (i < j) {
                if (s.charAt(i++) != s.charAt(j--)) return false;
            }
            return true;
        }
        
    }
    
    public static void main(String[] args) {
        String s = "abca";
        
        Out.p(new Solution().validPalindrome(s));
        
    }

}
