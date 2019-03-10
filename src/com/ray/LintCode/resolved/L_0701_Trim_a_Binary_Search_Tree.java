package com.ray.LintCode.resolved;

import com.ray.LintCode.util.TreeNode;

/**
 * 给定一颗二叉搜索树和两个数字 min 和 max。删减这颗树，只要所有的元素都在这两个数字之间（包含这两个数字）。
 * 结果必须是一颗合法的二叉树。
 * 
 * 示例
 * 给定两个数字 5 和 13，并且树如下：
 *           8
 *         /   \
 *        3    10
 *       / \     \
 *      1   6     14
 *         / \   /
 *        4   7 13
 *        
 * 删减后的结果如下：
 *           8
 *          /  \
 *         6    10
 *          \    \
 *           7   13
 *    
 * @author rays1
 *
 */
public class L_0701_Trim_a_Binary_Search_Tree {

    /**
     *  如果 root 的值在二者之间，则 root 的位置不需要变更，
     *  如果 root 的值小于最小，则 root 和其左子树全部删除，新的根在右子树中
     *  如果 root 的值大于最大，则 root 和其右子树全部删除，新的根在左子树中
     */
    static class Solution {
    
        public TreeNode trimBST(TreeNode root, int minimum, int maximum) {
            if (root == null) return root;
            if (root.val >= minimum && root.val <= maximum) {
                root.left = trimBST(root.left, minimum, maximum);
                root.right = trimBST(root.right, minimum, maximum);
                return root;
            } else if (root.val < minimum) {
                return trimBST(root.right, minimum, maximum);
            } else {
                return trimBST(root.left, minimum, maximum);
            }
        }
    
    }
    
    public static void main(String[] args) {
        
        TreeNode root = TreeNode.parse("{8,3,10,1,6,#,14,#,#,4,7,13}");
        TreeNode.show(root);
        int minimum = 5, maximum = 13;
        
        TreeNode.show(new Solution().trimBST(root, minimum, maximum));
        
    }

}
