package com.ray.LintCode.resolved;

import java.util.Stack;

import com.ray.io.Out;

/**
 * Design an iterator over a binary search tree with the following rules:
 *
 * Elements are visited in ascending order (i.e. an in-order traversal)
 * next() and hasNext() queries run in O(1) time in average.
 * 
 * @author rays1
 *
 */
public class L_0086_Binary_Search_Tree_Iterator {
    
    static class TreeNode {
        public int      val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    static class BSTIterator {
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        /*
        * @param root: The root of binary tree.
        */
        public BSTIterator(TreeNode root) {
            pushToStack(root);
        }
        
        private void pushToStack(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        /*
         * @return: True if there has next node, or false
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /*
         * @return: return next node
         */
        public TreeNode next() {
            TreeNode n = stack.pop();
            if (n.right != null)
                pushToStack(n.right);
            return n;
        }
    }
    
    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(10);
        
        root.left = new TreeNode(1);
        root.right = new TreeNode(11);
        
        root.left.right = new TreeNode(6);        
        root.right.right = new TreeNode(12);
        
        BSTIterator iterator = new BSTIterator(root);
        while (iterator.hasNext()) {
           TreeNode node = iterator.next();
           Out.p(node.val);
        } 
        
    }

}
