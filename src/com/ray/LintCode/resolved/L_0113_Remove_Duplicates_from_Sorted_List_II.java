package com.ray.LintCode.resolved;

import com.ray.LintCode.util.ListNode;

/**
 * Given a sorted linked list, 
 * delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * 
 * @author rays1
 *
 */
public class L_0113_Remove_Duplicates_from_Sorted_List_II {

    static class Solution {
        /**
         * @param head: head is the head of the linked list
         * @return: head of the linked list
         */
        public ListNode deleteDuplicates(ListNode head) {
            ListNode pile = new ListNode(Integer.MIN_VALUE);
            
            pile.next = head;
            
            head = pile;
            ListNode.show(head);
            while (head.next != null) {
                if (head.next == null || head.next.next == null)
                    break;
                
                if (head.next.next.next!= null && head.next.val == head.next.next.next.val) {
                    head.next = head.next.next;
                } else if (head.next.val == head.next.next.val) {
                    head.next = head.next.next.next;
                } else {
                    head = head.next;
                }
            }
            
            return pile.next;
        }
    }
    
    public static void main(String[] args) {
        ListNode head = ListNode.parse("{1,1,1,2,3,3,4}");
        ListNode.show(head);
        head = new Solution().deleteDuplicates(head);
        ListNode.show(head);
        
    }

}
