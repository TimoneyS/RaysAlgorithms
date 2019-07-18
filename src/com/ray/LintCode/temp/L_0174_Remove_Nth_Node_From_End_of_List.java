package com.ray.LintCode.temp;

import com.ray.LintCode.util.ListNode;

/**
 * 描述：
 *      Given a linked list, remove the n<sup>th</sup> node from the end of list and return its head.
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input: list = 1->2->3->4->5->null， n = 2
 *      	Output: 1->2->3->5->null
 *      
 *      
 *      Example 2:
 *      	Input:  list = 5->4->3->2->1->null, n = 2
 *      	Output: 5->4->3->1->null
 *      
 *      ```
 *
 * 挑战：
 *      Can you do it without getting the length of the linked list?
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/remove-nth-node-from-end-of-list/description
 * @date   2019-07-11 18:31:34
 */
public class L_0174_Remove_Nth_Node_From_End_of_List {


    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            
            ListNode front = head, behind = head;
            
            for (int i = 0; i < n; i++) {
                front = front.next;
            }
            
            while (front!=null && front.next != null) {
                behind = behind.next;
                front = front.next;
            }
            
            if (behind == head) {
                return behind.next;
            }
            
            if (behind.next != null)
                behind.next = behind.next.next;
            
            return head;
        }
    }
    
    public static void main(String[] args) {
        
        ListNode head = ListNode.parse("{1,2,3,4}");
        int n = 4;
        
        ListNode.show(head);
        head = new Solution().removeNthFromEnd(head, n);
        ListNode.show(head);
    }

}
