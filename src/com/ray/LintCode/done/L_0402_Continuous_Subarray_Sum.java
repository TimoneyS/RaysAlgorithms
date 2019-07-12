package com.ray.LintCode.done;

import java.util.Arrays;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an integer array, find a continuous subarray where the sum of numbers is the biggest. Your code should return the index of the first number and the index of the last number. (If their are duplicate answer, return the minimum one in lexicographical order)
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: [-3, 1, 3, -3, 4]
 *      Output: [1, 4]
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: [0, 1, 0, 1]
 *      Output: [0, 3]
 *      Explanation: The minimum one in lexicographical order.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/continuous-subarray-sum/description
 * @date   2019-07-11 18:32:35
 */
public class L_0402_Continuous_Subarray_Sum {


    /**
     * 参考 L_0041_Maximum_Subarray 的解法
     * 遍历时维护三个坐标，当前最大的开始坐标
     * 全局最大的开始和结束坐标
     * 
     * 每当当前和大于之前的总和时，更新当前开始的坐标
     * 每当当前和大于全局总和时，更新全局最大的坐标
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public List<Integer> continuousSubarraySum(int[] A) {
            
            int start = 0, end = 0, currstart = 0;
            
            int max = Integer.MIN_VALUE, sum = 0;
            for (int i = 0; i < A.length; i++) {
                
                if (sum < 0) {
                    sum = A[i];
                    currstart = i;
                } else {
                    sum = A[i] + sum;
                }
                
                if (max < sum) {
                    start = currstart;
                    end = i;
                    max = sum;
                }
            }
            
            return Arrays.asList(new Integer[]{start, end});
        }
    
    }
    
    public static void main(String[] args) {
        
        int[] A = { -2, 2, -3, 4, -1, 2, 1, -5, 3};
        
        Out.p(new Solution().continuousSubarraySum(A));
        
    }

}
