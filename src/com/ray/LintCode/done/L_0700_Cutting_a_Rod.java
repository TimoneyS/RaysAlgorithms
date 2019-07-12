package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a rod of length `n` inches and an array of prices that contains prices of all pieces of size smaller than `n`. Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 *
 * 用例：
 *      **Example1**
 *      ```
 *      Input:
 *      [1, 5, 8, 9, 10, 17, 17, 20]
 *      8
 *      Output: 22
 *      Explanation:
 *      length   | 1   2   3   4   5   6   7   8  
 *      --------------------------------------------
 *      price    | 1   5   8   9  10  17  17  20
 *      by cutting in two pieces of lengths 2 and 6
 *      ```
 *      **Example2**
 *      ```
 *      Input:
 *      [3, 5, 8, 9, 10, 17, 17, 20]
 *      8
 *      Output: 24
 *      Explanation:
 *      length   | 1   2   3   4   5   6   7   8  
 *      --------------------------------------------
 *      price    | 3   5   8   9  10  17  17  20
 *      by cutting in eight pieces of length 1.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/cutting-a-rod/description
 * @date   2019-07-11 18:35:38
 */
public class L_0700_Cutting_a_Rod {

    /**
     * 将钢条左侧切割下长度为i的一段，然后对右侧的钢条进行切割，左侧的钢条则不切割。
     * 则表示最优解的公式为
     *      dp[n] = max{v[i] + dp[n-i]} ( 1 < i <= n)
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int cutting(int[] prices, int n) {
            if (prices == null || prices.length == 0) return 0;
            
            int[] dp = new int[n+1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i] = Math.max(dp[i], dp[i-j] + prices[j-1]);
                }
            }
            return dp[n];
        }
        
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
