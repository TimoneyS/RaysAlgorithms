package com.ray.LintCode.done;

import com.ray.LintCode.util.ListNode;

/**
 * 描述：
 *      <p>
 *      Given a sorted linked list, delete all duplicates such that each element appear only <i>once</i>.
 *      </p>
 *      <p>
 *      </p>
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input:  null
 *      	Output: null
 *      
 *      
 *      Example 2:
 *      	Input:  1->1->2->null
 *      	Output: 1->2->null
 *      	
 *      Example 3:
 *      	Input:  1->1->2->3->3->null
 *      	Output: 1->2->3->null
 *      	
 *      
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/remove-duplicates-from-sorted-list/description
 * @date   2019-07-11 18:30:42
 */
public class L_0112_Remove_Duplicates_from_Sorted_List {

    static class Solution {
        /**
         * @param head: head is the head of the linked list
         * @return: head of linked list
         */
        public ListNode deleteDuplicates(ListNode head) {
            ListNode pile = new ListNode(Integer.MIN_VALUE);
            pile.next = head;
            
            head = pile;
            while (head.next != null) {
                if (head.val == head.next.val) {
                    head.next = head.next.next;
                } else {
                    head = head.next;
                }
            }
            return pile.next;
        }
    }
    
    public static void main(String[] args) {
        ListNode head = ListNode.parse("{}");
        ListNode.show(head);
        head = new Solution().deleteDuplicates(head);
        ListNode.show(head);
    }

}
