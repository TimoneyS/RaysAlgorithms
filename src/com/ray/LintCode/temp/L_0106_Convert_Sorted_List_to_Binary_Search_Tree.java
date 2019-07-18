package com.ray.LintCode.temp;

import com.ray.LintCode.util.ListNode;
import com.ray.LintCode.util.TreeNode;

/**
 * 描述：
 *      Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input: array = [1,2,3]
 *      	Output:
 *      		 2  
 *      		/ \
 *      		1  3
 *      		
 *      Example 2:
 *      	Input: [2,3,6,7]
 *      	Output:
 *      		 3
 *      		/ \
 *      	       2   6
 *      		     \
 *      		      7
 *      
 *      	Explanation:
 *      	There may be multi answers, and you could return any of them.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/convert-sorted-list-to-binary-search-tree/description
 * @date   2019-07-11 18:30:37
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
