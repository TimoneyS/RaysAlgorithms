package com.ray.LintCode.resolved;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * 给定一个链表，和一个值 x
 * 将所有的 小于 x 的结点放到大于等于 x 的结点之前
 * 
 * @author rays1
 *
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
            ListNode head = ListNode.generate("{1,4,3,2,5,2}");
            int x = 3;
            
            ListNode.show(new Solution().partition(head, x));
            
        }
        
    }

}
