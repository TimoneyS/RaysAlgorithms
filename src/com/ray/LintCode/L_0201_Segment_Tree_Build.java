package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      The structure of Segment Tree is a binary tree which each node has two attributes `start` and `end` denote an segment / interval.
 *      
 *      _start_ and _end_ are both integers, they should be assigned in following rules:
 *      
 *      - The root's _start_ and _end_ is given by `build` method.
 *      - The left child of node A has `start=A.start, end=(A.start + A.end) / 2`.
 *      - The right child of node A has `start=(A.start + A.end) / 2 + 1, end=A.end`.
 *      - if _start_ equals to _end_, there will be no children for this node.
 *      
 *      Implement a `build` method with two parameters _start_ and _end_, so that we can create a corresponding segment tree with every node has the correct _start_ and _start_ value, return the root of this segment tree.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：[1,4]
 *      Output："[1,4][1,2][3,4][1,1][2,2][3,3][4,4]"
 *      Explanation：
 *      	               [1,  4]
 *      	             /        \
 *      	      [1,  2]           [3, 4]
 *      	      /     \           /     \
 *      	   [1, 1]  [2, 2]     [3, 3]  [4, 4]
 *      ```
 *      **Example 2:**
 *      ```
 *      Input：[1,6]
 *      Output："[1,6][1,3][4,6][1,2][3,3][4,5][6,6][1,1][2,2][4,4][5,5]"
 *      Explanation：
 *      	       [1,  6]
 *                   /        \
 *            [1,  3]           [4,  6]
 *            /     \           /     \
 *         [1, 2]  [3,3]     [4, 5]   [6,6]
 *         /    \           /     \
 *      [1,1]   [2,2]     [4,4]   [5,5]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/segment-tree-build/description
 * @date   2019-07-11 18:31:53
 */
public class L_0201_Segment_Tree_Build {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
