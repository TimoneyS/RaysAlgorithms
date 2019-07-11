package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      <p><span style="line-height: 30px;">Implement regular expression matching with support for&nbsp;</span><code style="font-size: 13px; line-height: 30px; white-space: normal;">'.'</code><span style="line-height: 30px;">&nbsp;and&nbsp;</span><code style="font-size: 13px; line-height: 30px; white-space: normal;">'*'</code><span style="line-height: 30px;">.</span></p><pre>'.' Matches any single character.
 *      '*' Matches zero or more of the preceding element.
 *      
 *      The matching should cover the <span style="font-weight: 700;">entire</span> input string (not partial).
 *      
 *      The function prototype should be:
 *      bool isMatch(string s, string p)</pre>
 *      
 *      <p>isMatch("aa","a") → false</p><p>isMatch("aa","aa") → true</p><p>isMatch("aaa","aa") → false</p><p>isMatch("aa", "a*") → true</p><p>isMatch("aa", ".*") → true</p><p>isMatch("ab", ".*") → true</p><p>isMatch("aab", "c*a*b") →  true</p>
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input："aa"，"a"
 *      Output：false
 *      Explanation：
 *      unable to match
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input："aa"，"a*"
 *      Output：true
 *      Explanation：
 *      '*' can repeat a
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/regular-expression-matching/description
 * @date   2019-07-11 18:31:17
 */
public class L_0154_Regular_Expression_Matching {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
