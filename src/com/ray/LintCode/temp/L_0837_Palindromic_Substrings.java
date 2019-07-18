package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a string, your task is to count how many palindromic substrings in this string.
 *      The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: "abc"
 *      Output: 3
 *      Explanation:
 *      3 palindromic strings: "a", "b", "c".
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: "aba"
 *      Output: 4
 *      Explanation:
 *      4 palindromic strings: "a", "b", "a", "aba".
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/palindromic-substrings/description
 * @date   2019-07-11 18:37:18
 */
public class L_0837_Palindromic_Substrings {

    /**
     * 每个位置 i 统计以 i 为中心，以i,i+1 为中心的回文数
     * @author rays1
     *
     */
    static class Solution {
    
        public int countPalindromicSubstrings(String str) {
            int c = 0;
            for (int i = 0; i < str.length(); i++)
                c += paliNum(str, i);
            return c;
        }
        
        int paliNum(String str, int i) {
            int c = 0;
            int l = i, r = i;
            while (l >= 0 && r < str.length() && str.charAt(l--) == str.charAt(r++)) c++;
            l = i; r = i+1;
            while (l >= 0 && r < str.length() && str.charAt(l--) == str.charAt(r++)) c++;
            return c;            
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
