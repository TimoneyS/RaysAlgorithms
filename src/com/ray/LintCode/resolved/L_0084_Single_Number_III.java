package com.ray.LintCode.resolved;

import java.util.Arrays;
import java.util.List;

/**
 * Given 2*n + 2 numbers, every numbers occurs twice except two, find them.
 *
 * @author rays1
 *
 */
public class L_0084_Single_Number_III {

    static class Solution {
        /**
         * @param A: An integer array
         * @return: An integer array
         */
        public List<Integer> singleNumberIII(int[] A) {
            // write your code here
            int xor = 0;
            for(int n:A){
                xor ^= n;
            }
            
            int lastBit = xor - (xor & (xor-1));
            int group0 = 0;
            int group1 = 0;
            for(int n:A){
                if((lastBit&n)==0){
                    group0 ^= n;
                }else{
                    group1 ^= n;
                }
            }
            
            return Arrays.asList(new Integer[]{group0, group1});
        }
    }

    
    public static void main(String[] args) {
        
        
        
    }
    
}
