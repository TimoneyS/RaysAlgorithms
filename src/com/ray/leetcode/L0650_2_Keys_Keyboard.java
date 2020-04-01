package com.ray.leetcode;

import com.ray.io.Out;

/**
 * 2 Keys Keyboard
 * -----------------------------------------------------------------------------
 * 最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作：
 *      Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。
 *      Paste (粘贴) : 你可以粘贴你上一次复制的字符。
 * 给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。输出能够打印出 n 个 'A' 的最少操作次数。
 *
 * Example:
 *      Example 1
 *      Input: 3
 *      Output: 3
 *      Explanation:
 *      Intitally, we have one character 'A'.
 *      In step 1, we use Copy All operation.
 *      In step 2, we use Paste operation to get 'AA'.
 *      In step 3, we use Paste operation to get 'AAA'.
 *      Note:
 *      	The n will be in the range [1, 1000].
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/2-keys-keyboard/
 * @since   2020-04-01 22:18:26
 */
public class L0650_2_Keys_Keyboard {
    /**
     * dp[i] 表示得到 i 个所需最小次数
     *
     *
     *
     */
    static class Solution {
        public int minSteps(int n) {
            int[] dp = new int[n+1];
            for (int i = 2; i <= n; i++) {
                dp[i] = i;
                for (int j = i-1; j > 1; j--) {
                    if (i % j == 0) {
                        dp[i] = dp[j] + (i/j);
                        break;
                    }
                }
            }
            return dp[n];
        }
    }
    
    public static void main(String[] args) {
        int n = 13;
        Out.p(new Solution().minSteps(n));
    }
}
