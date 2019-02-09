package com.ray.LintCode.resolved;

import java.util.Arrays;

import com.ray.io.Out;

/**
 * 给定一个整数序列，寻找最长的递增子序列（LIS）。
 * 返回 LIS 的长度
 *
 * @author rays1
 *
 */
public class L_0076_Longest_Increasing_Subsequence {
    
    /**
     * 算法过程中，用 top 记录，当前可以生成的长度为 i 的子序列的最小终点元素
     * 
     * 如：数组  4,5,1,2,3
     * 
     * 第一次：当前元素 4
     *    len :  1 2 
     *    top :  4 0
     *      
     * 第二次：当前元素 5
     *    len :  1 2 
     *    top :  4 5
     * 
     * 第三次：当前元素 1
     *    len :  1 2 
     *    top :  1 5
     *    
     * 第四次：当前元素 2
     *    len :  1 2 
     *    top :  1 2
     *    
     * 第五次：当前元素 3
     *    len :  1 2 3 
     *    top :  1 2 3
     * 
     * 算法复杂度 O(n Log n)
     *    
     */
    static class Solution {
        
        public int longestIncreasingSubsequence(int[] nums) {
            
            int len = 0;
            int[] top = new int[nums.length+1];
            
            for (int num : nums) {
                int idx = Arrays.binarySearch(top, 0, len, num);
                if (idx < 0) idx = - idx - 1;
                top[idx] = num;
                if (idx == len) len ++;
            }
            
            return len;
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] nums = {9,3,6,2,7};
        
        Out.p(new Solution().longestIncreasingSubsequence(nums));
    }

}
