package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Reverse a linked list.
 * 
 * Example : For linked list 1->2->3, the reversed linked list is 3->2->1
 * 
 * Challenge : Reverse it in-place and in one-pass
 * @author rays1
 *
 */
public class L_035_Reverse_linked_list {
    
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
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
    
    static void printListNode(ListNode head) {
        while (head != null) {
            Out.pt(head.val);
            if (head.next != null)
                Out.pt("->");
            head = head.next;
        }
        Out.p();
    }
    
    static ListNode createListNode(int[] arr) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        for (int i : arr) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        return head.next;
    }
    
    public static void main(String[] args) {
        ListNode head = createListNode(new int[]{1,2,3});
        printListNode(head);
        ListNode newHead = new Solution().reverse(head);
        printListNode(newHead);
    }
    
}
