package com.ray.LintCode.resolved;

/**
 * Merge two sorted (ascending) linked lists and return it as a new sorted list.
 * The new sorted list should be made by splicing together the nodes of the two lists and sorted in ascending order.
 *
 * @author rays1
 *
 */
public class L_0165_Merge_Two_Sorted_Lists {

    static class Solution {
        
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode pile = new ListNode(0);
            
            ListNode n = pile;
            while (true) {
                if (l1 == null) { n.next = l2;break; }
                if (l2 == null) { n.next = l1;break; }
                if (l1.val < l2.val) {
                    n.next = l1;
                    n = n.next;
                    l1 = l1.next;
                    
                    n.next = null;
                } else {
                    n.next = l2;
                    n = n.next;
                    l2 = l2.next;
                    
                    n.next = null;
                }
                
            }
            
            return pile.next;
        }
    }
    
    public static void main(String[] args) {
        
        ListNode l1 = ListNode.parse("{1,4,6,8}");
        ListNode l2 = ListNode.parse("{2,5,7}");
        
        ListNode.show(l1);
        ListNode.show(l2);
        
        Solution sol = new Solution();
        ListNode n = sol.mergeTwoLists(null, l2);
        
        ListNode.show(n);
    }

}
