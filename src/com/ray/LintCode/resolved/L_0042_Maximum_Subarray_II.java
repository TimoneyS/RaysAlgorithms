package com.ray.LintCode.resolved;

import java.util.Arrays;
import java.util.List;

import com.ray.io.Out;

/**
 * 给定一个整数数组，寻找两个互不覆盖的子数组，两个字符组有用最大和。返回最大和。
 * 
 * 例如：
 *      数组[1, 3, -1, 2, -1, 2],
 *      子数组为 [1, 3] 和 [2, -1, 2] 
 *      或者  [1, 3, -1, 2] 和 [2],
 *      
 *      两种子数组之和均为 7
 * 
 * @author rays1
 *
 */
public class L_0042_Maximum_Subarray_II {
    
    static class Solution {
        
        public int maxTwoSubArrays(List<Integer> nums) {
            
            int N = nums.size();
            
            if (N == 2) return nums.get(0) + nums.get(N-1);
            
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
                if (max < left[i] + right[i+1])
                    max = left[i] + right[i+1];
            }

            return max;
        }
        
    }
    
    public static void main(String[] args) {
        
        Integer[] nums = {0,-1};
        List<Integer> numsL = Arrays.asList(nums);
        
        int max = new Solution().maxTwoSubArrays(numsL);
        
        Out.p(max);
    }
    
}
