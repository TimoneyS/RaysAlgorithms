package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.ray.io.Out;

/**
 * Given an integer array, find a subarray where the sum of numbers is zero.
 * Your code should return the index of the first number and the index of the last number.
 *
 * 给定一个整型数组，寻找和是0的子数组。返回第一个和最后一个数组的索引。
 *
 * @author rays1
 *
 */
public class L_0138_Subarray_Sum {

    static class Solution {
        public List<Integer> subarraySum(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (map.containsKey(sum)) {
                    return Arrays.asList(new Integer[] {map.get(sum)+1, i});
                }
                map.put(sum, i);
            }
            
            return new ArrayList<>();
        }
        
    }
    
    
    public static void main(String[] args) {
        
        int[] nums = {-3,1,2,-3,4};
        
        Out.p(new Solution().subarraySum(nums));
    }

}
