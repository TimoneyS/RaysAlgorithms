package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 *
 * Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.
 *
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there are multiple such minimum-length windows, return the one with the left-most starting index.
 *
 * @author rays1
 *
 */
public class L_0857_Minimum_Window_Subsequence {

    /**
     * 从每个可能位置开始寻找，寻找每个可能的方案，选择其中的最小值。
     * 
     * 复杂度 O(nm)
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public String minWindow(String S, String T) {
            
            String rs = "";
            for (int start = S.length()-1; start >= 0; start --) {
                int i = start, j = 0;
                while (i < S.length() && j < T.length()) {
                    if (S.charAt(i) == T.charAt(j)) {
                        j++;
                    }
                    i++;
                    if (rs.length() != 0 && i-start > rs.length()) break;
                }
                
                if (j == T.length() &&(rs.length() == 0 || rs.length() >= (i-start))) {
                    rs = S.substring(start, i);
                }
                
            }
            
            return rs;
        }

    }
    
    public static void main(String[] args) {
        
        String S = "abcdebdde";
        String T = "bde";
        
        Out.p(new Solution().minWindow(S, T));
        
    }

}
