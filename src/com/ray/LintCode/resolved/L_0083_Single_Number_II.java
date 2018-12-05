package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * Given 3*n + 1 non-negative integer, every numbers occurs triple times except one, find it
 *
 * @author rays1
 *
 */
public class L_0083_Single_Number_II {

    static class Solution {
        /**
         * @param A: An integer array
         * @return: An integer
         */
        public int singleNumberII(int[] A) {
            
            int[] num = new int[32];
            
            for (int i : A) {
                Out.p(i);
                int j = 0;
                while (i != 0) {
                    num [j] += i % 2;
                    if (num[j] == 3 || num[j] == -3) num[j] = 0;

                    j ++;
                    i = i / 2;
                }
                Out.p(num);
                
            }
            
            int n = 0;
            for (int i = 0; i < num.length; i++) {
                if (num[i] == 1)
                    n += Math.pow(2, i);
            }
            
            return n;
        }
    }
    
    public static void main(String[] args) {
        
        int[] A = {1, -2147483648, -2147483648, -2147483648};
        
        Out.p(new Solution().singleNumberII(A));
    }

}
