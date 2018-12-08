package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * @author rays1
 *
 */
public class L_0068_Binary_Tree_Postorder_Traversal {

    static class Solution {
        /**
         * @param root: A Tree
         * @return: Postorder in ArrayList which contains node values.
         */
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> rs = new ArrayList<>();
            if (root != null)
                tree(root, rs);
            return rs;
        }
        
        public void tree(TreeNode node, List<Integer> rs) {
            if (node.left != null) tree(node.left, rs);
            if (node.right!= null) tree(node.right, rs);
            rs.add(node.val);
        }
        
    }

}
