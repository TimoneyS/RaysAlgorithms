package com.ray.LintCode.temp;

import com.ray.LintCode.util.ListNode;

/**
 * 描述：
 *      <p>Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only <i>distinct</i> numbers from the original list.
 *      </p>
 *
 * 用例：
 *      ***Example 1***
 *      ```
 *      Input : 1->2->3->3->4->4->5->null
 *      Output : 1->2->5->null
 *      ```
 *      
 *      ***Example 2***
 *      ```
 *      Input : 1->1->1->2->3->null
 *      Output : 2->3->null
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/remove-duplicates-from-sorted-list-ii/description
 * @date   2019-07-11 18:30:43
 */
public class L_0113_Remove_Duplicates_from_Sorted_List_II {

    static class Solution {
        /**
         * @param head: head is the head of the linked list
         * @return: head of the linked list
         */
        public ListNode deleteDuplicates(ListNode head) {
            ListNode pile = new ListNode(Integer.MIN_VALUE);
            
            pile.next = head;
            
            head = pile;
            ListNode.show(head);
            while (head.next != null) {
                if (head.next == null || head.next.next == null)
                    break;
                
                if (head.next.next.next!= null && head.next.val == head.next.next.next.val) {
                    head.next = head.next.next;
                } else if (head.next.val == head.next.next.val) {
                    head.next = head.next.next.next;
                } else {
                    head = head.next;
                }
            }
            
            return pile.next;
        }
    }
    
    public static void main(String[] args) {
        ListNode head = ListNode.parse("{1,1,1,2,3,3,4}");
        ListNode.show(head);
        head = new Solution().deleteDuplicates(head);
        ListNode.show(head);
        
    }

}
