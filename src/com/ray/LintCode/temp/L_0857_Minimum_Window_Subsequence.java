package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given strings `S` and `T`, find the minimum (contiguous) **substring** `W` of `S`, so that `T` is a **subsequence** of `W`.
 *      
 *      If there is no such window in `S` that covers all characters in `T`, return the empty string `""`. If there are multiple such minimum-length windows, return the one with the smallest starting index.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：S="jmeqksfrsdcmsiwvaovztaqenprpvnbstl"，T="u"
 *      Output：""
 *      Explanation： unable to match
 *      ```
 *      **Example 2:**
 *      ```
 *      Input：S = "abcdebdde"， T = "bde"
 *      Output："bcde"
 *      Explanation："bcde" is the answer and "deb" is not a smaller window because the elements of T in the window must occur in order.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/minimum-window-subsequence/description
 * @date   2019-07-11 18:37:40
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
        
        Out.p(new Solution());
        
    }

}
