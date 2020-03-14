package com.ray.LintCode.temp;

import com.ray.leetcode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Find the maximum node in a binary tree, return the node.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input:
 *      {1,-5,3,1,2,-4,-5}
 *      Output: 3
 *      Explanation:
 *      The tree look like this:
 *           1
 *         /   \
 *       -5     3
 *       / \   /  \
 *      1   2 -4  -5
 *      ```
 *      
 *      **Example 2**
 *      
 *      ```plain
 *      Input:
 *      {10,-5,2,0,3,-4,-5}
 *      Output: 10
 *      Explanation:
 *      The tree look like this:
 *           10
 *         /   \
 *       -5     2
 *       / \   /  \
 *      0   3 -4  -5 
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Native
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/binary-tree-maximum-node/description
 * @date   2019-07-11 18:34:34
 */
public class L_0632_Binary_Tree_Maximum_Node {

    static class Solution {
        
        public TreeNode maxNode(TreeNode root) {
            if (root == null) return null;
            TreeNode max = root;
            TreeNode lmax = maxNode(root.left);
            TreeNode rmax = maxNode(root.right);
            if (lmax != null && lmax.val > max.val) max = lmax;
            if (rmax != null && rmax.val > max.val) max = rmax;            
            return max;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
