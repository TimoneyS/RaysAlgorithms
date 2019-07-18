package com.ray.LintCode.temp;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: root = {5,4,9,2,#,8,10} and target = 6.124780
 *      Output: 5
 *      Explanation：
 *      Binary tree {5,4,9,2,#,8,10},  denote the following structure:
 *              5
 *             / \
 *           4    9
 *          /    / \
 *         2    8  10
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: root = {3,2,4,1} and target = 4.142857
 *      Output: 4
 *      Explanation：
 *      Binary tree {3,2,4,1},  denote the following structure:
 *           3
 *          / \
 *        2    4
 *       /
 *      1
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/closest-binary-search-tree-value/description
 * @date   2019-07-11 18:38:23
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
        
        Out.p(new Solution());
        
    }

}
