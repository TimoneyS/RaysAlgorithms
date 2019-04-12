package com.ray.LintCode.resolved;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 *
 * @author rays1
 * @url    
 * @date   2019-04-12 10:29:13
 */
public class L_0900_Closest_Binary_Search_Tree_Value {

    static class Solution {
    
        public int closestValue(TreeNode root, double target) {
            int c1 = closestValue(root.left, target, root.val);
            c1 = closestValue(root.right, target, c1);
            return c1;
        }
        
        public int closestValue(TreeNode root, double target, int curr) {
            if (root == null) return curr;
            curr = maxDist(curr, root.val, target);
            curr = closestValue(root.left, target, curr);
            curr = closestValue(root.right, target, curr);
            return curr;
        }
        
        private int maxDist(int n1, int n2, double target) {
            if ( Math.abs(target - n1) > Math.abs(target - n2)) {
                return n2;
            }
            return n1;
        }
    
    }
    
    public static void main(String[] args) {
        
        TreeNode root = TreeNode.parse("{5,4,9,2,#,8,10}");
        double target = 6.124780;
        
        Out.p(new Solution().closestValue(root, target));
        
    }

}
