package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Guess Number Higher or Lower II
 * -----------------------------------------------------------------------------
 * 我们正在玩一个猜数游戏，游戏规则如下：
 *      我从 1 到 n 之间选择一个数字，你来猜我选了哪个数字。
 *      每次你猜错了，我都会告诉你，我选的数字比你的大了或者小了。
 *      然而，当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。直到你猜到我选的数字，你才算赢得了这个游戏。
 *
 * Example :
 *      n = 10, I pick 8.
 *      First round:  You guess 5, I tell you that it's higher. You pay $5.
 *      Second round: You guess 7, I tell you that it's higher. You pay $7.
 *      Third round:  You guess 9, I tell you that it's lower. You pay $9.
 *      Game over. 8 is the number I picked.
 *      You end up paying $5 + $7 + $9 = $21.
 *      Given a particular n &ge; 1, find out how much money you need to have to guarantee a win.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii/
 * @since   2020-03-17 23:28:39
 */
public class L0375_Guess_Number_Higher_or_Lower_II {
    /**
     * 设 dp[i][j] 表猜测 i j 之间的数字，所需的最小金额
     *
     * 在 i j 中有多种猜法，如果猜测的数字是 k
     *      那么如果猜中，消耗金额就是 0
     *      如果猜测不中，就要从左侧或者右侧猜测，并且支付 k，消耗就是
     *          左侧： dp[i][k-1] + k
     *          右侧:  dp[k+1][j] + k
     *
     * 然后，因为我们要考虑最坏的情况，所以每次猜测数字 k 的时候消耗值就是
     *          max {0, dp[k+1][j] + k, dp[i][k-1] + k}
     * 简化一下就是
     *          max {dp[k+1][j], dp[i][k-1]} + k
     *
     * 然后 i j 之间，k 有多种猜法，每种猜法我们都预估最坏的情况，所有最坏的情况中，再去取最好的可能
     *          dp[i][j] = min { max {dp[k+1][j], dp[i][k-1]} } k ∈ (i, j)
     *
     */
    static class Solution {
        public int getMoneyAmount(int n) {
            int[][] dp = new int[n+2][n+2];
            for (int d = n; d >= 1; d --) {
                for (int i = 1; i <= d; i ++) {
                    int  j = i + n - d;
                    dp[i][j] = i == j ? 0 : Integer.MAX_VALUE;
                    for (int k = i; k <= j; k ++) {
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[i][k-1], dp[k+1][j]) + k);
                    }
                }
            }
            return dp[1][n];
        }
    }
    
    public static void main(String[] args) {
        int n = 10;
        Out.p(new Solution().getMoneyAmount(n));
    }
}
