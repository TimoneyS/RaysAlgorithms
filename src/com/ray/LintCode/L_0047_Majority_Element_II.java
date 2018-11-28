package com.ray.LintCode;

import java.util.Arrays;
import java.util.List;

import com.ray.io.Out;

/**
 *
 * Given an array of integers,
 * the majority number is the number that occurs more than 1/3 of the size of the array.
 *
 * Given [1, 2, 1, 2, 1, 3, 3], return 1.
 *
 * @author rays1
 *
 */
public class L_0047_Majority_Element_II {

    /**
     * 
     * @author rays1
     *
     */
    static class Solution {
        /*
         * @param nums: a list of integers
         * @return: The majority number that occurs more than 1/3
         */
        public int majorityNumber(List<Integer> nums) {
            
            int num1 = 0;
            int num2 = 0;
            
            int ct1 = 0;
            int ct2 = 0;
            
            for (Integer i : nums) {
                if (ct1 == 0) num1 = i;
                if (ct2 == 0) num2 = i;
                
                if (i == num1) ct1 ++;
                else if (i == num2) ct2 ++;
                else {
                    ct1 --;
                    ct2 --;
                }
            }

            ct1 = ct2 = 0;
            for (Integer i : nums) {
                if (i == num1) ct1 ++;
                if (i == num2) ct2 ++;
            }
            
            return ct1 > ct2 ? num1 : num2;
        }
    }
    
    public static void main(String[] args) {
        
        List<Integer> nums = Arrays.asList(new Integer[] {1,2,1,2,1,3,3});
        
        Out.p(new Solution().majorityNumber(nums));
    }

}
