package com.ray.LintCode.resolved;

import com.ray.io.Out;
import com.ray.util.StringUtil;

/**
 * 
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * @author rays1
 *
 */
public class L_0073_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

    static class Solution {
        /**
         * @param inorder:
         *            A list of integers that inorder traversal of a tree
         * @param postorder:
         *            A list of integers that postorder traversal of a tree
         * @return: Root of a tree
         */
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

    static void tree(TreeNode root, int level) {
        if (root == null)
            return;

        tree(root.right, level + 1);
        Out.p(StringUtil.multiString("  ", level + 1) + root.val);
        tree(root.left, level + 1);
    }

    public static void main(String[] args) {

        
        int[] preorder = {6,2,3,4,5};
        int[] inorder  = {2,4,5,3,6};
        
        TreeNode root = new Solution().buildTree(preorder, inorder);
        tree(root, 1);

    }

}
