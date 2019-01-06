package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 判断链表是否回文
 *
 * @author rays1
 *
 */
public class L_0223_Palindrome_Linked_List {

    /**
     * 利用快慢结点，慢结点在前进的同时逆转链表。
     * @author rays1
     *
     */
    static class Solution {
        
        public boolean isPalindrome(ListNode head) {
            ListNode slow = head, fast = head;
            ListNode pprev = null;
            ListNode prev = null;
            while (fast != null && fast.next != null) {
                pprev = prev;
                prev  = slow;
                slow  = slow.next;
                fast = fast.next.next;
                
                prev.next = pprev;
            }
            
            if (fast != null) {
                slow = slow.next;
            }
            
            
            boolean rs = true;
            while (prev != null && slow != null) {
                if (prev.val != slow.val) {
                    rs = false;
                    break;
                }
                prev = prev.next;
                slow = slow.next;
            }
            
            return rs;
        }
        
    }
    
    public static void main(String[] args) {
        
        
        ListNode head = ListNode.parse("{1,2}");
        boolean rs = new Solution().isPalindrome(head);
        Out.p(rs);
    }

}
