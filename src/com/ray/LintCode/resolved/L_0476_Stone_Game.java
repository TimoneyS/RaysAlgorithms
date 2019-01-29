package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 *
 * 石头游戏。起初玩家将 n 堆石头放到一条线上。
 * 每次将相邻的两堆石头合并成一堆，合并后的堆中的石头的数量就是分数。
 * 目标时为了拿到最少的分数，寻找一个最优的合并计划。
 *
 * 例如：4, 1, 1, 4  最少的分数是 18
 *      合并第二和第三堆  4, 1, 1, 4 -> 4, 2, 4   得分 2
 *      合并第一和第二堆        4, 2, 4 -> 6, 4      得分 6
 *      合并第一和第二堆              6, 4 -> 10        得分 10      
 *
 * @author rays1
 *
 */
public class L_0476_Stone_Game {
    
    /**
     * 动态规划解决
     * 
     * 先计算出 所有位置的和，复杂度为 O(n^2)
     * score(i, j) = min { score(i, k) + score(k+1, j) + sum(i,j) } ( i <= k < j)
     * 
     * 具体的非动态规划的方法以后研究
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
        
        int[] A = {4, 4, 5, 9};
        
        Out.p(new Solution().stoneGame(A));
        
    }

}
