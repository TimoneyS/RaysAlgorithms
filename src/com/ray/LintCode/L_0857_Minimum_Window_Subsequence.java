package com.ray.LintCode;

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

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
