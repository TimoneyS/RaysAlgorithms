package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * For a given sorted array (ascending order) and a target number,
 * find the first index of this number in O(log n) time complexity.
 * If the target number does not exist in the array, return -1.
 * @author rays1
 *
 */
public class L_0014_First_Position {
    
    static class Solution {
        /**
         * @param nums: The integer array.
         * @param target: Target to find.
         * @return: The first position of target. Position starts from 0.
         */
        public int binarySearch(int[] nums, int target) {
            // write your code here
            int l = 0, h = nums.length - 1;
            int index = -1;
            while (l <= h) {
                int mid = (l + h) / 2;
                if (target > nums[mid])
                    l = mid+1;
                else if (target < nums[mid])
                    h = mid-1;
                else {
                    h = mid;
                    index = mid;
                    if (h == l)
                        break;
                }
            }
            return index;
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] nums = {3, 3, 3, 3};
        
        int target = 3;
        
        Out.p(new Solution().binarySearch(nums, target));
        
    }
    
}
