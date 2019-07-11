package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Implement wildcard pattern matching with support for `'?'` and `'*'`.
 *      
 *      - `'?'` Matches any single character.
 *      - `'*'` Matches any sequence of characters (including the empty sequence).
 *      
 *      The matching should cover the entire input string (not partial).
 *
 * 用例：
 *      **Example 1**
 *      
 *      ```plain
 *      Input:
 *      "aa"
 *      "a"
 *      Output: false
 *      ```
 *      
 *      **Example 2**
 *      
 *      ```plain
 *      Input:
 *      "aa"
 *      "aa"
 *      Output: true
 *      ```
 *      
 *      **Example 3**
 *      
 *      ```plain
 *      Input:
 *      "aaa"
 *      "aa"
 *      Output: false
 *      ```
 *      
 *      **Example 4**
 *      
 *      ```plain
 *      Input:
 *      "aa"
 *      "*"
 *      Output: true
 *      Explanation: '*' can replace any string
 *      ```
 *      
 *      **Example 5**
 *      
 *      ```plain
 *      Input:
 *      "aa"
 *      "a*"
 *      Output: true
 *      ```
 *      
 *      **Example 6**
 *      
 *      ```plain
 *      Input:
 *      "ab"
 *      "?*"
 *      Output: true
 *      Explanation: '?' -> 'a' '*' -> 'b'
 *      ```
 *      
 *      **Example 7**
 *      
 *      ```plain
 *      Input:
 *      "aab"
 *      "c*a*b"
 *      Output: false
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/wildcard-matching/description
 * @date   2019-07-11 18:31:48
 */
public class L_0192_Wildcard_Matching {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
