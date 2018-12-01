package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers.
 *
 * For example, given array S = [-1 2 1 -4],
 *  and target = 1. The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * @author rays1
 *
 */
public class L_0059_3Sum_Closest {

    static class Solution {
        
        /**
         * @param numbers: Give an array numbers of n integer
         * @param target: An integer
         * @return: return the sum of the three integers, the sum closest target.
         */
        public int threeSumClosest(int[] numbers, int target) {
            
            int cl = numbers[0] + numbers[1] + numbers[2];
            
            for (int i = 0; i < numbers.length-2; i++) {
                for (int j = i+1; j < numbers.length-1; j++) {
                    for (int k = j+1; k < numbers.length; k++) {
                        if (Math.abs(cl-target) > Math.abs(numbers[i]+numbers[j] + numbers[k]-target))
                            cl = numbers[j] + numbers[j] + numbers[k];
                    }
                }
            }
            
            return cl;
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] numbers = {-1, 2, 1, -4};
        int target = 1;
        
        Out.p(new Solution().threeSumClosest(numbers, target));
     
        
    }
    
}
