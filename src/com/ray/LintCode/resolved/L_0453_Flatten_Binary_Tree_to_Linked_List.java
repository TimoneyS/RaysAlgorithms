package com.ray.LintCode.resolved;

import com.ray.LintCode.util.TreeNode;

/**
 * 
 * 将一个二叉树按照前序遍历的顺序，平铺为一个类似链表的结构。
 * 平铺后，右结点等同于链表中的下一个结点。
 *
 * 挑战：不使用额外空间。
 *
 * @author rays1
 *
 */
public class L_0453_Flatten_Binary_Tree_to_Linked_List {

    /**
     * 将右结点放入左结点的最右侧，然后将左结点变为右结点。
     * 然后继续处理新的右结点。
     * @author rays1
     *
     */
    static class Solution {
    
        public void flatten(TreeNode root) {
            while (root != null) {
                if (root.left == null) {
                    root = root.right;
                } else {
                    if (root.right != null) putToRight(root.left, root.right);
                    root.right = root.left;
                    root.left = null;
                    
                    root = root.right;
                }
                
            }
        }
        
        void putToRight(TreeNode root, TreeNode node) {
            while (root.right != null) root = root.right;
            root.right = node;
        }
    
    }
    
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("{1,2,3,4,5}");
        new Solution().flatten(root);
        
        TreeNode.show(root);
    }

}
