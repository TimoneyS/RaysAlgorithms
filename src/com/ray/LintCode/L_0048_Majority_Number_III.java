package com.ray.LintCode;

import java.util.Arrays;
import java.util.List;

import com.ray.io.Out;

/**
 * Given an array of integers and a number k,
 * the majority number is the number that occurs more than 1/k of the size of the array.
 *  
 * Find it.
 * 
 * <p>
 * Example : Given [3,1,2,3,2,3,3,4,4,4] and k=3, return 3.
 * <p>
 * O(n) time and O(k) extra space
 * 
 * @author rays1
 *
 */
public class L_0048_Majority_Number_III {

    /**
     * 程序比较潦草，可优化的空间较大
     * @author rays1
     *
     */
    static class Solution {
        /**
         * @param nums: A list of integers
         * @param k: An integer
         * @return: The majority number
         */
        public int majorityNumber(List<Integer> nums, int k) {
            
            int[] rs = new int[k-1];
            int[] ct = new int[k-1];
            
            for (Integer num : nums) {
                
                boolean flag = true;
                
                for (int i = 0; i < ct.length; i++) {
                    if (num == rs[i]) {
                        ct[i] ++;
                        flag = false;
                        break;
                    }
                }
                
                if (flag) {
                    for (int i = 0; i < ct.length; i++) {
                        if (ct[i] == 0) {
                            rs[i] = num;
                            flag = false;
                            ct[i] = 1;
                            break;
                        }
                    }
                }
                
                
                if (flag) {
                    for (int i = 0; i < ct.length; i++) {
                        ct[i] --;
                    }
                }
                
//                Out.p(num);
//                Out.p(rs, "%4s ");
//                Out.p(ct, "%4s ");
//                Out.sep();
                
            }

            for (int i = 0; i < ct.length; i++) ct[i] = 0;
            for (Integer num : nums) {
                for (int i = 0; i < ct.length; i++) {
                    if (num == rs[i]) ct[i] ++;
                }
            }
            
            int index = 0;
            for (int i = 0; i < ct.length; i++) {
                if( ct[i] > ct[index])
                    index = i;
            }
            
            return rs[index];
        }
    }
    
    public static void main(String[] args) {
        
        List<Integer> nums = Arrays.asList(new Integer[] {32,125,176,234,170,147,151,243,67,62,20,149,191,129,131,107,126,50,194,63,191,191,13,139,191,164,239,119,234,79,51,160,194,140,191,165,80,191,26,26,191,26,16,252,196,12,191,191,249,52,161,169,94,140,250,75,110,143,57,255,90,143,191,71,16,22,50,252,191,138,191,142,221,104,182,57,47,191,179,63,191,68,91,185,225,183,69,216,146,152,164,172,169,68,245,123,191,191,219,207,244,147,215,42,121,112,241,179,27,162,243,133,148,178,214,191,208,138,45,62,191,56,232,74,197,154,225,31,136,191,244,166,41,48,50,94,245,239,103,191,191,161,180,82,210,191,191,253,163,171,140,249,198,51,85,93,55,76,32,191,191,27,57,231,163,205,134,165,40,11,191,133,183,164,138,75,191,22,232,248,54,136,106,109,229,242,121,210,218,28,72,252,90,177,184,60,229,81,98,36,48,21,230,120,19,202,76,196,236,44,162,94,89,151,72,191,242,187,218,228,62,169,62,187,162,232,24,236,164,28,63,117,212,191,206,15,209,85,37,177,23,250,30,126,246,48,115,96,198,106,198,139,19,118,153});
        int k = 9;
        
        Out.p(new Solution().majorityNumber(nums, k));
    }

}
