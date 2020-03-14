package com.ray.leetcode.resolved;

import com.ray.leetcode.util.TreeNode;
import com.ray.io.Out;

/**
 * Maximum Depth of Binary Tree
 * -----------------------------------------------------------------------------
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Note: A leaf is a node with no children.
 *
 * Example:
 *      Example 1
 *      Given binary tree [3,9,20,null,null,15,7],
 *          3
 *         / \
 *        9  20
 *          /  \
 *         15   7
 *      return its depth = 3.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * @since   2020-03-03 23:25:06
 */
public class L0104_Maximum_Depth_of_Binary_Tree {
    static class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            return Math.max(maxDepth(root.left) , maxDepth(root.right)) + 1;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
