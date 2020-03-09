package com.ray.leetcode.resolved;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

import java.util.LinkedList;
import java.util.List;

/**
 * Binary Tree Paths
 * -----------------------------------------------------------------------------
 * Given a binary tree, return all root-to-leaf paths.
 * Note: A leaf is a node with no children.
 *
 * Example:
 *      Example 1
 *      Input:
 *         1
 *       /   \
 *      2     3
 *       \
 *        5
 *      Output: [1->2->5, 1->3]
 *      Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/binary-tree-paths/
 * @since   2020-03-09 21:55:44
 */
public class L0257_Binary_Tree_Paths {

    static class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> list = new LinkedList<String>();
            tree(root, "", list);
            return list;
        }
        private void tree(TreeNode node, String s, List<String> rs) {
            if (node != null) {
                if(s.equals("")) s = s + node.val;
                else             s = s + "->" + node.val;
                tree(node.left, s, rs);
                tree(node.right, s, rs);
                if (node.left == null && node.right == null) rs.add(s);
            }
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
