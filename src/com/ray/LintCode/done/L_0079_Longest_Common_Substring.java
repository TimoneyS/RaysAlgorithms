package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given two strings, find the longest common substring.
 *      
 *      Return the length of it.
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input:  "ABCD" and "CBCE"
 *      	Output:  2
 *      	
 *      	Explanation:
 *      	Longest common substring is "BC"
 *      
 *      
 *      Example 2:
 *      	Input: "ABCD" and "EACB"
 *      	Output:  1
 *      	
 *      	Explanation: 
 *      	Longest common substring is 'A' or 'C' or 'B'
 *      ```
 *
 * 挑战：
 *      O(n x m) time and memory.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/longest-common-substring/description
 * @date   2019-07-11 18:29:56
 */
public class L_0079_Longest_Common_Substring {

    static class Solution {
        
        /**
         * @param A:
         *            A string
         * @param B:
         *            A string
         * @return: the length of the longest common substring.
         */
        public int longestCommonSubstring(String A, String B) {

            int la = A.length(), lb = B.length();
            
            int[][] mem = new int[la+1][lb+1];
            
            int max = 0;
            for (int i = 1; i <= la; i++) {
                for (int j = 1; j <= lb; j++) {
                    if (A.charAt(i-1) == B.charAt(j-1))
                        mem[i][j] = mem[i-1][j-1] + 1;
                    max = Math.max(max, mem[i][j]);
                }
            }
            
            return max;
        }
        
    }
    
    public static void main(String[] args) {
        
        String A = "abc";
        String B = "a";
        
        Out.p(new Solution().longestCommonSubstring(A, B));
        
    }

}
