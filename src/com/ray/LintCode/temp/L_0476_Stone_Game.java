package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      There is a stone game.At the beginning of the game the player picks `n` piles of stones in a line.
 *      
 *      The goal is to merge the stones in one pile observing the following rules: 
 *      
 *      1. At each step of the game,the player can merge two adjacent piles to a new pile.
 *      2. The score is the number of stones in the new pile. 
 *      
 *      You are to determine the minimum of the total score.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: [3, 4, 3]
 *      Output: 17
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: [4, 1, 1, 4]
 *      Output: 18
 *      Explanation:
 *        1. Merge second and third piles => [4, 2, 4], score = 2
 *        2. Merge the first two piles => [6, 4]，score = 8
 *        3. Merge the last two piles => [10], score = 18
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/stone-game/description
 * @date   2019-07-11 18:33:25
 */
public class L_0476_Stone_Game {

    /**
     * 动态规划解决
     * 
     * 先计算出 所有位置的和，复杂度为 O(n^2)
     * score(i, j) = min { score(i, k) + score(k+1, j) + sum(i,j) } ( i <= k < j)
     * 
     * 具体的非动态规划的方法以后研究（也许不会再研究 哈哈）
     * 
     */
    static class Solution {
        
        int[][] sum;
        int[][] mem;
        
        public int stoneGame(int[] A) {
            
            if (A == null || A.length < 2) return 0;
            
            sum = new int[A.length][A.length];
            mem = new int[A.length][A.length];
            for (int i = 0; i < A.length; i++) sum[i][i] = A[i];
            for (int i = 0; i < A.length; i ++)
                for (int j = i + 1; j < A.length; j ++) sum[i][j] = sum[i][j-1] + A[j];
            return score(A, 0, A.length - 1);
        }
        
        public int score(int[] A, int start, int end) {
            
            if (end - start < 2) {
                if (end == start) return 0;
                else return A[start] + A[end];
            } else {
                if (mem[start][end] == 0) {
                    int score = Integer.MAX_VALUE;
                    for (int i = start; i < end; i ++) {
                        score = Math.min(score, score(A, start, i) + score(A, i+1, end) + sum[start][end]);
                    }
                    mem[start][end] = score;
                }
                return mem[start][end];
            }
        }
        
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
