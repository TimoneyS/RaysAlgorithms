package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array of integers, find a contiguous subarray which has the largest sum.
 *
 * 用例：
 *      **Example1:**
 *      
 *      ```
 *      Input: [−2,2,−3,4,−1,2,1,−5,3]
 *      Output: 6
 *      Explanation: the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 *      ```
 *      
 *      **Example2:**
 *      
 *      ```
 *      Input: [1,2,3,4]
 *      Output: 10
 *      Explanation: the contiguous subarray [1,2,3,4] has the largest sum = 10.
 *      ```
 *
 * 挑战：
 *      Can you do it in time complexity O(n)?
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/maximum-subarray/description
 * @date   2019-07-11 17:54:36
 */
public class L_0041_Maximum_Subarray {

    /**
     * 
     * 设sum[i] 表示从 0 开始以 i 结束的和最大子数组之和
     * 
     * 则有
     *      sum[i+1] = max(sum[i], 0) + nums[i+1]
     * 最终的结果为
     *      rs = max { sum[0], sum[1], ... , sum[n-1] }
     * 
     * 则算法如下
     * 
     * // 计算 sum 数组
     * for (int i = 1; i < n; i++)
     *      sum[i] = Math.max(sum[i-1], 0) + nums[i]
     *
     * // 再计算结果
     * for (int s : sum)
     *      rs = Math.max(rs, s);
     *
     * 实际上算法可以优化空间复杂度，每次计算出一个新的和立即和保存的最大和比较即可，并不需要保存所有的 sum
     * 
     * for (int i = 1; i < n; i++)
     *      sum = Math.max(sum, 0) + nums[i]
     *      rs = Math.max(rs, sum);
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        public int maxSubArray(int[] nums) {
            int max = Integer.MIN_VALUE, sum = 0;
            for (int i = 0; i < nums.length; i++)
                max = Math.max((sum = Math.max(0, sum) + nums[i]), max);
            return max;
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] nums = {-1, 2, -3};
        
        Out.p(new Solution().maxSubArray(nums));
        
    }

}
