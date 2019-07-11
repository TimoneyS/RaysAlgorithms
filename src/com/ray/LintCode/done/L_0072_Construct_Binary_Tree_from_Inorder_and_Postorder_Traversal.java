package com.ray.LintCode.done;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;
import com.ray.util.StringUtil;

/**
 * 描述：
 *      Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：[],[]
 *      Output：{}
 *      Explanation:
 *      The binary tree is null
 *      ```
 *      **Example 2:**
 *      ```
 *      Input：[1,2,3],[1,3,2]
 *      Output：{2,1,3}
 *      Explanation:
 *      The binary tree is as follows
 *        2
 *       / \
 *      1   3
 *      
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/construct-binary-tree-from-inorder-and-postorder-traversal/description
 * @date   2019-07-11 18:29:50
 */
public class L_0072_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

    static class Solution {
        /**
         * @param inorder:
         *            A list of integers that inorder traversal of a tree
         * @param postorder:
         *            A list of integers that postorder traversal of a tree
         * @return: Root of a tree
         */
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder.length == 0) return null;
            return buildTree(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
        }
        
        public TreeNode buildTree(int[] inorder, int[] postorder, int l1, int r1, int l2, int r2) {
            if (r2 < l2 || r1 < l1) return null;
            
            TreeNode node = new TreeNode(postorder[r2]);
            
            if (r2 == l2) return node;
     
            int i = l1;
            while (i <= r1) {
                if (inorder[i] == postorder[r2])
                    break;
                i++;
            }
            
            node.left = buildTree(inorder, postorder, l1, i-1, l2, l2+i-l1-1);
            node.right = buildTree(inorder, postorder, i+1, r1, r2-r1+i, r2-1);
            
            return node;
        }
        
    }
    
    static void tree(TreeNode root, int level) {
        if (root == null) return;
        
        tree(root.right, level+1);
        Out.p(StringUtil.multiString("  ", level+1) + root.val);
        tree(root.left,  level+1);        
    }
    
    public static void main(String[] args) {
        
        int[] inorder   = {1, 2, 3};
        int[] postorder = {3, 2, 1};
        
        TreeNode root = new Solution().buildTree(inorder, postorder);
        tree(root, 1);
        
    }

}
