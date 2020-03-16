package com.ray.leetcode.resolved;

import com.ray.leetcode.util.TreeNode;

import java.util.Stack;

/**
 * Binary Search Tree Iterator
 * -----------------------------------------------------------------------------
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 *
 * Example:
 *      Example 1
 *      BSTIterator iterator = new BSTIterator(root);
 *      iterator.next();    // return 3
 *      iterator.next();    // return 7
 *      iterator.hasNext(); // return true
 *      iterator.next();    // return 9
 *      iterator.hasNext(); // return true
 *      iterator.next();    // return 15
 *      iterator.hasNext(); // return true
 *      iterator.next();    // return 20
 *      iterator.hasNext(); // return false
 *      Note:
 *      	next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 *      	You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when next() is called.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/binary-search-tree-iterator/
 * @since   2020-03-08 17:40:55
 */
public class L0173_Binary_Search_Tree_Iterator {
    static class BSTIterator {

        private Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            pushToStack(root);
        }

        private void pushToStack(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public int next() {
            TreeNode n = stack.pop();
            if (n.right != null)
                pushToStack(n.right);
            return n.val;
        }
    }

    public static void main(String[] args) {
    }
}
