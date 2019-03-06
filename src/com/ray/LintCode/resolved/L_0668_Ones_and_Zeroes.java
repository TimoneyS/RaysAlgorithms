package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 
 * 在计算机世界中，人们追求的是使用受限制的资源来获取最大的利益。
 * 给定 m 个 0 和 n 个 1，和一个01构成的字符串的数组，找到可以用 m 个0 和 n个1 构成的字符串的最大个数。
 * 每个 0 和 1 只能使用一次。
 *
 * @author rays1
 *
 */
public class L_0668_Ones_and_Zeroes {

    /**
     * 标准动态规划。
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        int[] c0, c1;
        int[][][] mem;
        
        public int findMaxForm(String[] strs, int m, int n) {
            c0 = new int[strs.length];
            c1 = new int[strs.length];
            for (int i = 0; i < strs.length; i++) {
                for (int j = 0; j < strs[i].length(); j++)
                    if (strs[i].charAt(j) == '0') c0[i] ++;
                    else                          c1[i] ++;
            }
            mem = new int[strs.length+1][m+1][n+1];
            return dp(strs, 0, m, n);
        }
        
        int dp(String[] strs, int start, int m, int n) {
            if (start >= strs.length || m < 0 || n < 0) return 0;
            
            if (mem[start][m][n] == 0) {
                if (m < c0[start] || n < c1[start]) {
                    mem[start][m][n] = dp(strs, start+1, m, n);
                } else {
                    mem[start][m][n] = Math.max(
                            1+dp(strs, start+1, m-c0[start], n-c1[start]),
                            dp(strs, start+1, m, n));
                }
            }
            return mem[start][m][n];
        }
    
    }
    
    public static void main(String[] args) {
        
        String[] strs = {"10","0001","111001","1","0"};
        int m = 5;
        int n = 3;
        
        Out.p(new Solution().findMaxForm(strs, m, n));
        
    }

}
