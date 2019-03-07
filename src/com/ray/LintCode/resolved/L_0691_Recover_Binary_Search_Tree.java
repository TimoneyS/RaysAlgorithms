package com.ray.LintCode.resolved;

import com.ray.LintCode.util.TreeNode;

/**
 * 在二叉搜索树中，有两个结点被调换了，寻找到这两个结点，并调整回来。
 * 如果没有结点被调换，则返回原始的 根节点。
 *
 * @author rays1
 *
 */
public class L_0691_Recover_Binary_Search_Tree {

    /**
     * 按照 左 - 中 - 右 ， 的顺序遍历树，这样搜索树的元素会有序输出。
     * 问题可以转变为寻找有序数组中，被调换顺序的两个数字。
     * @author rays1
     *
     */
    static class Solution {
    
        public TreeNode bstSwappedNode(TreeNode root) {
            TreeNode pile = new TreeNode(Integer.MIN_VALUE);
            pile.right = root;
            prev = pile;
            
            help(root);
            if (errorNode != null) {
                int t = errorNode.val;
                errorNode.val = errorNode2.val;
                errorNode2.val = t;
            }
            return root;
        }
        
        TreeNode prev, errorNode, errorNode2;
        
        public void help(TreeNode root) {
            
            if (root == null) return;
            
            help(root.left);

            if (prev.val > root.val) {
                if (errorNode == null) {
                    errorNode = prev;
                    errorNode2 = root;
                } else {
                    errorNode2 = root;
                }
            } else {
                prev = root;
            }
            
            help(root.right);
        }
    
    }
    
    public static void main(String[] args) {
        
        // TreeNode root = TreeNode.parse("{4,2,6,1,3,5,7}");
        TreeNode root = TreeNode.parse("{4,2,5,1,3}");
        
        TreeNode.show(root);
        
        new Solution().bstSwappedNode(root);
        
        TreeNode.show(root);
        
    }

}
