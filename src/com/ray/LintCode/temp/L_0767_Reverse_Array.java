package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Reverse the given array `nums` inplace.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input : nums = [1,2,5]
 *      Output : [5,2,1]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/reverse-array/description
 * @date   2019-07-11 18:36:28
 */
public class L_0767_Reverse_Array {

    static class Solution {
        /**
         * @param nums: a integer array
         * @return: nothing
         */
        public void reverseArray(int[] nums) {
            int n = nums.length;
            if (n == 0) return;
            for (int i = 0; i < n/2; i++) {
                int t= nums[i];
                nums[i] = nums[n-i-1];
                nums[n-i-1] = t;
            }
            
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
