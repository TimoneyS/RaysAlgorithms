package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 *
 * 寻找最长的单调子数组（递增、递减）
 *
 * @author rays1
 *
 */
public class L_0397_Longest_Continuous_Increasing_Subsequence {

    static class Solution {
    
        public int longestIncreasingContinuousSubsequence(int[] A) {
            if (A == null || A.length == 0) return 0;
            int il = 1, dl = 1;
            
            int rs = 1;
            for (int i = 1; i < A.length; i++) {
                if (A[i] > A[i-1]) {
                    rs = Math.max(rs, ++dl);
                    il = 1;
                } else if (A[i] < A[i-1]) {
                    rs = Math.max(rs, ++il);
                    dl = 1;
                } else {
                    dl = il = 1;
                }
            }
            
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        int[] A = {1,2,5,1,1};
        
        Out.p(new Solution().longestIncreasingContinuousSubsequence(A));
        
    }

}
