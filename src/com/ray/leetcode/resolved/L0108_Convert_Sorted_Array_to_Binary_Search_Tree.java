package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.TreeNode;

/**
 * Convert Sorted Array to Binary Search Tree
 * -----------------------------------------------------------------------------
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *      Example 1
 *      Given the sorted array: [-10,-3,0,5,9],
 *      One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *            0
 *           / \
 *         -3   9
 *         /   /
 *       -10  5
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * @since   2020-03-04 21:26:23
 */
public class L0108_Convert_Sorted_Array_to_Binary_Search_Tree {
    static class Solution {
        public TreeNode sortedArrayToBST(int[] A) {
            return build(A, 0, A.length-1);
        }

        public TreeNode build(int[] A, int s, int t) {
            if (s > t) return null;
            else if (s == t) return new TreeNode(A[s]);
            int mid = (s+t)/2;
            TreeNode root = new TreeNode(A[mid]);
            root.left  = build(A, s, mid-1);
            root.right = build(A, mid+1, t);
            return root;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
