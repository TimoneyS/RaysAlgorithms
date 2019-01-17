package com.ray.LintCode.resolved;

import com.ray.LintCode.util.ListNode;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * 链表排序
 * 
 * @author rays1
 *
 */
public class L_0098_Sort_List {

    
    static class Solution {
        
        public ListNode sortList(ListNode head) {
            return sort(head, null);
        }
        
        public ListNode sort(ListNode head, ListNode tail) {
            
            if (head == tail || head ==null || head.next == null ) return head;
            
            ListNode t = head;
            ListNode mid = head;
            
            int l = 0,m = 0;
            while (t != tail) {
                if (m < l / 2) {
                    m = l / 2;
                    mid = mid.next;
                }
                l ++;
                t = t.next;
            }
            
            t = mid.next;
            mid.next = null;
            ListNode n1 = sort(head, mid);
            ListNode n2 = sort(t, tail);
            
            return merge(n1, n2);
        }
        
        public ListNode merge(ListNode n1, ListNode n2) {
            ListNode pile = new ListNode(0);
            ListNode head = pile;
            while (true) {
                if (n1 == null) {
                    head.next = n2;
                    break;
                } else if (n2 == null) {
                    head.next = n1;
                    break;
                } else {
                    if (n1.val < n2.val) {
                        head.next = n1;
                        n1 = n1.next;
                    } else {
                        head.next = n2;
                        n2 = n2.next;
                    }
                }
                head = head.next;
            }
            return pile.next;
        }
        
    }
    
    public static void main(String[] args) {
        
        ListNode head = ListNode.parse("{5,2,6,4,1,7}");
        
        ListNode rs = new Solution().sortList(head);
        ListNode.show(rs);
    }

}
