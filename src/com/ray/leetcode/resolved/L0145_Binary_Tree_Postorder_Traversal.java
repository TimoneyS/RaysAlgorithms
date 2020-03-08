package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Postorder Traversal
 * -----------------------------------------------------------------------------
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * Example:
 *      Example 1
 *      Input: [1,null,2,3]
 *         1
 *          \
 *           2
 *          /
 *         3
 *      Output: [3,2,1]
 *      Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * @since   2020-03-07 20:59:51
 */
public class L0145_Binary_Tree_Postorder_Traversal {
    static class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> rs = new ArrayList<>();
            if (root != null) {
                tree(root, rs);
            }
            return rs;
        }

        public void tree(TreeNode node, List<Integer> rs) {
            if (node.left != null) tree(node.left, rs);
            if (node.right!= null) tree(node.right, rs);
            rs.add(node.val);
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
