package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * 调整数组顺序使奇数位于偶数前面 LCOF
 * -----------------------------------------------------------------------------
 * English description is not available for the problem. Please switch to Chinese.
 *
 * Example:
 *      
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * @since   2020-03-27 22:56:08
 */
public class L100291_调整数组顺序使奇数位于偶数前面_LCOF {
    static class Solution {
        public int[] exchange(int[] nums) {
            int l = 0, r = nums.length - 1;
            while (l < r) {
                while (l < r && (nums[l] & 1) == 1) l ++;
                while (l < r && (nums[r] & 1) == 0) r --;
                int t = nums[l];
                nums[l] = nums[r];
                nums[r] = t;
            }
            return nums;
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        Out.p(new Solution().exchange(nums));
    }
}
