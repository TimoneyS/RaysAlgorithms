package com.ray.LintCode.temp;

import com.ray.leetcode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Given a binary search tree and a number `n`, find two numbers in the tree that sums up to `n`.
 *
 * 用例：
 *      **Example1**
 *      ```
 *      Input: 
 *      {4,2,5,1,3}
 *      3
 *      Output: [1,2] (or [2,1])
 *      Explanation:
 *      binary search tree:
 *          4
 *         / \
 *        2   5
 *       / \
 *      1   3
 *      ```
 *      **Example2**
 *      ```
 *      Input: 
 *      {4,2,5,1,3}
 *      5
 *      Output: [2,3] (or [3,2])
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/two-sum-iv-input-is-a-bst/description
 * @date   2019-07-11 18:35:30
 */
public class L_0689_Two_Sum_IV___Input_is_a_BST {


    /**
     * 树的遍历和查询
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int[] twoSum(TreeNode root, int n) {
            return dfs(root, n, root);
        }
        
        int[] dfs(TreeNode node, int n, TreeNode root) {
            int[] rs = null;
            
            if (node == null) {
                
            } else if (find(root, n-node.val, node)) {
                rs = new int[] {node.val, n-node.val};
            } else {
                rs = dfs(node.left, n, root);
                if (rs == null)
                    dfs(node.right, n, root);
            }
            
            return rs;
        }
        
        public boolean find(TreeNode root, int n, TreeNode diff) {
            if (root == null) return false;
            if (root.val == n) {
                if (root != diff) {
                    return true;
                } else {
                    return find(root.left, n, diff) || find(root.right, n, diff);
                }
            } else if (root.val < n) {
                return find(root.right, n, diff);
            } else {
                return find(root.left, n, diff);
            }
        } 
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
