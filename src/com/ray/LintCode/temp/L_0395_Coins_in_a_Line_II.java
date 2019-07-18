package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * n 个不同面值的硬币排成一线，两个玩家轮流拿一个或者两枚硬币。最终拿到的所有硬币的面值之和最大的玩家为胜利。
 * 判断玩家 1 是否能够胜利。
 * 
 * [1,2,2] -> true  玩家1胜利
 * [1,2,4] -> false 玩家2胜利
 * @author rays1
 *
 */
public class L_0395_Coins_in_a_Line_II {

    /**
     * dp[i] 表示玩家 1 从 i 开始比赛能够取得的最大钱数
     * 
     * 从 n-1 开始比赛，有一个硬币，全部拿走，dp[n-1] = V[n-1]
     * 从 n-2 开始比赛，有两个硬币，全部拿走，结果为 dp[n-2] = V[n-2] + V[n-1]
     * 从 n-3 开始比赛，有三个硬币，如果拿一个剩下两个肯定会被2全部拿走，所以要拿两个，结果为 dp[n-3] = V[n-3] + V[n-2]
     * 
     * 从 i 开始比赛，需要分情况讨论
     *          1. 拿走一个硬币 
     *                  此时 2 基于策略判断拿一定是希望自己拿走之后1能够拿到的硬币最少
     *                  2拿走1个，1能够拿走的硬币价值为 dp[i+2]
     *                  2拿走2个，1能够拿走的硬币价值为 dp[i+3]
     *                  2 会根据最小的dp来选择拿的数目
     *             因此1能够拿到的最大价值为 dp1 = V[i] + min {dp[i+2], dp[i+3]}
     *          2. 拿走两个硬币，同上
     *                  2拿走1个，1能够拿走的硬币价值为 dp[i+3]
     *                  2拿走2个，1能够拿走的硬币价值为 dp[i+4]
     *             因此1能够拿到的最大价值为 dp2 = V[i] + V[i+1] + min {dp[i+3], dp[i+4]}
     * 因此 1 选择拿取时应该选择最终拿取价值最大的策略
     *          dp[i] = max { dp1, dp2} = max{
     *              V[i] + min {dp[i+2], dp[i+3]},
     *              V[i] + V[i+1] + min {dp[i+3], dp[i+4]}
     *          }
     */
    static class Solution {
        
        public boolean firstWillWin(int[] V) {
            if (V.length <= 2) return true;
            int n = V.length, sum = 0;
            int[] dp = new int[n+1];
            
            dp[n - 1] = V[n - 1];
            dp[n - 2] = V[n - 2] + V[n - 1];
            dp[n - 3] = V[n - 3] + V[n - 2];
            
            for (int i = n - 4; i >= 0; --i) {
                dp[i] = Math.max(
                        V[i] + Math.min(dp[i + 2], dp[i + 3]),
                        V[i] + V[i + 1] + Math.min(dp[i + 3], dp[i + 4])
                );
            }
            for (int d : V) sum += d;
            return sum - dp[0] < dp[0];
        }
    }
    
    /**
     * 定义 f[i] 为玩家从i开始拿取，最终能得到的比另一个玩家多的硬币价值
     * 解法用了巧妙的翻转思想，因为无论 玩家1 或者 玩家2 都能从 f[i] 中获益
     * 
     * 如讨论位置 i 时，可能有两种情况
     *      1.玩家 1 拿取 1个
     *          玩家2能够得到的收益为 f[i-1]
     *          因此 f[i] = values[i] - f[i-1]
     *      2.玩家 1 拿取 2个
     *          玩家2能够得到的收益为 f[i-2]
     *          因此 f[i] = values[i] + values[i+1] - f[i-2]
     * 因此计算时只要考虑两种情况取得最大值即可
     *      f[i] = max { values[i] - f[i-1], values[i] + values[i+1] - f[i-2]}
     * 
     * @author rays1
     *
     */
    static class Solution1 {
        public boolean firstWillWin(int[] values) {
            int n = values.length;
            int[] f = new int[n + 1];
            
            f[n-1] = values[n-1] - f[n];
            for (int i = n - 2; i >= 0; i--){
                f[i] = Math.max(
                        values[i] - f[i + 1],
                        values[i] + values[i + 1] - f[i + 2]);
            }
            return f[0] >= 0;
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] values = {1, 2, 4, 3};
        
        Out.p(new Solution1().firstWillWin(values));
        
    }

}
