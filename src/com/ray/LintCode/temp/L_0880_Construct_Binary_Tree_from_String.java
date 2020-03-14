package com.ray.LintCode.temp;

import com.ray.leetcode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      You need to construct a binary tree from a string consisting of parenthesis and integers.
 *      
 *      The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.
 *      
 *      You always start to construct the **left** child node of the parent first if it exists.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: "-4(2(3)(1))(6(5))"
 *      Output: {-4,2,6,3,1,5}
 *      Explanation:
 *      The output is look like this:
 *            -4
 *           /  \
 *          2    6
 *         / \   / 
 *        3   1 5   
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: "1(-1)"
 *      Output: {1,-1}
 *      Explanation:
 *      The output is look like this:
 *           1
 *          /
 *        -1
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/construct-binary-tree-from-string/description
 * @date   2019-07-11 18:38:16
 */
public class L_0880_Construct_Binary_Tree_from_String {

    /**
     * 解析二叉树的不同表达方式
     * @author rays1
     *
     */
    static class Solution {
    
        public TreeNode str2tree(String s) {
            return parse(s, 0, s.length()-1);
        }
        
        public TreeNode parse(String s, int i, int j) {
            if (i > j) return null;
            Out.pf("parse(%s, %s)\n", i, j);
            
            int val = 0;
            if (s.charAt(i) == '-') {
                i++;
                while (i <= j && s.charAt(i) != '(') {
                    val = val * 10 + (s.charAt(i)-'0');
                    i++;
                }
                val = -val;
            } else {
                while (i <= j && s.charAt(i) != '(') {
                    val = val * 10 + (s.charAt(i)-'0');
                    i++;
                }
            }
            
            TreeNode root = new TreeNode(val);
            
            int k = i+1;
            int c = 1;
            while (c != 0 && k < j) {
                if (s.charAt(k) == '(') c ++;
                else if (s.charAt(k) == ')') c--;
                k++;
            }
            root.left = parse(s, i+1, k == j ? k-1:k-2);
            root.right = parse(s, k+1, j-1);
            return root;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
