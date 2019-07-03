package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given a string `s` and a string `t`, check if `s` is subsequence of `t`.
 *   
 *   You may assume that there is only lower case English letters in both `s` and `t`. `t` is potentially a very long (`length ~= 500,000`) string, and `s` is a short string (`length <= 100`).
 *   
 *   A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, `"ace"` is a subsequence of `"abcde"` while `"aec"` is not).
 *
 * Example :
 *   **Example 1:**
```
Input: s = "abc", t = "ahbgdc"
Output: true
```
**Example 2:**
```
Input: s = `"axc"`, t = `"ahbgdc"`
Output: false
```
 *
 * Challenge :
 *   If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/is-subsequence/description
 * @date   2019-07-03 17:42:23
 */
public class L_1263_Is_Subsequence {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
