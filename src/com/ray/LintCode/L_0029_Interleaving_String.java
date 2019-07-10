package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given three strings: *s1*, *s2*, *s3*, determine whether *s3* is formed by the interleaving of *s1* and *s2*.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:
 *      "aabcc"
 *      "dbbca"
 *      "aadbbcbcac"
 *      Output:
 *      true
 *      ```
 *      **Example 2:**
 *      ```
 *      Input:
 *      ""
 *      ""
 *      "1"
 *      Output:
 *      false
 *      ```
 *      **Example 3:**
 *      ```
 *      Input:
 *      "aabcc"
 *      "dbbca"
 *      "aadbbbaccc"
 *      Output:
 *      false
 *      ```
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

    static class Solution {
        
        int l1, l2;
        int[][] A;
        
        /**
         * @param s1: A string
         * @param s2: A string
         * @param s3: A string
         * @return: Determine whether s3 is formed by interleaving of s1 and s2
         */
        public boolean isInterleave(String s1, String s2, String s3) {
            l1 = s1.length();
            l2 = s2.length();
            A = new int[l1+1][l2+1];
            if (l1 + l2 != s3.length()) return false;
            return isInterleave(s1,s2,s3,0, 0);
        }
        
        public boolean isInterleave(String s1, String s2, String s3, int i, int j) {
            if (i == l1 && j == l2) return true;
            if (A[i][j] != 0) return A[i][j] > 0;
            int c3 = s3.charAt(i+j);
            boolean rs = false;
            if (i < l1 && s1.charAt(i) == c3) rs |= isInterleave(s1,s2,s3,i+1, j);
            if (j < l2 && s2.charAt(j) == c3) rs |= isInterleave(s1,s2,s3,i, j+1);
            A[i][j] = rs ? 1 : -1;
            return rs;
        }
        
    }
    
    /**
     * 动态规划问题
     * 
     * A[i][j] 表示 s1[0, i-1]，s2[0, j-1]，能否交叉构成  s3[0, i+j-1]
     * 若能则有两种情况
     * <li> 如果 s3[i+j] = s1[i]，那么  s1[0, i]，s2[0, j-1]，一定能构成  s3[0, i+j]，则 A[i+1][j] = true
     * <li> 如果 s3[i+j] = s2[j]，那么  s1[0, i-1]，s2[0, j]，一定能构成  s3[0, i+j]，则 A[i][j+1] = true
     * 
     * @author rays1
     *
     */
    static class Solution2 {
        
        /**
         * @param s1: A string
         * @param s2: A string
         * @param s3: A string
         * @return: Determine whether s3 is formed by interleaving of s1 and s2
         */
        public boolean isInterleave(String s1, String s2, String s3) {
            // write your code here
            if (s1.length() + s2.length() != s3.length()) return false;
            
            boolean[][] A = new boolean[s1.length() + 1][s2.length() + 1];
            A[0][0] = true;
            for (int i = 0; i <= s1.length(); i++) {
                for (int j = 0; j <= s2.length(); j++) {
                    if (i == s1.length() && j == s2.length()) break;
                    if (!A[i][j]) continue;
                    int c = s3.charAt(i + j);
                    A[i+1][j] = (i < s1.length() && s1.charAt(i) == c);
                    A[i][j+1] = (j < s2.length() && s2.charAt(j) == c);
                }
            }
            return A[s1.length()][s2.length()];
        }
        
    }
    
    
    public static void main(String[] args) {
        
        String s1 = "aacaac";
        String s2 = "aacaaeaac";
        String s3 = "aacaaeaaeaacaac";
        
        Out.p(new Solution2().isInterleave(s1, s2, s3));
    }

}
