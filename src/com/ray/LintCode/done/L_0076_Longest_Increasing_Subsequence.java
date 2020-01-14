package com.ray.LintCode.done;

import java.util.Arrays;

import com.ray.io.Out;

/**
 * 描述：
 *      给定一个整数序列，找到最长升序的子序列（LIS），返回LIS的长度。
 * 用例：
 *      Example 1:
 *      	Input: [4,2,4,5,3,7]
 *      	Output:  4
 *      	Explanation:
 *      	LIS is [2,4,5,7]
 * 挑战：
 *      <p>Time complexity O(n^2) or O(nlogn)</p>
 * 链接： https://www.lintcode.cn/problem/longest-increasing-subsequence/description
 * 难度： Medium
 *
 * @author rays1
 * @since   2019-07-11 18:29:53
 */
public class L_0076_Longest_Increasing_Subsequence {
    /**
     * top 记录当前能够生成的各种长度的序列的最小终点元素, top[0] 表示长度为 1 的序列中最小的终点元素
     *
     * 如果一个 num 比 top 中最大的元素top[x]大，那么说明 num 比最长的序列的最大元素还大
     * 那么 num + 序列 x 构成的新序列将更长，那么可以令 top[x+1] = num
     *
     * 如果 num 位于 top 中的 top[i] 和 top[j] 之间，说明 num + 序列 i 构成的新序列比序列 j 更优（长度一样，终点更小）
     * 则更新 top[j] = num
     */
    static class Solution {
        public int longestIncreasingSubsequence(int[] nums) {
            int len = 0;
            int[] top = new int[nums.length+1];
            for (int num : nums) {
                int idx = Arrays.binarySearch(top, 0, len, num);
                if (idx < 0) idx = - idx - 1;
                top[idx] = num;
                if (idx == len) len ++;
            }
            return len;
        }
    }
    
    public static void main(String[] args) {
        
        int[] nums = {9,3,6,2,7};
        
        Out.p(new Solution().longestIncreasingSubsequence(nums));
    }
}
