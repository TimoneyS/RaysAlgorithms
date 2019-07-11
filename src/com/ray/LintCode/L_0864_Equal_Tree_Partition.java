package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a binary tree with `n` nodes, your task is to check if it's possible to partition the tree to two trees which have the equal sum of values after removing **exactly** one edge on the original tree.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: {5,10,10,#,#,2,3}
 *      Output: true
 *      Explanation:
 *        origin:
 *           5
 *          / \
 *         10 10
 *           /  \
 *          2    3
 *        two subtrees:
 *           5       10
 *          /       /  \
 *         10      2    3
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: {1,2,10,#,#,2,20}
 *      Output: false
 *      Explanation:
 *        origin:
 *           1
 *          / \
 *         2  10
 *           /  \
 *          2    20
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/equal-tree-partition/description
 * @date   2019-07-11 18:38:04
 */
public class L_0864_Equal_Tree_Partition {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
