package com.ray.LintCode.temp;

import java.util.HashSet;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Given a binary tree with `n` nodes, your task is to check if it's possible to partition the tree to two trees which have the equal sum of values after removing **exactly** one edge on the original tree.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: {5,10,10,#,#,2,3}
 *      Output: true
 *      Explanation:
 *        origin:
 *           5
 *          / \
 *         10 10
 *           /  \
 *          2    3
 *        two subtrees:
 *           5       10
 *          /       /  \
 *         10      2    3
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: {1,2,10,#,#,2,20}
 *      Output: false
 *      Explanation:
 *        origin:
 *           1
 *          / \
 *         2  10
 *           /  \
 *          2    20
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/equal-tree-partition/description
 * @date   2019-07-11 18:38:04
 */
public class L_0864_Equal_Tree_Partition {

    static class Solution {
    
        public boolean checkEqualTree(TreeNode root) {
            
            TreeNode.show(root);
            
            HashSet<Integer> set = new HashSet<>();
            int rs = root != null ? root.val : 0; 
            rs += sum(root.left, set);
            rs += sum(root.right, set);
            
            return rs % 2 == 0 && set.contains(rs/2);
        }
        
        int sum(TreeNode root, HashSet<Integer> set) {
            if (root == null) return 0;
            int rs = sum(root.left, set) + sum(root.right, set) + root.val;
            set.add(rs);
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
