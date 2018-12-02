package com.ray.LintCode;

import java.util.Arrays;

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
            
            Arrays.sort(numbers);
            
            int cl = numbers[0] + numbers[1] + numbers[2];
            
            for (int i = 0; i < numbers.length-2; i++) {
                for (int j = i+1; j < numbers.length-1; j++) {
                    for (int k = j+1; k < numbers.length; k++) {
                        int t = numbers[i]+numbers[j] + numbers[k];
                        if (Math.abs(cl-target) > Math.abs(numbers[i]+numbers[j] + numbers[k]-target))
                            cl = t;
                    }
                }
            }
            
            return cl;
        }
        
    }
    
    static class Solution1 {
        /**
         * @param numbers: Give an array numbers of n integer
         * @param target : An integer
         * @return : return the sum of the three integers, the sum closest target.
         */
        public int threeSumClosest(int[] numbers, int target) {
            if (numbers == null || numbers.length < 3) {
                return -1;
            }
            
            Arrays.sort(numbers);
            int cl = numbers[0] + numbers[1] + numbers[2];
            for (int i = 0; i < numbers.length; i++) {
                int j = i + 1, k = numbers.length - 1;
                while (j < k) {
                    int t = numbers[i] + numbers[j] + numbers[k];
                    if (Math.abs(target - t) < Math.abs(target - cl)) {
                        cl = t;
                    }
                    if (t < target) {
                        j++;
                    } else {
                        k--;
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
     
        Out.p(new Solution1().threeSumClosest(numbers, target));
    }
    
}
