package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```plain
 *      Input: {1,2,3,4,5}
 *      Output: {4,5,2,#,#,3,1}
 *      Explanation:
 *      The input is
 *          1
 *         / \
 *        2   3
 *       / \
 *      4   5
 *      and the output is
 *         4
 *        / \
 *       5   2
 *          / \
 *         3   1
 *      ```
 *      
 *      **Example2**
 *      
 *      ```plain
 *      Input: {1,2,3,4}
 *      Output: {4,#,2,3,1}
 *      Explanation:
 *      The input is
 *          1
 *         / \
 *        2   3
 *       /
 *      4
 *      and the output is
 *         4
 *          \
 *           2
 *          / \
 *         3   1
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/binary-tree-upside-down/description
 * @date   2019-07-11 18:34:47
 */
public class L_0649_Binary_Tree_Upside_Down {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
