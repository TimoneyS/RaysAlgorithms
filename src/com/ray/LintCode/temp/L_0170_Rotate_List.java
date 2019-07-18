package com.ray.LintCode.temp;

import com.ray.LintCode.util.ListNode;

/**
 * 描述：
 *      Given a list, rotate the list to the right by `k` places, where *k* is non-negative.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:1->2->3->4->5  k = 2
 *      Output:4->5->1->2->3
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input:3->2->1  k = 1
 *      Output:1->3->2
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/rotate-list/description
 * @date   2019-07-11 18:31:31
 */
public class L_0170_Rotate_List {
    /**
     * 用前后相距k的两个结点begin, front，在链表上前进。
     * 当 front到达尾部时，则表明需要从 begin 之后截断链表，将之后的部分移动到 head 之前。
     * @author rays1
     *
     */
    static class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null) return head;
            ListNode behind = head, front = head;
            
            for (int i = 1; i <= k; i++) {
                front = front.next;
                if (front == null) {
                    front = head;
                }
            }
            
            while (front.next != null) {
                behind = behind.next;
                front = front.next;
            }
            
            front.next = head;
            head = behind.next;
            behind.next = null;
            
            return head;
        }
        
    }

    public static void main(String[] args) {
        
        ListNode head = ListNode.parse("{1,3}");
        int k = 100;
        
        Solution sol = new Solution();
        head = sol.rotateRight(head, k);
        
        ListNode.show(head);
        
    }
}
