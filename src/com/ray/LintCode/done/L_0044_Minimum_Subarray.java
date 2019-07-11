package com.ray.LintCode.done;

import java.util.Arrays;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array of integers, find the continuous subarray with smallest sum.
 *      
 *      Return the sum of the subarray.
 *
 * 用例：
 *      **Example 1**
 *      ```
 *      Input：[1, -1, -2, 1]
 *      Output：-3
 *      ```
 *      **Example 2**
 *      ```
 *      Input：[1, -1, -2, 1, -4]
 *      Output：-6
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/minimum-subarray/description
 * @date   2019-07-11 17:58:01
 */
public class L_0044_Minimum_Subarray {

    static class Solution {
        /*
         * @param nums: a list of integers
         * @return: A integer indicate the sum of minimum subarray
         */
        public int minSubArray(List<Integer> nums) {
            return minSubArray(nums.toArray(new Integer[nums.size()]));
        }
        
        private int minSubArray(Integer[] nums) {
            int N = nums.length;
            int[] leftMin = new int[N];
            
            int minSum = nums[0];
            leftMin[0] = nums[0];
            for (int i = 1; i < N; i++) {
                minSum = Math.min(nums[i], minSum + nums[i]);
                leftMin[i] = Math.min(minSum, leftMin[i-1]);
            }
            
            return leftMin[N-1];
        }
        
    }
    
    static class Solution1 {
        /*
         * @param nums: a list of integers
         * @return: A integer indicate the sum of minimum subarray
         */
        public int minSubArray(List<Integer> nums) {
            if (nums == null || nums.size() == 0) return 0;
            
            int minSum = Integer.MAX_VALUE, maxSum = 0, sum = 0;
            for (int i = 0; i < nums.size(); i++) {
                sum += nums.get(i);
                minSum = Math.min(minSum, sum - maxSum);
                maxSum = Math.max(maxSum, sum);
            }
            return minSum;
        }
    }
    
    
    public static void main(String[] args) {
        
        List<Integer> nums = Arrays.asList(new Integer[] {1, 2, 2, 2});
        
        Out.p(new Solution().minSubArray(nums));
        Out.sep();
        Out.p(new Solution1().minSubArray(nums));
        
    }

}
