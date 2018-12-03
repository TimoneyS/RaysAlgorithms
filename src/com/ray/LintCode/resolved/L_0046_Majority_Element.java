package com.ray.LintCode.resolved;

import java.util.Arrays;
import java.util.List;

import com.ray.io.Out;

/**
 * Given an array of integers,
 * the majority number is the number that occurs more than half of the size of the array.
 * Find it.
 * <p>
 * Example : Given [1, 1, 1, 1, 2, 2, 2], return 1
 * 
 * @author rays1
 *
 */
public class L_0046_Majority_Element {

    static class Solution {
        /*
         * @param nums: a list of integers
         * @return: find a  majority number
         */
        public int majorityNumber(List<Integer> nums) {
            Integer num = null;
            int ct = 0;
            for (Integer i : nums) {
                if (ct == 0) num = i;
                if (i.equals(num)) ct ++;
                else ct --;
            }
            return num;
        }
        
    }
    
    public static void main(String[] args) {
        
        List<Integer> nums = Arrays.asList(new Integer[] {1,1,1,1,2,2,3});
        
        Out.p(new Solution().majorityNumber(nums));
    }

}
