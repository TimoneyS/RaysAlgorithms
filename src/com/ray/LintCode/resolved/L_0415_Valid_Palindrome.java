package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 *
 * 给定一个字符串，确定它是否是回文，只考虑字母数字字符并忽略大小写。
 * 
 * 如：
 *      "A man, a plan, a canal: Panama"  是回文
 *      "race a car" is not a palindrome. 不是回文
 * @author rays1
 *
 */
public class L_0415_Valid_Palindrome {

    /**
     * 双指针法，左右并进，掠过非字母和数字，分别比较遇到的第一个符合要求的字符。
     * @author rays1
     *
     */
    static class Solution {
    
        public boolean isPalindrome(String s) {
            
            int l = 0, r = s.length() -1;
            
            while (l < r) {
                
                while (l < s.length() && !isCheck(s.charAt(l))) l ++;
                while (r >= 0         && !isCheck(s.charAt(r))) r --;
                
                Out.pf("%s == %s\n", s.charAt(r), s.charAt(l));
                if (l < r && !isMatch(s.charAt(r--), s.charAt(l++))) {
                    return false;
                } 
                
            }
            
            return true;
        }
        
        boolean isCheck(char c) {
            return c >= '0' && c <= '9' || c >= 'A' && c < 'Z' || c >= 'a' && c < 'z';
        }
        
        boolean isMatch(char c1, char c2) {
            if (c1 >= 'A' && c1 < 'Z') c1 = (char) (c1 - 'A' + 'a');
            if (c2 >= 'A' && c2 < 'Z') c2 = (char) (c2 - 'A' + 'a');
            return c1 == c2;
        }
    
    }
    
    public static void main(String[] args) {
        
        String s = "A man, a plan, a canal: Panama";
        
        Out.p(new Solution().isPalindrome(s));
        
    }

}
