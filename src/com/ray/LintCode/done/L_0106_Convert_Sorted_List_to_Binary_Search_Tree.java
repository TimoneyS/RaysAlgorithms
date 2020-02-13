package com.ray.LintCode.done;

import com.ray.LintCode.util.ListNode;
import com.ray.LintCode.util.TreeNode;

/**
 * 描述：
 *      给出一个所有元素以升序排序的单链表，将它转换成一棵高度平衡的二分查找树
 * 用例：
 *      Example 1:
 *      	Input: array = [1,2,3]
 *      	Output:
 *      		 2  
 *      		/ \
 *      		1  3
 *      Example 2:
 *      	Input: [2,3,6,7]
 *      	Output:
 *      		 3
 *      		/ \
 *      	   2   6
 *      		     \
 *      		      7
 * 难度： Medium
 *   
 * @author rays1
 * @link   https://www.lintcode.cn/problem/convert-sorted-list-to-binary-search-tree/description
 * @since  2019-07-11 18:30:37
 */
public class L_0106_Convert_Sorted_List_to_Binary_Search_Tree {
    /**
     * 先找到中点，以中点为根，左右侧递归计算子树
     */
    static class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            int size = 0;
            for (ListNode n = head; n != null; n = n.next) {
                size ++;
            }
            return bst(head, size);
        }
        
        public TreeNode bst(ListNode head, int size) {
            if (size == 0)
                return null;
            if (size == 1)
                return new TreeNode(head.val);
            
            ListNode mid = head;
            for (int i = 1; i < (size+1) / 2 && mid != null; i++) {
                mid = mid.next;
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