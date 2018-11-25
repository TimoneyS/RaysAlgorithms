package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Reverse a linked list from position m to n.
 * 
 * Example : Given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.
 * @author rays1
 *
 */
public class L_0036_Reverse_Linked_List_II {
    
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
        
        @Override
        public String toString() {
            return val + "";
        }
    }
    
    static class Solution {
        /**
         * @param head: ListNode head is the head of the linked list 
         * @param m: An integer
         * @param n: An integer
         * @return: The head of the reversed ListNode
         */
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (m == n) return head;
            
            int index = 0;
            ListNode oldHead  = head;
            ListNode cut  = null;   // 开始翻转的中断点
            ListNode tail = null;
            ListNode prev = null;
            ListNode temp = null;
            
            while (index < n) {
                index ++;
                if (index == m) {
                    tail = head;
                    cut  = prev;
                }
                temp = head.next;
                if (index >= m && index <= n) head.next = prev;
                prev = head;
                head = temp;
            }
            
            tail.next = head;
            
            if (cut == null)
                return prev;
            else {
                cut.next = prev;
                return oldHead;
            }
            
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
        
        
        ListNode head = createListNode(new int[] {1,2,3});
        
        printListNode(head);
        head = new Solution().reverseBetween(head, 2, 3);
        printListNode(head);        
        
        
    }
    
    
}
