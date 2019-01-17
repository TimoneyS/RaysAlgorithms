package com.ray.LintCode.resolved;

import com.ray.LintCode.util.ListNode;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * Given linked list: 1->2->3->4->5->null, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5->null.
 * 
 * 删除倒数第 n 个结点
 * 
 * @author rays1
 *
 */
public class L_0174_Remove_Nth_Node_From_End_of_List {

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            
            ListNode front = head, behind = head;
            
            for (int i = 0; i < n; i++) {
                front = front.next;
            }
            
            while (front!=null && front.next != null) {
                behind = behind.next;
                front = front.next;
            }
            
            if (behind == head) {
                return behind.next;
            }
            
            if (behind.next != null)
                behind.next = behind.next.next;
            
            return head;
        }
    }
    
    public static void main(String[] args) {
        
        ListNode head = ListNode.parse("{1,2,3,4}");
        int n = 4;
        
        ListNode.show(head);
        head = new Solution().removeNthFromEnd(head, n);
        ListNode.show(head);
    }

}
