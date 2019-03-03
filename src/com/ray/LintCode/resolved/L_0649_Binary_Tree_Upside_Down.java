package com.ray.LintCode.resolved;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 给定一个二叉树，其中所有右节点要么是具有兄弟节点的叶节点(有一个共享相同父节点的左节点)或空，
 * 将其倒置并将其转换为树，其中原来的右节点变为左叶子节点。返回新的根节点。
 *
 * 例如：
 *   {1,2,3,4,5}  -->  {4,5,2,#,#,3,1}
 *         1              4
 *        / \            / \
 *       2   3    -->   5   2
 *      / \                / \
 *     4   5              3   1  
 *
 *     ===========================
 *     
 *   {1,2,3,4}    -->  {4,#,2,3,1}
 *         1              4     
 *        / \              \     
 *       2   3    -->       2     
 *      /                  / \     
 *     4                  3   1 
 *     
 * @author rays1
 *
 */
public class L_0649_Binary_Tree_Upside_Down {

    /**
     * 根据题目只要右结点存在就必然存在左结点
     * 
     * 所以不断的将左结点变成新的根节点，原来的根节点变成左结点的右结点，右结点变为原来的左结点。
     * 然后向下递归。
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public TreeNode upsideDownBinaryTree(TreeNode root) {
            if (root == null) return null;
            TreeNode cl = root.left, cr = root.right;
            root.left = null;
            root.right = null;
            return trans(root, cl, cr);
        }
        
        TreeNode trans(TreeNode root, TreeNode l, TreeNode r) {
            if (l == null) return root;
            TreeNode cl = l.left, cr = l.right;
            l.right = root;
            l.left = r;
            return trans(l, cl, cr);
        }
    
    }
    
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("{1,2,3,4,5}");
        TreeNode.show(root);
        Out.sep();
        TreeNode.show(new Solution().upsideDownBinaryTree(root));
    }

}
