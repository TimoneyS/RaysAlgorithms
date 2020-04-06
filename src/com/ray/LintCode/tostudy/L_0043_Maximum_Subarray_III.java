package com.ray.LintCode.tostudy;

import com.ray.io.Out;

/**
 * 描述：
 *      给定一个整数数组和一个数字 k，寻找 k 个不重叠的子数组，这些子数组拥有最大和。
 * 用例：
 *      **用例 1**
 *      输入:
 *          List = [-1,4,-2,3,-2,3]
 *          k = 2
 *      输出: 8
 *      解释: 4 + (3 + -2 + 3) = 8
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/maximum-subarray-iii/description
 * @date   2019-07-11 17:57:52
 */
public class L_0043_Maximum_Subarray_III {

    /**
     * 
     * 设 f[i][k] 表示从 i 开始，数组划分为 k 个子数组的最大值
     * 
     * f[i][k] = 
     *      max {
     *          maxSub(0, j),
     *          f[j][k-1]
     *      } (  0 < j < N - k)
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        private int N;
        private int[][] mem;
        
        public int maxSubArray(int[] nums, int k) {
            N = nums.length;
            
            mem = new int[nums.length][k+1];
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= k; j++) {
                    mem[i][j] = Integer.MIN_VALUE;
                }
            }
            
            return maxSubArray(nums, 0, k);
        }

        private int maxSubArray(int[] nums, int start, int k) {
            
            if (k <= 0) return 0;
            
            if (mem[start][k] == Integer.MIN_VALUE) {
                
                int[] left  = new int[N];
                int sum     = nums[start];
                left[start] = nums[start];
                
                for (int i = start + 1; i <= N - k; i++) {
                    sum += nums[i];
                    sum = Math.max(sum, nums[i]);
                    left[i] = Math.max(sum, left[i-1]);
                }
                
                for (int i = start; i <= N - k; i++) {
                    mem[start][k] = Math.max(mem[start][k], left[i] + maxSubArray(nums, i+1, k - 1));
                }
            
            }
            return mem[start][k];
        }
    }
    
    public static void main(String[] args) {
        
        int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,-2,1,-15,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int k = 20;
        
        int max = new Solution().maxSubArray(nums, k);
        
        Out.p(max);
        
    }

}
