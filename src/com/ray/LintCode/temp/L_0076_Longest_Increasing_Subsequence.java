package com.ray.LintCode.temp;

import java.util.Arrays;

import com.ray.io.Out;

/**
 * 描述：
 *      给定一个整数序列，找到最长上升子序列（LIS），返回LIS的长度。
 *
 * 用例：
 *      Example 1:
 *      	Input:  [5,4,1,2,3]
 *      	Output:  3
 *      	
 *      	Explanation:
 *      	LIS is [1,2,3]
 *      
 *      
 *      Example 2:
 *      	Input: [4,2,4,5,3,7]
 *      	Output:  4
 *      	
 *      	Explanation: 
 *      	LIS is [2,4,5,7]
 *      ```
 *
 * 挑战：
 *      <p>Time complexity O(n^2) or O(nlogn)</p>
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/longest-increasing-subsequence/description
 * @date   2019-07-11 18:29:53
 */
public class L_0076_Longest_Increasing_Subsequence {

    /**
     * 用 top 记录到当前元素为止，能够生成的各种长度的序列中，最小的终点元素。
     * 
     * 如：数组  4,5,1,2,3
     * 
     * 第一次：[4],5,1,2,3
     *    top :  4 0
     *      
     * 第二次：4,[5],1,2,3
     *    top :  4 5
     * 
     * 第三次：4,5,[1],2,3
     *    top :  1 5
     *    
     * 第四次：4,5,1,[2],3
     *    top :  1 2
     *    
     * 第五次：4,5,1,2,[3]
     *    top :  1 2 3
     * 
     * 算法复杂度 O(n log n)
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
