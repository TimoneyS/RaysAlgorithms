package com.ray.LintCode.temp;

import java.util.LinkedList;
import java.util.List;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Given a binary tree, return all root-to-leaf paths.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：{1,2,3,#,5}
 *      Output：["1->2->5","1->3"]
 *      Explanation：
 *         1
 *       /   \
 *      2     3
 *       \
 *        5
 *      ```
 *      **Example 2:**
 *      ```
 *      Input：{1,2}
 *      Output：["1->2"]
 *      Explanation：
 *         1
 *       /   
 *      2     
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/binary-tree-paths/description
 * @date   2019-07-11 18:33:28
 */
public class L_0480_Binary_Tree_Paths {

    static class Solution {
        /**
         * @param root the root of the binary tree
         * @return all root-to-leaf paths
         */
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> list = new LinkedList<String>();
            tree(root, "", list);
            return list;
        }
        private void tree(TreeNode node, String s, List<String> rs) {
            if (node != null) {
                if(s == "") s = s + node.val;
                else        s = s + "->" + node.val;
                tree(node.left, s, rs);
                tree(node.right, s, rs);
                if (isLeaf(node)) {
                    rs.add(s);
                }
            }
        }

        private boolean isLeaf(TreeNode node) {
            return node.left == null && node.right == null;
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
