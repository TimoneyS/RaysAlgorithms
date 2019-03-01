package com.ray.LintCode.resolved;

import com.ray.LintCode.util.ListNode;
import com.ray.io.Out;

/**
 * 给定一个链表，检测是否有环
 *
 * @author rays1
 *
 */
public class L_0102_Linked_List_Cycle {

    static class Solution {
        
        public boolean hasCycle(ListNode head) {
            ListNode slow = head, fast = head;
            while (true) {
                if (slow == null || fast == null || fast.next == null) return false;
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) return true;
            }
        }
        
    }
    
    public static void main(String[] args) {
        ListNode head = ListNode.parse("{1,2,3}");
        
        Out.p(new Solution().hasCycle(head));
    }

}
