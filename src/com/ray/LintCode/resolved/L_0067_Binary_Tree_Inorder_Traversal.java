package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * @author rays1
 *
 */
public class L_0067_Binary_Tree_Inorder_Traversal {

    /**
     * 递归的中序遍历
     */
    static class Solution {
        
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> rs = new ArrayList<>();
            if (root != null) tree(root, rs);
            return rs;
        }
        
        public void tree(TreeNode node, List<Integer> rs) {
            if (node.left != null) tree(node.left, rs);
            rs.add(node.val);
            if (node.right!= null) tree(node.right, rs);
        }
        
    }
    
    /**
     * 非递归的 中序遍历
     *
     */
    static class Solution2 {
        
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> rs = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            
            addToStack(root, stack);
            while (!stack.isEmpty()) {
                TreeNode n = stack.pop();
                if (n.right != null) {
                    addToStack(n.right, stack);
                }
                rs.add(n.val);
            }
            return rs;
        }
        
        void addToStack(TreeNode node, Stack<TreeNode> stack) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        
        Out.p(new Solution2().inorderTraversal(root));
        
    }
    
}
