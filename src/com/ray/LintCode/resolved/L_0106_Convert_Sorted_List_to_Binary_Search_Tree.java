package com.ray.LintCode.resolved;

import com.ray.LintCode.help.ListNode;
import com.ray.LintCode.help.TreeNode;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * 已经排序的单链表,转换为高度平衡的二叉树
 * @author rays1
 *
 */
public class L_0106_Convert_Sorted_List_to_Binary_Search_Tree {

    static class Solution {

        public TreeNode sortedListToBST(ListNode head) {
            int size = 0;
            ListNode n = head;
            while (n != null) {
                size ++;
                n = n.next;
            }
            return bst(head, size);
        }
        
        public TreeNode bst(ListNode head, int size) {
            if (size == 0)
                return null;
            if (size == 1)
                return new TreeNode(head.val);
            
            ListNode mid = head;
            int i = 1;
            while (i < (size+1) / 2 && mid != null) {
                mid = mid.next;
                i++;
            }
            
            TreeNode root = new TreeNode(mid.val);
            
            int lsize = (size+1)/2-1;
            int rsize = size - lsize - 1;
            
            root.left = bst(head, lsize);
            root.right = bst(mid.next, rsize);
            
            return root;
        }

    }
    
    public static void main(String[] args) {
        
        ListNode head = ListNode.parse("{1,2,3,4,5,6,7,8,9}");
        TreeNode root = new Solution().sortedListToBST(head);
        
        TreeNode.show(root);
        
    }

}
