package com.ray.LintCode.resolved;

import com.ray.LintCode.util.TreeNode;

/**
 * 给的那个一个二叉树（BST），将其转换为更大的树。
 * 具体的转换方式是将原始的 BST 中的每个 key，都加上一个数值，这个数值是原始的树中大于等于这个 key 的所有 key 的总和。
 *
 * @author rays1
 *
 */
public class L_0661_Convert_BST_to_Greater_Tree {

    
    /**
     * 因为二叉搜索树，实际上是有序的，只要按照从大到小的顺序访问结点，然后不断记录结点和，作为遍历到的结点的值。
     * 
     * 遍历顺序为 右 - 中 - 左
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public TreeNode convertBST(TreeNode root) {
            trans(root, 0);
            return root;
        }
        
        int trans(TreeNode root, int sum) {
            if (root == null) return sum;
            sum = trans(root.right, sum);
            sum += root.val;
            root.val = sum;
            sum = trans(root.left, sum);
            return sum;
        }
    
    }
    
    public static void main(String[] args) {
        
        TreeNode root = TreeNode.parse("{5,2,13}");
        TreeNode.show(root);
        TreeNode.show(new Solution().convertBST(root));
        
    }

}
