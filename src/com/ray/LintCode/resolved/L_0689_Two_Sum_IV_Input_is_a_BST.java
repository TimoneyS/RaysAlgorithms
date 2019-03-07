package com.ray.LintCode.resolved;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 给定二叉搜索树和一个数字 n ，寻找和为  n 的两个数字
 *
 * 示例
 *      输入
 *          {4,2,5,1,3}
 *          3
 *      输出
 *          [1,2] (或 [2,1])
 *          
 *                  4
 *                 / \
 *                2   5
 *               / \
 *              1   3
 *
 *
 * @author rays1
 *
 */
public class L_0689_Two_Sum_IV_Input_is_a_BST {

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
        
        TreeNode root = TreeNode.parse("{1,1,1}");
        int n = 2;
        
        Out.p(new Solution().twoSum(root, n));
        
    }

}
