package com.ray.LintCode.done;

import com.ray.LintCode.util.ListNode;

/**
 * 描述：
 *      Reverse a linked list from position m to n.
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input: 1->2->3->4->5->NULL, m = 2 and n = 4, 
 *      Output: 1->4->3->2->5->NULL.
 *      ```
 *      
 *      Example 2:
 *      ```
 *      Input: 1->2->3->4->NULL, m = 2 and n = 3, 
 *      Output: 1->3->2->4->NULL.
 *      ```
 *
 * 挑战：
 *      <p>Reverse it in-place and in one-pass</p>
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/reverse-linked-list-ii/description
 * @date   2019-07-11 17:42:48
 */
public class L_0036_Reverse_Linked_List_II {

    static class Solution {
        /**
         * @param head: ListNode head is the head of the linked list 
         * @param m: An integer
         * @param n: An integer
         * @return: The head of the reversed ListNode
         */
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (m == n) return head;
            
            int index = 0;
            ListNode oldHead  = head;
            ListNode cut  = null;   // 开始翻转的中断点
            ListNode tail = null;
            ListNode prev = null;
            ListNode temp = null;
            
            while (index < n) {
                index ++;
                if (index == m) {
                    tail = head;
                    cut  = prev;
                }
                temp = head.next;
                if (index >= m && index <= n) head.next = prev;
                prev = head;
                head = temp;
            }
            
            tail.next = head;
            
            if (cut == null)
                return prev;
            else {
                cut.next = prev;
                return oldHead;
            }
            
        }
    }
    
    public static void main(String[] args) {
        
        ListNode head = ListNode.parse("{1,2,3}");
        
        head.show();
        head = new Solution().reverseBetween(head, 2, 3);
        head.show();
        
    }

}
