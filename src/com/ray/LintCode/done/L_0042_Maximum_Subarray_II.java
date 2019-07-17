package com.ray.LintCode.done;

import java.util.Arrays;
import java.util.List;

import com.ray.io.Out;
import com.ray.util.Assert;

/**
 * 描述：
 *      给定一个整数数组，寻找两个不互相覆盖的子数组，使得两个子数组的和最大。
 *
 * 用例：
 *      用例 1:
 *      输入: [1, 3, -1, 2, -1, 2]
 *      输出: 7
 *      解释: 两个子数组为 [1, 3] 和 [2, -1, 2] 或 [1, 3, -1, 2] 和 [2] 
 *
 * 挑战：
 *      时间复杂度 O(n)
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/maximum-subarray-ii/description
 * @date   2019-07-11 17:54:52
 */
public class L_0042_Maximum_Subarray_II {

    /**
     * 设
     *      left[i] 为从 0 到 i 之间的最大子数组和
     *      right[i] 为从 i 到 n-1 之间的最大子数组和
     *      
     * 所以最优解为：
     *      max {left[i] + right[i]}     
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        public int maxTwoSubArrays(List<Integer> nums) {
            
            int N = nums.size();
            
            if (N == 2) {
                return nums.get(0) + nums.get(N-1);
            }
            
            int[] left = new int[N];
            int[] right = new int[N];
            
            int sum = nums.get(0);
            left[0] = nums.get(0);
            for (int i = 1; i < N; i++) {
                sum += nums.get(i);
                sum = Math.max(sum, nums.get(i));
                left[i] = Math.max(sum, left[i-1]);
            }
            
            sum = nums.get(N-1);
            right[N-1] = nums.get(N-1);
            for (int i = N-2; i >= 0; i--) {
                sum += nums.get(i);
                sum = Math.max(sum, nums.get(i));
                right[i] = Math.max(sum, right[i+1]);
            }
            
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N-1; i++) {
                max = Math.max(max, left[i] + right[i+1]);
            }

            return max;
        }
        
    }
    
    public static void main(String[] args) {
        
        Integer[] nums = {1, 3, -1, 2, -1, 2};
        List<Integer> numsL = Arrays.asList(nums);
        
        int max = new Solution().maxTwoSubArrays(numsL);
        
        Assert.assertEquals(max, 7);
        
        Out.p(max);
    }

}
