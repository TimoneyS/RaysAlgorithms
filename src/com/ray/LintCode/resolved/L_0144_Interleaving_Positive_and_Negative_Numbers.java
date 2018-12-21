package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * Given an array with positive and negative integers. Re-range it to interleaving with positive and negative integers.
 * 整数数组，将其调整为正负交替的数组。
 * 
 * Given [-1, -2, -3, 4, 5, 6], after re-range, it will be [-1, 5, -2, 4, -3, 6] or any other reasonable answer.
 * @author rays1
 *
 */
public class L_0144_Interleaving_Positive_and_Negative_Numbers {

    static class Solution {
        
        public void rerange(int[] A) {
            
            int l = 0, r = A.length-1;
            while (true) {
                while (l < A.length) if (A[l] > 0) l++; else break;
                while (r >= 0)       if (A[r] < 0) r--; else break;
                
                if (r <= l) break;
                
                swap(A, l, r);
            }
            
            for (int i = 1; i <= r; i += 2) {
                if (l >= A.length ) break;
                swap(A, i, l++);
                r++;
            }
            
            if (r < A.length - 2) {
                int t = A[0];
                for (int i = 0; i < l; i++) {
                    A[i] = A[i+1];
                }
                A[l] = t;
            }
            
        }
        
        public void swap(int[] A, int i, int j) {
            int t = A[i];
            A[i] = A[j];
            A[j] = t;
        }

    }
    
    public static void main(String[] args) {
        
        int[] A = {1,-2,3,-4,5,-1,-2};
        Out.p(A);
        
        new Solution().rerange(A);
        Out.p(A);
    }

}
