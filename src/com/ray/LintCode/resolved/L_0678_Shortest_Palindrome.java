package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给定一个字符串 S，只允许在字符串之前加入字符来将其转换为一个回文字符串。
 * 返回转换后的最短的回文字符串
 *
 *  Find and return the shortest palindrome you can find by performing this transformation.
 *
 * @author rays1
 *
 */
public class L_0678_Shortest_Palindrome {

    /**
     * 先找到 从首位开始的回文长度，一般算法是 O(n^2)，也可以有线性算法。
     * 
     * 然后将除了回文以外的字符串反向加入 sb
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public String convertPalindrome(String str) {
            int index = find(str);
            StringBuilder sb = new StringBuilder();
            for (int i = str.length()-1; i > index; i--) sb.append(str.charAt(i));
            sb.append(str);
            return sb.toString();
        }

        int find (String str) {
            int l = 0, r = str.length() - 1;
            while (r > l) {
                if (str.charAt(r) == str.charAt(l)) {
                    l ++;
                    r --;
                } else {
                    r = r+l-1;
                    l = 0;
                }
            }
            return l + r;
        }
        
    }
    
    public static void main(String[] args) {
        // abcd     -> dcbabcd
        // aacecaaa -> aaacecaaa
        String str = "aacecaaa";
        
        Out.p(new Solution().convertPalindrome(str));
        
    }

}
