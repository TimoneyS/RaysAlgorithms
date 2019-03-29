package com.ray.LintCode.resolved;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ray.io.Out;

/**
 * Given an array with n integers, you need to find if there are triplets (i, j, k) which satisfies following conditions:
 * 
 *     1. 0 < i, i + 1 < j, j + 1 < k < n - 1
 *     2. Sum of subarrays (0, i - 1), (i + 1, j - 1), (j + 1, k - 1) and (k + 1, n - 1) should be equal.
 *     
 * We define that subarray (L, R) represents a slice of the original array starting from the element indexed L to the element indexed R.
 * If it exists, return true, otherwise return false.
 *
 * @author rays1
 * @url    
 */
public class L_0877_Split_Array_with_Equal_Sum {

    static class Solution {
    
        public boolean splitArray(List<Integer> nums) {
            int n = nums.size();
            int[] sum = new int[n];
            sum[0] = nums.get(0);
            for (int i = 1; i < n; ++i)
                sum[i] = sum[i - 1] + nums.get(i);
            for (int j = 3; j < n - 3; ++j) {
                Set<Integer> S = new HashSet<>();
                for (int i = 1; i < j - 1; ++i)
                    if (sum[i - 1] == sum[j - 1] - sum[i])
                        S.add(sum[i - 1]);
                for (int k = j + 2; k < n - 1; ++k)
                    if (sum[k - 1] - sum[j] == sum[n - 1] - sum[k] && S.contains(sum[k - 1] - sum[j]))
                        return true;
            }
            return false;
        }
    
    }
    
    public static void main(String[] args) {
        
        List<Integer> nums = Arrays.asList(new Integer[]{
            1,3,2,2
        });
        
        Out.p(new Solution().splitArray(nums));
        
    }

}
