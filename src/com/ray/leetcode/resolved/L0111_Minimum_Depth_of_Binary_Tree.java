package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Minimum Depth of Binary Tree
 * -----------------------------------------------------------------------------
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
 *      return its minimum depth = 2.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * @since   2020-03-04 21:31:53
 */
public class L0111_Minimum_Depth_of_Binary_Tree {

    static class Solution {
        public int minDepth(TreeNode root) {
            int deepth = 1;
            if (root == null) return 0;
            Queue<TreeNode> currQueue = new ArrayDeque<>();
            Queue<TreeNode> nextQueue = new ArrayDeque<>();
            currQueue.add(root);
            while (!currQueue.isEmpty()) {
                TreeNode node = currQueue.poll();
                if (node.left == null && node.right == null) {
                    break;
                }
                if (node.left != null) nextQueue.add(node.left);
                if (node.right != null) nextQueue.add(node.right);
                if (currQueue.isEmpty()) {
                    Queue<TreeNode> temp = currQueue;
                    currQueue = nextQueue;
                    nextQueue = temp;
                    deepth ++;
                }
            }
            return deepth;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
