package com.ray.LintCode.temp;

import java.util.ArrayList;
import java.util.List;

import com.ray.LintCode.util.ListNode;
import com.ray.LintCode.util.TreeNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: {1,2,3,4}
 *      Output: [1->null,2->3->null,4->null]
 *      Explanation: 
 *              1
 *             / \
 *            2   3
 *           /
 *          4
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: {1,#,2,3}
 *      Output: [1->null,2->null,3->null]
 *      Explanation: 
 *          1
 *           \
 *            2
 *           /
 *          3
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/convert-binary-tree-to-linked-lists-by-depth/description
 * @date   2019-07-11 18:32:03
 */
public class L_0242_Convert_Binary_Tree_to_Linked_Lists_by_Depth {


    static class Solution {
    
        public List<ListNode> binaryTreeToLists(TreeNode root) {
            List<ListNode> list = new ArrayList<>();
            
            helper(root, 0, list, new ArrayList<>());
            
            return list;
        }
        
        public void helper(TreeNode root, int level, List<ListNode> headList, List<ListNode> tailList) {
            if (root == null) return;
            
            ListNode node = new ListNode(root.val);
            
            if (headList.size() <= level) {
                headList.add(node);
                tailList.add(node);
            } else {
                tailList.get(level).next = node;
                tailList.set(level, node);
            }
            helper(root.left, level+1, headList, tailList);
            helper(root.right, level+1, headList, tailList);            
        }
    
    }
    
    public static void main(String[] args) {
        
        TreeNode root = TreeNode.parse("{1,2,3,4}");
        
        Out.p(new Solution().binaryTreeToLists(root));
        
    }

}
