package com.ray.leetcode.resolved;

import com.ray.leetcode.util.TreeNode;
import com.ray.io.Out;

/**
 * Same Tree
 * -----------------------------------------------------------------------------
 * Given two binary trees, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *
 * Example:
 *      Example 1
 *      Input:     1         1
 *                / \       / \
 *               2   3     2   3
 *              [1,2,3],   [1,2,3]
 *      Output: true
 *      Example 2
 *      Input:     1         1
 *                /           \
 *               2             2
 *              [1,2],     [1,null,2]
 *      Output: false
 *      Example 3
 *      Input:     1         1
 *                / \       / \
 *               2   1     1   2
 *              [1,2,1],   [1,1,2]
 *      Output: false
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/same-tree/
 * @since   2020-03-03 23:15:09
 */
public class L0100_Same_Tree {
    /**
     * 先比较内存地址，如果内存地址相同则不用比较
     * 如果二者只有一个为null，或者值不相等则返回false
     * 否则递归比较
     */
    static class Solution {
        public boolean isSameTree(com.ray.LintCode.util.TreeNode a, TreeNode b) {
            if (a == b) return true;
            if (a == null || b == null || a.val != b.val) return false;
            return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
