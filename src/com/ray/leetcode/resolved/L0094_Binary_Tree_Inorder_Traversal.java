package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Binary Tree Inorder Traversal
 * -----------------------------------------------------------------------------
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *      Input: [1,null,2,3]
 *         1
 *          \
 *           2
 *          /
 *         3
 *      Output: [1,3,2]
 *      Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @since   2020-03-03 22:29:04
 */
public class L0094_Binary_Tree_Inorder_Traversal {
    /**
     * 非递归的遍历
     *
     * 遇到一个结点就不断的循环，将其左结点加入栈
     */
    static class Solution {
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
        Out.p(new Solution());
    }
}
