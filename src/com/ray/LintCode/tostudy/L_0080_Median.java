package com.ray.LintCode.tostudy;

import com.ray.io.Out;

/**
 * 描述：
 *      无序数组，寻找中位数
 *
 * 用例：
 *      **Example 1:**
 *      Input：[4, 5, 1, 2, 3]
 *      Output：3
 *
 *      **Example 2:**
 *      Input：[7, 9, 4, 5]
 *      Output：5
 *
 * 挑战：
 *      <p>O(n) time.</p>
 *
 * 难度： Simple
 *
 * @author rays1
 * @link   https://www.lintcode.cn/problem/median/description
 * @since  2019-07-11 18:29:57
 */
public class L_0080_Median {
    /**
     * 快速选择算法
     *
     * 随机选择一个数字分割数组，保证左边的数字小于该数字，右边的数字大于该数字
     * 如果该数字恰好是中位数，则找到数字，否则在右半部分或左半部分找。
     */
    static class Solution {
        public int median(int[] nums) {
            return quickSelect(nums, (nums.length-1)/2, 0, nums.length-1);
        }

        public int quickSelect(int[] nums, int n, int l, int r) {
            int i = l + 1;
            int j = r;
            while (true) {
                while (j > l && nums[l] <= nums[j]) j --;
                while (i < r && nums[i] < nums[l]) i ++;
                if (j > i) swap(nums, j, i);
                else break;
            }
            swap(nums, j, l);
            if (j == n)
                return nums[j];
            else if (j > n)
                return quickSelect(nums, n, l, j-1);
            else
                return quickSelect(nums, n, j+1, r);
        }

        private void swap(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,-2,0,-3,-4,0,0,0};
        Out.p(new Solution().median(nums));
    }
}
