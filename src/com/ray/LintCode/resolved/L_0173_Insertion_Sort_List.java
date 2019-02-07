package com.ray.LintCode.resolved;

import com.ray.LintCode.util.ListNode;

/**
 * 用插入排序的思想，排序链表
 *
 * @author rays1
 *
 */
public class L_0173_Insertion_Sort_List {

    /**
     * 插入排序将链表分为两部分，已排序和未排序部分
     * 
     * 插入排序每次从未排序部分寻找最小的结点，插入已经排序的部分的末尾
     * 
     * @author rays1
     *
     */
    static class Solution {
        public ListNode insertionSortList(ListNode head) {
            
            ListNode pile = new ListNode(Integer.MIN_VALUE);
            pile.next     = head;
            
            ListNode lastSorted = pile;
            while (lastSorted.next != null) {
                
                // 从 lastSorted 之后寻找最小结点的前置结点
                ListNode prev = lastSorted;
                for (ListNode n = lastSorted; n.next != null; n = n.next) {
                    if (n.next.val < prev.next.val) {
                        prev = n;
                    }
                }
                
                // 将min结点从原位置移除
                ListNode min    = prev.next;
                prev.next       = prev.next.next;
                // min结点插入已经排序的末尾
                min.next        = lastSorted.next;
                lastSorted.next = min;
                
                lastSorted      = lastSorted.next;
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
