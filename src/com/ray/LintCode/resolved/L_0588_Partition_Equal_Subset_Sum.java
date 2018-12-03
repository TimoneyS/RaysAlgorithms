package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * Given a non-empty array containing only positive integers,
 * find if the array can be partitioned into two subsets
 * such that the sum of elements in both subsets is equal.
 * <p>
 * 给定一个数组，寻找数组是否可以被分割为两部分，并且两部分的和相等。
 * <p>
 * <b>Example</b>
 * <p>
 * Given nums = [1, 5, 11, 5], return true<br>
 * two subsets: [1, 5, 5], [11]<br>
 * Given nums = [1, 2, 3, 9], return false
 * 
 * @author rays1
 *
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
        
        int[] nums = {1,2,3,4,6,7};
        
        Out.p(new Solution().canPartition(nums));
    }
    
}
