package com.ray.LintCode.done;

import java.util.Stack;

import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Given a binary search tree, write a function `kthSmallest` to find the kth smallest element in it.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：{1,#,2},2
 *      Output：2
 *      Explanation：
 *      	1
 *      	 \
 *      	  2
 *      The second smallest element is 2.
 *      ```
 *      
 *      
 *      **Example 2:**
 *      ```
 *      Input：{2,1,3},1
 *      Output：1
 *      Explanation：
 *        2
 *       / \
 *      1   3
 *      The first smallest element is 1.
 *      ```
 *
 * 挑战：
 *      What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/kth-smallest-element-in-a-bst/description
 * @date   2019-07-11 18:38:28
 */
public class L_0902_Kth_Smallest_Element_in_a_BST {

    /**
     * 显示的栈调用方式中序遍历数，然后记录顺序。
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int kthSmallest(TreeNode root, int k) {
            
            Stack<TreeNode> stack = new Stack<>();
            
            while (true) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (--k == 0) return root.val;
                root = root.right;
            }
            
        }
        
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
