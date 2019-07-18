package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a unsorted array with integers, find the median of it. 
 *      
 *      A median is the middle number of the array after it is sorted. 
 *      
 *      If there are even numbers in the array, return the `N/2`-th number after sorted.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：[4, 5, 1, 2, 3]
 *      Output：3
 *      Explanation:
 *      After sorting，[1,2,3,4,5]，the middle number is 3
 *      ```
 *      **Example 2:**
 *      ```
 *      Input：[7, 9, 4, 5]
 *      Output：5
 *      Explanation:
 *      After sorting，[4,5,7,9]，the second(4/2) number is 5
 *      ```
 *
 * 挑战：
 *      <p>O(n) time.</p>
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/median/description
 * @date   2019-07-11 18:29:57
 */
public class L_0080_Median {

    static class Solution {
        
        /**
         * @param nums: A list of integers
         * @return: An integer denotes the middle number of the array
         */
        public int median(int[] nums) {
            return quickSelect(nums, (nums.length-1)/2, 0, nums.length-1);
        }
        
        public int quickSelect(int[] nums, int n, int s, int t) {
            
            int l = s + 1;
            int r = t;
            while (true) {
                while (r > s && nums[s] <= nums[r]) r --;
                while (l < t && nums[l] < nums[s]) l ++;
                if (r > l) swap(nums, r, l);
                else break;
            }
            swap(nums, r, s);
            
            if (r == n)
                return nums[r];
            else if (r > n)
                return quickSelect(nums, n, s, r-1);
            else 
                return quickSelect(nums, n, r+1, t);
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
