package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Binary Tree Preorder Traversal
 * -----------------------------------------------------------------------------
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * Example:
 *      Example 1
 *      Input: [1,null,2,3]
 *         1
 *          \
 *           2
 *          /
 *         3
 *      Output: [1,2,3]
 *      Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * @since   2020-03-07 20:58:16
 */
public class L0144_Binary_Tree_Preorder_Traversal {
    /**
     * 前序遍历的顺序是 中 -> 左 -> 右
     */
    static class Solution {
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
        Out.p(new Solution());
    }
}
