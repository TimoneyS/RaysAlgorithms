package com.ray.LintCode.temp;

import java.util.Arrays;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 *      
 *      Return 0 if the array contains less than 2 elements.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: [1, 9, 2, 5]
 *      Output: 4
 *      Explanation: The sorted form is [1, 2, 5, 9], and the maximum gap is between 5 and 9.
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: [1]
 *      Output: 0
 *      Explanation: The array contains less than 2 elements.
 *      ```
 *
 * 挑战：
 *      Sort is easy but will cost O(nlogn) time. Try to solve it in linear time and space.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/maximum-gap/description
 * @date   2019-07-11 18:32:33
 */
public class L_0400_Maximum_Gap {

    static class Solution {
        /**
         * @param nums: an array of integers
         * @return: the maximum difference
         */
        public int maximumGap(int[] nums) {
            Arrays.sort(nums);
            
            int max = 0;
            for(int i = 1; i < nums.length; i++) {
                int gep = nums[i] - nums[i-1];
                if(gep > max) max = gep;
            }
            return max;
            
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
