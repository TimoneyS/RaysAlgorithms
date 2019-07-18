package com.ray.LintCode.temp;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Given a binary tree, find the maximum path sum.
 *      
 *      The path may start and end at any node in the tree.
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input:  For the following binary tree（only one node）:
 *      	2
 *      	Output：2
 *      	
 *      Example 2:
 *      	Input:  For the following binary tree:
 *      
 *            1
 *           / \
 *          2   3
 *      		
 *      	Output: 6
 *      
 *      	
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/binary-tree-maximum-path-sum/description
 * @date   2019-07-11 18:30:09
 */
public class L_0094_Binary_Tree_Maximum_Path_Sum {

    static class Solution {
        /**
         * @param root: The root of binary tree.
         * @return: An integer
         */
        private int max = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            mps(root);
            return max;
        }
        
        private int mps(TreeNode n) {
            if (n == null) return 0;
            
            int l = mps(n.left);
            int r = mps(n.right);
            int m = n.val;
            
            int cm = m;
            cm = Math.max(cm, l+m);
            cm = Math.max(cm, r+m);
            
            max = Math.max(max, cm);
            max = Math.max(max, m+l+r);
            
            return cm;
        }
        
    }
    
    public static void main(String[] args) {
        
        TreeNode r = TreeNode.parse("{-2,-1,-3}");
        TreeNode.show(r);
        
        Out.p(new Solution().maxPathSum(r));
        
    }
}
