package com.ray.LintCode.done;

import com.ray.LintCode.util.ListNode;

/**
 * 描述：
 *      Reverse a linked list.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: 1->2->3->null
 *      Output: 3->2->1->null
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: 1->2->3->4->null
 *      Output: 4->3->2->1->null
 *      ```
 *
 * 挑战：
 *      Reverse it in-place and in one-pass
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/reverse-linked-list/description
 * @date   2019-07-11 17:42:25
 */
public class L_0035_Reverse_Linked_List {

    static class Solution {
        /**
         * @param head: n
         * @return: The new head of reversed linked list.
         */
        public ListNode reverse(ListNode head) {
            ListNode prev = null;
            ListNode temp = null;
            while (head != null) {
                temp = head.next;
                head.next = prev;
                prev = head;
                head = temp;
            }
            return prev;
        }
    }
    
    public static void main(String[] args) {
        ListNode head = ListNode.parse("{1,2,3}");
        head.show();
        ListNode newHead = new Solution().reverse(head);
        newHead.show();
    }

}
