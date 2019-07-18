package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.
 *      
 *      For now, suppose you are a dominator of m `0s` and n `1s` respectively. On the other hand, there is an array with strings consisting of only `0s` and `1s`.
 *      
 *      Now your task is to find the maximum number of strings that you can form with given m `0s` and n `1s`. Each `0` and `1` can be used at most once.
 *
 * 用例：
 *      **Example1**
 *      ```
 *      Input:
 *      ["10", "0001", "111001", "1", "0"]
 *      5
 *      3
 *      Output: 4
 *      Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are "10", "0001", "1", "0"
 *      ```
 *      **Example2**
 *      ```
 *      Input:
 *      ["10", "0001", "111001", "1", "0"]
 *      7
 *      7
 *      Output: 5
 *      Explanation: All strings can be formed by the using of 7 0s and 7 1s.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/ones-and-zeroes/description
 * @date   2019-07-11 18:35:18
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
        
        Out.p(new Solution());
        
    }

}
