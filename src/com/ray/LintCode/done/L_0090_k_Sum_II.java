package com.ray.LintCode.done;

import java.util.ArrayList;
import java.util.List;

import com.ray.io.Out;
import com.ray.util.Timer;

/**
 * 描述：
 *      给定 n 个不重复的正整数，和数字 k 和 target
 *      寻找所有可能的和是target 的 k 个数字
 *
 * 用例：
 *      **Example 1:**
 *      Input: [1,2,3,4], k = 2, target = 5
 *      Output:  [[1,4],[2,3]]
 *
 *      **Example 2:**
 *      Input: [1,3,4,6], k = 3, target = 8
 *      Output:  [[1,3,4]]
 *
 * 难度： Medium
 *   
 * @author rays1
 * @link   https://www.lintcode.cn/problem/k-sum-ii/description
 * @since  2019-07-11 18:30:06
 */
public class L_0090_k_Sum_II {
    /**
     * 参考 L_0089_k_Sum
     * dp[x][y][z] 表示 从 x 开始，y个数，和为 z 的解法个数
     * dp[x][y][z] = dp[x+1][y][z] + dp[x+1][y-1][z-A[x]]
     * 这里存储的元素从数值变为列表，然后加法变为集合的合并操作
     *
     * 因为每次更新是 x+1 和 x 之间的变换，可以从三维空间节省到二维
     */
    static class Solution {
        public List<List<Integer>> kSumII(int[] A, int k, int target) {
            List<List<Integer>>[][] dp = new List[k+1][target+1];
            dp[0][0] = new ArrayList<>();
            dp[0][0].add(new ArrayList<>());
            for (int n : A) {
                for (int i = k; i > 0; i--) {
                    for (int j = target; j >= n; j--) {
                        if (dp[i - 1][j - n] != null) {
                            for (List<Integer> l : dp[i - 1][j - n]) {
                                List<Integer> t = new ArrayList<>(l);
                                t.add(n);
                                if (dp[i][j] == null)
                                    dp[i][j] = new ArrayList<>();
                                dp[i][j].add(t);
                            }
                        }
                    }
                }
            }
            return dp[k][target];
        }
    }

    public static void main(String[] args) {
        int[] A = {1,3,4,6,9,10,12,14,16,19,22,25,26,27,28,29,30,31,32,33,34,35,36,37,38};
        int k = 5;
        int target = 55;
        Timer.CLICK();
        Out.p(new Solution().kSumII(A, k, target));
        Timer.STOP();
    }
}
