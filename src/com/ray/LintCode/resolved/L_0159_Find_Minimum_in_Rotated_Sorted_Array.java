package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 寻找旋转数组中的最小值，数组没有重复数字
 *
 * 例如 : [4, 5, 6, 7, 0, 1, 2] -> 0
 * @author rays1
 *
 */
public class L_0159_Find_Minimum_in_Rotated_Sorted_Array {

    static class Solution {
        public int findMin(int[] nums) {
            return nums[findMin(nums, 0, nums.length-1)];
        }
        
        public int findMin(int[] nums, int l, int r) {
            if (l == r) return l;
            int mid = (l+r)/2;
            if (nums[mid] > nums[r]) {
                // 向右找
                return findMin(nums, mid+1, r);
            } else {
                // 向左找
                return findMin(nums, l, mid);
            }
        }
        
    }
    
    public static void main(String[] args) {
        int[] nums = { 11, 13, 16, 18, 5, 7, 9 };
        int r = new Solution().findMin(nums);
        Out.p(r);
    }

}
