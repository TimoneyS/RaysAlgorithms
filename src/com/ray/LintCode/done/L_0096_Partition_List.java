package com.ray.LintCode.done;

import com.ray.LintCode.util.ListNode;

/**
 * 描述：
 *      Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *      
 *      You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input:  list = null, x = 0
 *      Output: null	
 *      Explanation: The empty list Satisfy the conditions by itself.
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input:  list = 1->4->3->2->5->2->null, x = 3
 *      Output: 1->2->2->4->3->5->null	
 *      Explanation:  keep the original relative order of the nodes in each of the two partitions.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/partition-list/description
 * @date   2019-07-11 18:30:11
 */
public class L_0096_Partition_List {

    static  class Solution {
        
        /**
         * @param head: The first node of linked list
         * @param x: An integer
         * @return: A ListNode
         */
        public ListNode partition(ListNode head, int x) {
            
            ListNode tail = null;
            ListNode pile = new ListNode(x-1);
            pile.next = head;
            tail = pile;
            
            head = pile;
            
            while (head != null && head.next != null) {
                
                if (head.next.val < x) {
                    ListNode n = head.next;
                    head.next = head.next.next;
                    
                    n.next = tail.next;
                    tail.next = n;
                    
                    if (head == tail)
                        head = head.next;
                    tail = tail.next;
                } else {
                    head = head.next;
                }
                
                ListNode.show(pile.next);
            }
            
            return pile.next;
        }
        
        public static void main(String[] args) {
            ListNode head = ListNode.parse("{1,4,3,2,5,2}");
            int x = 3;
            
            ListNode.show(new Solution().partition(head, x));
            
        }
        
    }

}
