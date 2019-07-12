package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a `non-empty` array containing `only positive integers`, find if the array can be partitioned into `two` subsets such that the sum of elements in both subsets is equal.
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input: nums = [1, 5, 11, 5], 
 *      Output: true
 *      Explanation:
 *      two subsets: [1, 5, 5], [11]
 *      ```
 *      Example 2:
 *      ```
 *      Input: nums = [1, 2, 3, 9], 
 *      Output: false
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/partition-equal-subset-sum/description
 * @date   2019-07-11 18:34:20
 */
public class L_0588_Partition_Equal_Subset_Sum {

    /**
     * 
     * @author rays1
     */
    static class Solution {
        
        int[][] marked;
        
        /**
         * @param nums: a non-empty array only positive integers
         * @return: true if can partition or false
         */
        public boolean canPartition(int[] nums) {
            // write your code here
            int sum = 0;
            for (int i : nums)
                sum += i;
            
            if (sum % 2 != 0)
                return false;
            
            marked = new int[sum/2+1][nums.length+1];
            
            return find(nums, 0, sum/2);
        }
        
        public boolean find(int[] nums, int index, int c) {
            if (marked[c][index] != 0)
                return marked[c][index] == 1;
            
            if (c == 0) return true;
            else if (index >= nums.length) return false;
            
            boolean rs = find(nums, index + 1, c);
            if (c >= nums[index])
                rs |= find(nums, index + 1, c-nums[index]);
            
            marked[c][index] = rs ? 1 : -1;
            
            return rs;
        }
        
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
