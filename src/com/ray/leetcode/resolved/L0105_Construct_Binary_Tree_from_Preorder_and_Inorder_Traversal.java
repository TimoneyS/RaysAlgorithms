package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.TreeNode;

/**
 * Construct Binary Tree from Preorder and Inorder Traversal
 * -----------------------------------------------------------------------------
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * For example, given
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Example:
 *      
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @since   2020-03-03 23:26:30
 */
public class L0105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

    /**
     * 参考 L_0072_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal
     * 重点是找到分割点
     */
    static class Solution {

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (inorder.length == 0)
                return null;
            return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        }

        public TreeNode buildTree(int[] preorder, int[] inorder, int l1, int r1, int l2, int r2) {
            if (r2 < l2 || r1 < l1)
                return null;

            TreeNode node = new TreeNode(preorder[l1]);

            if (r2 == l2)
                return node;

            int i = l2;
            while (i <= r2) {
                if (inorder[i] == preorder[l1])
                    break;
                i++;
            }

            node.left =  buildTree(preorder, inorder, l1+1,       l1-l2+i,   l2,     i-1);
            node.right = buildTree(preorder, inorder, l1-l2+i+1,  r1,         i+1,   r2);

            return node;
        }

    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
