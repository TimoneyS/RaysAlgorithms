package com.ray.LintCode.resolved;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 *
 * @author rays1
 * @url    https://www.lintcode.com/problem/closest-binary-search-tree-value/description
 * @date   2019-04-12 10:29:13
 */
public class L_0900_Closest_Binary_Search_Tree_Value {

    static class Solution {
        
        Integer curr = null;
        
        public int closestValue(TreeNode root, double target) {
            if (root == null) return curr;
            curr = (curr == null) ? root.val : maxDist(curr, root.val, target);
            if (root.val > target) closestValue(root.left, target);
            if (root.val < target) closestValue(root.right, target);
            return curr;
        }
        
        private int maxDist(int n1, int n2, double target) {
            if ( Math.abs(target - n1) > Math.abs(target - n2)) return n2;
            return n1;
        }
    
    }
    
    public static void main(String[] args) {
        
        TreeNode root = TreeNode.parse("{5,4,9,2,#,8,10}");
        double target = 6.124780;
        
        Out.p(new Solution().closestValue(root, target));
        
    }

}
