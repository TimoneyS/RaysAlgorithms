package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      给定字符串 s1 s2 s3 推断 s3 是否是 s1 和 s2 交叉构成
 *
 * 用例：
 *      **Example 1:**
 *      "aa    bc c"
 *      "  dbbc  a"
 *      "aadbbcbcac"
 *      可以交叉构成
 *      
 *      
 *      **Example 2:**
 *      "aa  b cc"
 *      "  db bca"
 *      "aadbbbaccc"
 *      不能交叉构成
 *
 * 挑战：
 *      O(n<sup>2</sup>) time or better
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/interleaving-string/description
 * @date   2019-07-10 23:00:09
 */
public class L_0029_Interleaving_String {

    
    /**
     * 设 A[i][j] 表示到 i j 为止，s1 s2 能够构成 i+j 长度的 s3
     * 
     * A[i][j] = A[i-1][j] && s1[i] == s3[i+j] || A[i][j-1] && s2[j] == s3[i+j]
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        public boolean isInterleave(String s1, String s2, String s3) {
            int l1 = s1.length(), l2 = s2.length();
            boolean[][] A = new boolean[l1+1][l2+1];
            
            A[0][0] = true;
            for (int i = 1; i <= l1; i++) {
                A[i][0] = A[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
            }
            for (int j = 1; j <= l2; j++) {
                A[0][j] = A[0][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
            }
            for (int i = 1; i <= l1; i++) {
                for (int j = 1; j <= l2; j++) {
                    A[i][j] = A[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1) || A[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
                }
            }
            
            return A[l1][l2];
        }
        
    }
    
    public static void main(String[] args) {
        
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        
        Out.p(new Solution().isInterleave(s1, s2, s3));
    }

}
