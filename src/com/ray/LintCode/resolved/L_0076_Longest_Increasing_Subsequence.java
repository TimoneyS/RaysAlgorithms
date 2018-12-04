package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * Given a sequence of integers, find the longest increasing subsequence (LIS).
 * You code should return the length of the LIS.
 *
 * @author rays1
 *
 */
public class L_0076_Longest_Increasing_Subsequence {
    
    /**
     * 算法过程中，用 top 记录
     * 从起始到当前元素为止，可以生成 所有长度为 i 的子序列的中，每种序列的最小终点元素
     * 
     * 如：数组  4,5,1,2,3
     * 当算法进行到元素2 时
     * 长度为 1 的元素，最小终点为 1
     * 长度为 2 的元素，最小终点为 2
     * 
     * @author rays1
     *
     */
    static class Solution {
        /**
         * @param nums: An integer array
         * @return: The length of LIS (longest increasing subsequence)
         */
        public int longestIncreasingSubsequence(int[] nums) {
            
            int maxSize = 0;
            int[] top = new int[nums.length+1];
            for (int i = 0; i < top.length; i++) {
                top[i] = Integer.MAX_VALUE;
            }
            top[0] = Integer.MIN_VALUE;
            
            for (int i = 0; i < nums.length; i++) {
                for (int j = maxSize; j >= 0; j--) {
                    if (nums[i] > top[j]) {
                        top[j+1] = Math.min(top[j+1], nums[i]);
                        if (j == maxSize) maxSize ++;
                        break;
                    }
                }
            }
            
            return maxSize;
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] nums = {4, 2, 4, 5, 3, 7};
        
        Out.p(new Solution().longestIncreasingSubsequence(nums));
    }

}
