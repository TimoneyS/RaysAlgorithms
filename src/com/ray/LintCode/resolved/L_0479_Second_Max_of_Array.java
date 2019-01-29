package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 返回数组第二大的元素
 *
 *
 * @author rays1
 *
 */
public class L_0479_Second_Max_of_Array {

    static class Solution {
    
        public int secondMax(int[] nums) {
            
            int max = Integer.MIN_VALUE, secMax = Integer.MIN_VALUE;
            
            for (int num : nums) {
               if (num >= max) {
                   secMax = max;
                   max = num;
               } else if (num >= secMax) {
                   secMax = num;
               }
            }
            
            return secMax;
        }
    
    }
    
    public static void main(String[] args) {
        
        int[] nums = {2,1};
        
        Out.p(new Solution().secondMax(nums));
        
    }

}
