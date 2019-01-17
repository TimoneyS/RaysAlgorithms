package com.ray.LintCode.resolved;

import com.ray.LintCode.util.ListNode;
import com.ray.io.Out;

/**
 * Given a linked list, determine if it has a cycle in it.
 *
 * @author rays1
 *
 */
public class L_0102_Linked_List_Cycle {

    static class Solution {
        
        /**
         * @param head: The first node of linked list.
         * @return: True if it has a cycle, or false
         */
        public boolean hasCycle(ListNode head) {
            ListNode n1 = head, n2 = head;
            while (true) {
                if (n1 == null || n2 == null || n2.next == null) return false;
                n1 = n1.next;
                n2 = n2.next.next;
                if (n1 == n2) return true;
            }
        }
        
    }
    
    public static void main(String[] args) {
        ListNode head = ListNode.parse("{1,2,3}");
        
        Out.p(new Solution().hasCycle(head));
    }

}
