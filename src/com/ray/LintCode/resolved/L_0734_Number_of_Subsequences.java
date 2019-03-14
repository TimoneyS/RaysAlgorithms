package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 
 * 给一字符串, 对形式为 a^i b^j c^k 的子序列进行计数, 即它由 i 个字符 a, 接着是 j 个字符 b, 然后是 k 个字符 c组成, i >= 1, j >= 1, k >= 1.
 * Note: 如果两个子序列在原字符串中的index集合是不同的，则认为两个子序列不同。
 * 
 * @author rays1
 *
 */
public class L_0734_Number_of_Subsequences {
    
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
        
        String source = "bcbc";
        
        Out.p(new Solution().countSubsequences(source));
        
    }

}
