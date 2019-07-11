package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array of integers and a number _k_, find k **non-overlapping** subarrays which have the largest sum.
 *      
 *      The number in each subarray should be **contiguous**.
 *      
 *      Return the largest sum.
 *
 * 用例：
 *      **Example 1**
 *      
 *      ```plain
 *      Input: 
 *      List = [1,2,3]
 *      k = 1
 *      Output: 6
 *      Explanation: 1 + 2 + 3 = 6
 *      ```
 *      
 *      **Example 2**
 *      
 *      ```plain
 *      Input:
 *      List = [-1,4,-2,3,-2,3]
 *      k = 2
 *      Output: 8
 *      Explanation: 4 + (3 + -2 + 3) = 8
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/maximum-subarray-iii/description
 * @date   2019-07-11 17:57:52
 */
public class L_0043_Maximum_Subarray_III {

    /**
     * 动态规划
     * 
     * 结果是原数组的一个划分，则假设最优划分点可以设为  S = {s1, s2, ... sk }
     * 
     * 则
     *  Sk-1 是 数组 arr[0..Sk-1] 的最优划分
     * 
     *  Sk = Sk-1 + maxSubArray(arr[Sk-1+1...N])
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        private int[] nums;
        private int N;
        private int[][] maxMemmorized;
        
        public int maxSubArray(int[] nums, int k) {
            this.nums = nums;
            N = nums.length;
            
            maxMemmorized = new int[N][k+1];
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= k; j++) {
                    maxMemmorized[i][j] = -1;
                }
            }
            
            return maxSubArray(0, k);
        }

        private int maxSubArray(int start, int k) {
            
            if (maxMemmorized[start][k] != -1) return maxMemmorized[start][k];
            
            int max = Integer.MIN_VALUE;
            int[] left = new int[N];
            int sum = nums[start];
            left[start] = nums[start];
            
            if (k == 1) {
                for (int i = start + 1; i < N; i++) {
                    sum += nums[i];
                    sum = Math.max(sum, nums[i]);
                    left[i] = Math.max(sum, left[i-1]);
                }
                max = left[N-1];
            } else {
                
                for (int i = start + 1; i <= N - k; i++) {
                    sum += nums[i];
                    sum = Math.max(sum, nums[i]);
                    left[i] = Math.max(sum, left[i-1]);
                }
                
                for (int i = start; i <= N - k; i++)
                    max = Math.max(max, left[i] + maxSubArray(i+1, k - 1));
            }
            
            
            maxMemmorized[start][k] = max;
//            Out.pf("maxSubArray(%s, %s) max = %s\n", start, k, max);

            return max;
        }
    }
    
    public static void main(String[] args) {
        
        int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,-2,1,-15,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int k = 20;
        
        int max = new Solution().maxSubArray(nums, k);
        
        Out.p(max);
        
    }

}
