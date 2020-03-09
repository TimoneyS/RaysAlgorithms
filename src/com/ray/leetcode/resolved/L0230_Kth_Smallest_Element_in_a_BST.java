package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.TreeNode;

import java.util.Stack;

/**
 * Kth Smallest Element in a BST
 * -----------------------------------------------------------------------------
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Example:
 *      Example 1
 *      Input: root = [3,1,4,null,2], k = 1
 *         3
 *        / \
 *       1   4
 *        \
 *         2
 *      Output: 1
 *      Example 2
 *      Input: root = [5,3,6,2,4,null,null,1], k = 3
 *             5
 *            / \
 *           3   6
 *          / \
 *         2   4
 *        /
 *       1
 *      Output: 3
 *      Follow up:
 *      What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 * @since   2020-03-09 21:33:23
 */
public class L0230_Kth_Smallest_Element_in_a_BST {
    /**
     * 显示的栈调用方式中序遍历数，然后记录顺序。
     */
    static class Solution {
        public int kthSmallest(TreeNode root, int k) {
            Stack<TreeNode> stack = new Stack<>();
            while (true) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (--k == 0) return root.val;
                root = root.right;
            }
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
