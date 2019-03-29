package com.ray.LintCode.resolved;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 *
 *You need to construct a binary tree from a string consisting of parenthesis and integers.

The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.

You always start to construct the left child node of the parent first if it exists.
 *
 * @author rays1
 * @url    
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
        
        String s = "1(2(3(4(5(6(7(8)))))))";
        TreeNode.show(new Solution().str2tree(s));
        
    }

}
