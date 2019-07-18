package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a string, count number of subsequences of the form `a^i b^j c^ k`, i.e., it consists of i `a` characters, followed by j `b` characters, followed by k `c` characters where i >= 1, j >=1 and k >= 1.
 *      
 *      Note: Two subsequences are considered different if the set of array indexes picked for the 2 subsequences are different.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: s = "abbc"
 *      Output: 3
 *      Explanation: 
 *      Subsequences are "abc", "abc" and "abbc"
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: s = "abcabc"
 *      Output: 7
 *      Explanation: 
 *      Subsequences are "abc", "abc", "abbc", "aabc", "abcc", "abc" and "abc"
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/number-of-subsequences-of-form-ai-bj-ck/description
 * @date   2019-07-11 18:35:54
 */
public class L_0734_Number_of_Subsequences_of_Form_ai_bj_ck {
    
    /**
     * dp[i][char] 表示从 i 开始 以 char 开始的子序列个数
     * 
     * 如果 第 i 位是 a 表示 以 a 为首的子序列个数会变化
     *      以 a 为首的子序列
     *          包含之前以 b 为首的子序列加上当前的 a
     *          之前以 a 为首的子序列
     *          之前以 a 为首的子序列加上当前的 a
     *     dp[i][a] = dp[i+1][b] + dp[i+1][a] * 2
     * 
     * 如果 第 i 位是 b 表示 以 b 为首的子序列个数会变化
     *      以 b 为首的自序列和 a 同理
     *      dp[i][b] = dp[i+1][c] + dp[i+1][b] * 2
     *      
     * 如果 第 i 位是 c 表示 以 c 为首的子序列个数会变化
     *      以 c 为首的子序列
     *          包含之前所有子序列，同时包含所有子序列加上当前的c
     *          同时包含一个独立的 c
     *      dp[i][c] = d[i-1][c] * 2 + 1    
     *  
     * 
     * dp[i][b] = dp[i+1][c] + dp[i+1][b]
     * dp[i][c] = dp[i+1][c]
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int countSubsequences(String source) {
            int dpa = 0, dpb = 0, dpc = 0;
            for (int i = source.length()-1; i >= 0; i--) {
                char c = source.charAt(i);
                if (c == 'a') {
                    dpa = dpa * 2 + dpb;
                } else if (c == 'b') {
                    dpb = dpb * 2 + dpc;                    
                } else { // c == 'c'
                    dpc = dpc * 2 + 1;
                }
            }
            return dpa;
        }
    
    }
    
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
