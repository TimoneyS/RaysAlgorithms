package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 寻找旋转数组中的最小值，数组有重复数字
 *
 * @author rays1
 *
 */
public class L_0160_Find_Minimum_in_Rotated_Sorted_Array_II {

    static class Solution {
        
        public int findMin(int[] nums) {
            return nums[findMin(nums, 0, nums.length-1)];
        }
        
        public int findMin(int[] nums, int l, int r) {
            if (nums[l] < nums[r] || l == r) return l;
            int mid = (l+r)/2;
            if (nums[mid] > nums[r]) {
                // 向右找
                return findMin(nums, mid+1, r);
            } else if (nums[mid] < nums[r]) {
                return findMin(nums, l, mid);
            } else {
                // 向左找
                int i = findMin(nums, l, mid);
                int j = findMin(nums, mid+1, r);
                if (nums[i] < nums[j])
                    return i;
                else
                    return j;
            }
        }
        
    }
    
    public static void main(String[] args) {
        int[] nums = { 5, 5, 5, 5, 1, 5, 5 };
        int r = new Solution().findMin(nums);
        Out.p(r);
    }

}
