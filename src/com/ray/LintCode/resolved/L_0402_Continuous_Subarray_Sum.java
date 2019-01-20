package com.ray.LintCode.resolved;

import java.util.Arrays;
import java.util.List;

import com.ray.io.Out;

/**
 * 给定一个整数数组，找到一个连续的子数组，其中数字的总和是最大的。返回第一个数字的索引和最后一个数字的索引。
 * （如果他们是重复的答案，请返回您找到的第一个答案）
 * 
 * [-3, 1, 3, -3, 4] 返回 [1,4].
 * 
 * @author rays1
 *
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
