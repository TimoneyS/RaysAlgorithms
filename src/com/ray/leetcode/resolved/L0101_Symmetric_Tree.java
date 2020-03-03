package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.TreeNode;

/**
 * Symmetric Tree
 * -----------------------------------------------------------------------------
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 *
 * Example:
 *      
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/symmetric-tree/
 * @since   2020-03-03 23:16:40
 */
public class L0101_Symmetric_Tree {
    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            return dfs(root, root);
        }

        boolean dfs(TreeNode l, TreeNode r) {
            if (l == null || r == null) {
                return l == r;
            }
            if (l.val != r.val) {
                return false;
            }
            return dfs(l.left, r.right) && dfs(l.right, r.left);
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
