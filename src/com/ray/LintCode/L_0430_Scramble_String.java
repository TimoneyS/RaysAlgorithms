package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a string `s1`, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 *      
 *      Below is one possible representation of `s1 = "great"`:
 *      
 *              great
 *             /    \
 *            gr    eat
 *           / \    /  \
 *          g   r  e   at
 *                     / \
 *                    a   t
 *      
 *      To scramble the string, we may choose any non-leaf node and swap its two children.
 *      
 *      For example, if we choose the node `"gr"` and swap its two children, it produces a scrambled string `"rgeat"`.
 *      
 *              rgeat
 *             /    \
 *            rg    eat
 *           / \    /  \
 *          r   g  e   at
 *                     / \
 *                    a   t
 *      
 *      We say that `"rgeat"` is a scrambled string of `"great"`.
 *      
 *      Similarly, if we continue to swap the children of nodes `"eat"` and `"at"`, it produces a scrambled string `"rgtae"`.
 *      
 *              rgtae
 *             /    \
 *            rg    tae
 *           / \    /  \
 *          r   g  ta  e
 *                 / \
 *                t   a
 *      
 *      We say that `"rgtae"` is a scrambled string of `"great"`.
 *      
 *      Given two strings `s1` and `s2` of the same length, determine if `s2` is a scrambled string of `s1`.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: s1 = "great", s2 = "rgeat"
 *      Output: true
 *      Explanation: As described above.
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: s1 = "a", s2 = "b"
 *      Output: false
 *      ```
 *
 * 挑战：
 *      O(n<sup>3</sup>) time
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/scramble-string/description
 * @date   2019-07-11 18:33:04
 */
public class L_0430_Scramble_String {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
