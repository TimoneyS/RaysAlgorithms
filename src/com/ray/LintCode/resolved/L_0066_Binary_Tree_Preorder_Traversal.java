package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.ray.LintCode.help.TreeNode;
import com.ray.io.Out;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * 前序遍历
 *
 * @author rays1
 *
 */
public class L_0066_Binary_Tree_Preorder_Traversal {

    static class Solution {
        /**
         * @param root: A Tree
         * @return: Preorder in ArrayList which contains node values.
         */
        public List<Integer> preorderTraversal(TreeNode root) {
            
            List<Integer> rs = new ArrayList<>();
            Stack<TreeNode> stack =  new Stack<>();
            
            stack.push(root);
            while(!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node == null) continue;
                
                rs.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
                
            }
            
            return rs;
        }
    }
    
    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(1);
        
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        Out.p(new Solution().preorderTraversal(root));
        
    }

}
