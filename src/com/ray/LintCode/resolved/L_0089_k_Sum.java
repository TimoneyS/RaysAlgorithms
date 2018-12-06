package com.ray.LintCode.resolved;

import com.ray.io.Out;
import com.ray.util.Timer;

/**
 * Given n distinct positive integers, integer k (k <= n) and a number target.
 * Find k numbers where sum is target. Calculate how many solutions there are?
 * 
 * @author rays1
 *
 */
public class L_0089_k_Sum {

    static class Solution {
        
        int[][][] mem;
        
        /**
         * @param A: An integer array
         * @param k: A positive integer (k <= length(A))
         * @param target: An integer
         * @return: An integer
         */
        public int kSum(int[] A, int k, int target) {
            
            mem = new int[A.length+1][k+1][target+1];
            
            for (int i = 0; i <= A.length; i++) {
                for (int j = 0; j < k+1; j++) {
                    for (int j2 = 0; j2 < target+1; j2++) {
                        mem[i][j][j2] = -1;
                    }
                }
            }
            
            return kSum(A, 0, k, target, 1);
        }
        
        public int kSum(int[] A, int s, int k, int target, int level) {
            if (target < 0 || s+k > A.length)
                return 0;
            
            if (mem[s][k][target] != -1)
                return mem[s][k][target];
            
            if (k == 0) {
                if (target == 0)
                    mem[s][k][target] = 1;
                else
                    mem[s][k][target] = 0;
            } else  {
                int rs = 0;
                rs += kSum(A, s+1, k, target, level + 1);
                rs += kSum(A, s+1, k-1, target-A[s], level + 1);
                mem[s][k][target] = rs;
            }
            
            return mem[s][k][target];
            
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] A = {1,4,6,9,10,13,14,17,19,22,25,28,30,33,36,37,38,41,42,45,47,49,51,54,57,58,59,62,64,67,69,71,73,74,77};
        int k = 23;
        int target = 1000;
        
        Timer.CLICK();
        Out.p(new Solution().kSum(A, k, target));
        Timer.STOP();
    }

}
