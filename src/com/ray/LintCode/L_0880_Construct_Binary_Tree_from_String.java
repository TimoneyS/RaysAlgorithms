package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      You need to construct a binary tree from a string consisting of parenthesis and integers.
 *      
 *      The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.
 *      
 *      You always start to construct the **left** child node of the parent first if it exists.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: "-4(2(3)(1))(6(5))"
 *      Output: {-4,2,6,3,1,5}
 *      Explanation:
 *      The output is look like this:
 *            -4
 *           /  \
 *          2    6
 *         / \   / 
 *        3   1 5   
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: "1(-1)"
 *      Output: {1,-1}
 *      Explanation:
 *      The output is look like this:
 *           1
 *          /
 *        -1
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/construct-binary-tree-from-string/description
 * @date   2019-07-11 18:38:16
 */
public class L_0880_Construct_Binary_Tree_from_String {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
