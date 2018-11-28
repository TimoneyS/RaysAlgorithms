package com.ray.LintCode;

import java.util.List;

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
    class Solution {
        /*
         * @param nums: a list of integers
         * @return: The majority number that occurs more than 1/3
         */
        public int majorityNumber(List<Integer> nums) {
            
            int N = nums.size();
            Integer num = null;
            int ct = 0;
            
            for (Integer i : nums) {
                if (ct == 0) num = i;
                if (i.equals(num)) ct ++;
                else ct --;
                if (ct >= N/3) break;
            }
            
            return num;
        }
    }

}
