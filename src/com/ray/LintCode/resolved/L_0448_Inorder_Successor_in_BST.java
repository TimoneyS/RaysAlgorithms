package com.ray.LintCode.resolved;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 
 * 中序遍历后续结点
 * 
 * 给定二叉树和数中的一个结点，返回中序遍历后，该结点之后的一个结点（没有返回null）。
 * 
 * 如：
 *    2
 *   / \
 *  1   3
 * 和结点 2，返回结点3
 * 
 * 注：方法中给出的结点是树中的结点，查找时可以比较内存地址来确定是否是给定的结点
 * 
 * @author rays1
 *
 */
public class L_0448_Inorder_Successor_in_BST {

    /**
     * 设树为 root，给定的结点为 p
     * 
     * 中序遍历的顺序是 左 - 中 - 右
     * 实验 1，使用中序遍历进行遍历，访问到结点p时，再进行一次遍历则结束。
     * 
     * 实验 2，考察具体情况
     *      存在更简便的解法，不需要完整的遍历树，以后研究
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        TreeNode rs, prev;
        
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            tree(root, p);
            return rs;
        }
        
        public void tree(TreeNode root, TreeNode p) {
            if (rs != null || root == null) return;
            tree(root.left, p);
            if (prev == p) {
                Out.p(root.val + " ");
                rs = root;
                prev = root;
            } else {
                prev = root;
                tree(root.right, p);
            }
        }
    
    }
    
    public static void main(String[] args) {
        
        TreeNode root = TreeNode.parse("{4,3,5,2,#,#,6}");
        TreeNode p = root.left.left;
        
        TreeNode.show(root);
        
        Out.p(new Solution().inorderSuccessor(root, p).val);
        
    }

}
