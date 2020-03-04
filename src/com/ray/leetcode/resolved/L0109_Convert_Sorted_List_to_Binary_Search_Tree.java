package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.ListNode;
import com.ray.leetcode.util.TreeNode;

/**
 * Convert Sorted List to Binary Search Tree
 * -----------------------------------------------------------------------------
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *      Example 1
 *      Given the sorted linked list: [-10,-3,0,5,9],
 *      One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *            0
 *           / \
 *         -3   9
 *         /   /
 *       -10  5
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 * @since   2020-03-04 21:27:26
 */
public class L0109_Convert_Sorted_List_to_Binary_Search_Tree {
    /**
     * 先找到中点，以中点为根，左右侧递归计算子树
     */
    static class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            int size = 0;
            for (ListNode n = head; n != null; n = n.next) {
                size ++;
            }
            return bst(head, size);
        }

        public TreeNode bst(ListNode head, int size) {
            if (size == 0)
                return null;
            if (size == 1)
                return new TreeNode(head.val);

            ListNode mid = head;
            for (int i = 1; i < (size+1) / 2 && mid != null; i++) {
                mid = mid.next;
            }
            TreeNode root = new TreeNode(mid.val);

            int lsize = (size+1)/2-1;
            int rsize = size - lsize - 1;

            root.left = bst(head, lsize);
            root.right = bst(mid.next, rsize);
            return root;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
