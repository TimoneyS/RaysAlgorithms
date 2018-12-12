package com.ray.LintCode.resolved;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3
 * 
 * @author rays1
 *
 */
public class L_0112_Remove_Duplicates_from_Sorted_List {

    static class Solution {
        /**
         * @param head: head is the head of the linked list
         * @return: head of linked list
         */
        public ListNode deleteDuplicates(ListNode head) {
            ListNode pile = new ListNode(Integer.MIN_VALUE);
            pile.next = head;
            
            head = pile;
            while (head.next != null) {
                if (head.val == head.next.val) {
                    head.next = head.next.next;
                } else {
                    head = head.next;
                }
            }
            return pile.next;
        }
    }
    
    public static void main(String[] args) {
        ListNode head = ListNode.generate("{}");
        ListNode.show(head);
        head = new Solution().deleteDuplicates(head);
        ListNode.show(head);
    }

}
