package com.ray.LintCode.resolved;

import com.ray.LintCode.help.ListNode;

/**
 * 
 * Given a singly linked list L: L0 → L1 → … → Ln-1 → Ln
 * reorder it to: L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 * 
 * @author rays1
 *
 */
public class L_0099_Reorder_List {

    static class Solution {
        /**
         * @param head: The head of linked list.
         * @return: nothing
         */
        public void reorderList(ListNode head) {
            if (head == null) return;
            
            int l = 0;
            ListNode t = head;
            while (t !=null) {
                l ++;
                t = t.next;
            }
            r (head, 1, l);
            
            return;
        }
        
        public ListNode r (ListNode head, int l, int r) {
            ListNode rs = null;
            ListNode t = null;
            if (r-l == 1) {
                rs = head.next;
                t = rs.next;
                rs.next = null;
            } else if (r == l) {
                rs = head;
                t = rs.next;
                rs.next = null;
            } else {
                rs = r(head.next, l+1, r-1);
                t = rs.next;
                rs.next = head.next;
                head.next = rs;
            }
            return t;
        }
        
    }

    public static void main(String[] args) {
        
        ListNode head = ListNode.parse("{1,2,3,4,5,6}");
        
        new Solution().reorderList(head);
        
        ListNode.show(head);
    }
    
}
