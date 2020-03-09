package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.TreeNode;

import java.util.Stack;

/**
 * Lowest Common Ancestor of a Binary Tree
 * -----------------------------------------------------------------------------
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: &ldquo;The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).&rdquo;
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 * Example:
 *      Example 1
 *      Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 *      Output: 3
 *      Explanation: The LCA of nodes 5 and 1 is 3.
 *      Example 2
 *      Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 *      Output: 5
 *      Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 *      Note:
 *      	All of the nodes' values will be unique.
 *      	p and q are different and both values will exist in the binary tree.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * @since   2020-03-09 21:39:51
 */
public class L0236_Lowest_Common_Ancestor_of_a_Binary_Tree {
    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
            Stack<TreeNode> sa = new Stack<>();
            Stack<TreeNode> sb = new Stack<>();
            nodePath(root, A, sa);
            nodePath(root, B, sb);
            TreeNode rs = null;
            while (!sa.isEmpty() && !sb.isEmpty()) {
                if (sa.peek().val == sb.peek().val) {
                    rs = sa.pop();
                    sb.pop();
                } else {
                    break;
                }
            }
            return rs;
        }

        public boolean nodePath(TreeNode n, TreeNode tar, Stack<TreeNode> stack) {
            if (n == null) return false;
            if (n.val ==  tar.val || nodePath(n.right, tar, stack) || nodePath(n.left, tar, stack)) {
                stack.push(n);
                return true;
            } else {
                return false;
            }
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
