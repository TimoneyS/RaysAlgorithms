package com.ray.LintCode.resolved;

/**
 * 插入排序，排序链表
 *
 * @author rays1
 *
 */
public class L_0173_Insertion_Sort_List {

    static class Solution {
        public ListNode insertionSortList(ListNode head) {
            ListNode pile = new ListNode(Integer.MIN_VALUE);
            pile.next = head;
            
            ListNode sortedTail = pile;
            
            while (sortedTail.next != null) {
                // 从 sortedTail 之后寻找最小元素
                ListNode beforMin = sortedTail;
                for (ListNode n = sortedTail; n.next != null; n = n.next) {
                    if (n.next.val < beforMin.next.val) {
                        beforMin = n;
                    }
                }
                
                ListNode min = beforMin.next;
                beforMin.next        = beforMin.next.next;
                min.next = sortedTail.next;
                sortedTail.next = min;
                sortedTail      = sortedTail.next;
            }
            
            return pile.next;
        }
    }
    
    public static void main(String[] args) {
        
        ListNode head = ListNode.parse("{5,3,2,7,4,6}");
        
        ListNode.show(head);
        head = new Solution().insertionSortList(head);
        ListNode.show(head);
        
    }

}
