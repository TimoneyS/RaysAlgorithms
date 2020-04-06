package com.ray.LintCode.tostudy;

import com.ray.io.Out;

/**
 * 描述：
 *      给定 n 个不重复的正整数，和一个整数 k 和数字 target
 *      寻找 k 个数字，和是 target
 *      计算有多少个解答
 *
 * 用例：
 *      Input  : List = [1,2,3,4], k = 2, target = 5
 *      Output : 2
 *      Explanation: 1 + 4 = 2 + 3 = 5
 *
 * 难度： Hard
 *   
 * @author rays1
 * @link   https://www.lintcode.cn/problem/k-sum/description
 * @since  2019-07-11 18:30:05
 */
public class L_0089_k_Sum {
    /**
     * dp[x][y][z] 表示 从 x 开始，y个数，和为 z 的解法个数
     * dp[x][y][z] = dp[x+1][y][z] + dp[x+1][y-1][z-A[x]]
     *
     * 因为每次更新是 x+1 和 x 之间的变换，可以从三维空间节省到二维
     */
    static class Solution {
        public int kSum(int[] A, int k, int target) {
            int[][] dp = new int[k+1][target+1];
            dp[0][0] = 1;
            for (int n : A) {
                for (int i = k; i > 0; i--) {
                    for (int j = target; j >= n; j--) {
                        dp[i][j] = dp[i][j] + dp[i - 1][j - n];
                    }
                }
            }
            return dp[k][target];
        }
    }

    public static void main(String[] args) {
        int[] A = {1,3,6,9,10,13,16,17};
        int k = 3;
        int target = 33;
        Out.p(new Solution().kSum(A, k, target));
    }
}
