package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Give an integer array，find the longest increasing continuous subsequence in this array.
 *      
 *      An increasing continuous subsequence:
 *      
 *      - Can be from right to left or from left to right.
 *      - Indices of the integers in the subsequence should be continuous.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input: [5, 4, 2, 1, 3]
 *      Output: 4
 *      Explanation:
 *      For [5, 4, 2, 1, 3], the LICS  is [5, 4, 2, 1], return 4.
 *      ```
 *      **Example 2:**
 *      ```
 *      Input: [5, 1, 2, 3, 4]
 *      Output: 4
 *      Explanation:
 *      For [5, 1, 2, 3, 4], the LICS  is [1, 2, 3, 4], return 4.
 *      ```
 *
 * 挑战：
 *      O(n) time and O(1) extra space.
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/longest-continuous-increasing-subsequence/description
 * @date   2019-07-11 18:32:31
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
