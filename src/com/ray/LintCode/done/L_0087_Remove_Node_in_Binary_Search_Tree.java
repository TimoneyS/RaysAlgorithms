package com.ray.LintCode.done;

import com.ray.LintCode.util.TreeNode;

/**
 * 描述：
 *      Given a root of Binary Search Tree with unique value for each node.  Remove the node with given value. If there is no such a node with given value in the binary search tree, do nothing. You should keep the tree still a binary search tree after removal.
 *
 * 用例：
 *      **Example 1**
 *      
 *      ```plain
 *      Input: 
 *      Tree = {5,3,6,2,4}
 *      k = 3
 *      Output: {5,2,6,#,4} or {5,4,6,2}
 *      Explanation:
 *      Given binary search tree:
 *          5
 *         / \
 *        3   6
 *       / \
 *      2   4
 *      Remove 3, you can either return:
 *          5
 *         / \
 *        2   6
 *         \
 *          4
 *      or
 *          5
 *         / \
 *        4   6
 *       /
 *      2
 *      
 *      ```
 *      
 *      **Example 2**
 *      
 *      ```plain
 *      Input: 
 *      Tree = {5,3,6,2,4}
 *      k = 4
 *      Output: {5,3,6,2}
 *      Explanation:
 *      Given binary search tree:
 *          5
 *         / \
 *        3   6
 *       / \
 *      2   4
 *      Remove 4, you should return:
 *          5
 *         / \
 *        3   6
 *       /
 *      2
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/remove-node-in-binary-search-tree/description
 * @date   2019-07-11 18:30:03
 */
public class L_0087_Remove_Node_in_Binary_Search_Tree {

    static class Solution {
        /*
         * @param root: The root of the binary search tree.
         * @param value: Remove the node with given value.
         * @return: The root of the binary search tree after removal.
         */
        public TreeNode removeNode(TreeNode root, int value) {
            if (root == null) return null;
            
            if (root.val == value) {
                if (root.right == null) return root.left;
                if (root.left  == null) return root.right;
                TreeNode n = min(root.right);
                root.right = removeMin(root.right);
                root.val = n.val;
            } else if (root.val < value) {
                root.right = removeNode(root.right, value);
            } else {
                root.left = removeNode(root.left, value);
            }
            return root;
        }
        
        private TreeNode min (TreeNode n) {
            if (n.left == null) return n;
            return min(n.left);
        }
        
        private TreeNode removeMin(TreeNode n) {
            if (n.left == null) return n.right;
            n.left = removeMin(n.left);
            return n;
        }
        
    }

}
