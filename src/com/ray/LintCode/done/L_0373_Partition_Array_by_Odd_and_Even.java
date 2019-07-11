package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Partition an integers array into odd number first and even number second.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```plain
 *      Input: [1,2,3,4]
 *      Output: [1,3,2,4]
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```plain
 *      Input: [1,4,2,3,5,6]
 *      Output: [1,3,5,4,2,6]
 *      ```
 *
 * 挑战：
 *      Do it in-place.
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/partition-array-by-odd-and-even/description
 * @date   2019-07-11 18:32:17
 */
public class L_0373_Partition_Array_by_Odd_and_Even {


    static class Solution {
        
        public void partitionArray(int[] nums) {
            int l = 0;
            int r = nums.length-1;
            while (l < r) {
                while (l < nums.length && !isOdd(nums[l])) l++;
                while (r >= 0 && isOdd(nums[r])) r--;
                
                if (l >= nums.length || r <= 0 || l >= r) break;
                int t = nums[r];
                nums[r] = nums[l];
                nums[l] = t;
            }
        
        }
        
        public boolean isOdd(int n) {
            return n % 2 == 0;
        }
        
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
