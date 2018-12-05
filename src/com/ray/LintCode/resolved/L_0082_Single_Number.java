package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 *
 *
 * @author rays1
 *
 */
public class L_0082_Single_Number {

    static class Solution {
        
        /**
         * @param A: An integer array
         * @return: An integer
         */
        public int singleNumber(int[] A) {
            int num = 0;
            for (int i : A) num = num ^ i;
            return num;
        }
        
    }
    
    public static void main(String[] args) {
        
        Out.p();
    }

}
