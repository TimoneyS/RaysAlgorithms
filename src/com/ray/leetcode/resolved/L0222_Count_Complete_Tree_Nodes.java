package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.TreeNode;

/**
 * Count Complete Tree Nodes
 * -----------------------------------------------------------------------------
 * Given a complete binary tree, count the number of nodes.
 * Note: 
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Example:
 *      Example 1
 *      Input: 
 *          1
 *         / \
 *        2   3
 *       / \  /
 *      4  5 6
 *      Output: 6
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/count-complete-tree-nodes/
 * @since   2020-03-09 21:26:14
 */
public class L0222_Count_Complete_Tree_Nodes {
    static class Solution {
        public int countNodes(TreeNode root) {
            if (root == null) return 0;
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
