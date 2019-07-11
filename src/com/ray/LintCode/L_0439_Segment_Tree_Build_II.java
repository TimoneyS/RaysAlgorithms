package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      The structure of Segment Tree is a binary tree which each node has two attributes `start` and `end` denote an segment / interval.
 *      
 *      `start` and `end` are both integers, they should be assigned in following rules:
 *      
 *      - The root's `start` and `end` is given by `build` method.
 *      - The left child of node A has `start=A.left, end=(A.left + A.right) / 2`.
 *      - The right child of node A has `start=(A.left + A.right) / 2 + 1, end=A.right`.
 *      - if `start` equals to `end`, there will be no children for this node.
 *      
 *      Implement a `build` method with a given array, so that we can create a corresponding segment tree with every node value represent the corresponding interval max value in the array, return the root of this segment tree.
 *
 * 用例：
 *      ```
 *      Input: [3,2,1,4]
 *      Explanation:
 *      The segment tree will be
 *                [0,3](max=4)
 *                /          \
 *             [0,1]         [2,3]    
 *            (max=3)       (max=4)
 *            /   \          /    \    
 *         [0,0]  [1,1]    [2,2]  [3,3]
 *        (max=3)(max=2)  (max=1)(max=4)
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/segment-tree-build-ii/description
 * @date   2019-07-11 18:33:09
 */
public class L_0439_Segment_Tree_Build_II {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
