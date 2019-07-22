package com.ray.LintCode.tostudy;

import java.util.Arrays;

import com.ray.io.Out;

/**
 * 描述：
 *      There is a backpack with a capacity of `c`.
 *      There are `n` Class A items, the volume of the `i th` Class A item is `a[i]`, and the value of the item is the remaining capacity of the backpack after loading the item * `k1`.
 *      There are `m` Class B items, the volume of the `i th` Class B item is `b[i]`, and the value of the item is the remaining capacity of the backpack after loading the item * `k2`.
 *      Find the maximum value can be obtained.
 *      
 *      有一个容量为 c 的背包。
 *          有 n 个 A 类物品，第 i 个 A 类物品的体积为 a[i]，物品的价值为装入该物品后背包剩余容量 * k1。
 *          有 m 个 B 类物品，第 i 个 B 类物品的体积为 b[i]，物品的价值为装入该物品后背包剩余容量 * k2。
 *          求最大可以获得的价值。
 * 用例：
 *      用例 1:
 *          c = 7, a = [4, 3] b = [1,3,2], k1 = 3, k2 = 2
 *      输入:
 *          3 2 7 2 3
 *          [4,3]
 *          [1,3,2]
 *      输出:
 *          23
 *      解释:
 *          2 * (7-1)+2*(6-2) + 3 * (4-3) = 23
 *      
 *      **用例 2:**
 *      Given k1 = `1`,k2 = `2`,c = ` 5`,n = `1`,m = `1`,a = `[2]`,b = `[1]`，return `10`.
 *      输入:
 *      1 2 5 1 1
 *      [2]
 *      [1]
 *      输出:
 *      10
 *      解释:
 *      2 * (5-1)+1*(4-2) = 10
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/surplus-value-backpack/description
 * @date   2019-07-22 15:26:49
 */
public class L_0971_Surplus_Value_Backpack {

    /**
     * 对于 A 类物品和 B 类物品都是按体积从小到大放最优。
     * 因此设 dp[i] 代表A类的前i个物品，B类的前j个物品选择若干个可以得到的最大价值。
     * 
     * dp[i][j] = max{
     *                 dp[i - 1][j] + (c - suma[i] - sumb[j]) * k1,
     *                 dp[i][j - 1] + (c - suma[i] - sumb[j]) * k2
     *                 }
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public long getMaxValue(int k1, int k2, int c, int n, int m, int[] a, int[] b) {
            Arrays.sort(a);
            Arrays.sort(b);
            long [] Sa = new long[a.length];
            long [] Sb = new long[b.length];
            Sa[0] = a[0];
            Sb[0] = b[0];
            for (int i = 1; i < n; i++) {
                Sa[i] += Sa[i - 1] + a[i];
            }
            for (int i = 1; i < m; i++) {
                Sb[i] += Sb[i - 1] + b[i];
            }
            long ans = 0;
            long [][] dp = new long[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                dp[i][0] = dp[i - 1][0] + k1 * (c - Sa[i - 1]);
                if(ans < dp[i][0]) {
                    ans = dp[i][0];
                }
            }
            for (int i = 1; i <= m; i++) {
                dp[0][i] = dp[0][i - 1] + k2 * (c - Sb[i - 1]);
                if(ans < dp[0][i]) {
                    ans = dp[0][i];
                }
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (Sa[i - 1] + Sb[j - 1] > c) {
                        break;
                    }
                    long x = dp[i - 1][j] + k1 * (c - Sa[i - 1] - Sb[j - 1]);
                    long y = dp[i][j - 1] + k2 * (c - Sa[i - 1] - Sb[j - 1]);
                    dp[i][j] = Math.max(x, y);
                    ans = Math.max(ans, dp[i][j]);
                }
            }
            return ans;
        }
    
    }
    
    public static void main(String[] args) {
        
//            *          c = 7, a = [4, 3] b = [1,3,2], k1 = 3, k2 = 2
//            *      输入:
//            *          3 2 7 2 3
//            *          [4,3]
//            *          [1,3,2]
//                      2 * (7-1)+2*(6-2) + 3 * (4-3) = 23
        int k1 = 1;
        int k2 = 2;
        int c  = 1;
        int n  = 1;
        int m  = 1;
        int[] a = {1};
        int[] b = {1};
        
        Out.p(new Solution().getMaxValue(k1, k2, c, n, m, a, b));
        
    }

}
