package com.ray.LintCode.temp;

import com.ray.leetcode.util.ListNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Given a node from a cyclic linked list which has been sorted, write a function to insert a value into the list such that it remains a cyclic sorted list. The given node can be any single node in the list. Return the inserted new node.
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input:
 *      3->5->1
 *      4
 *      Output:
 *      5->1->3->4
 *      ```
 *      
 *      Example 2:
 *      ```
 *      Input:
 *      2->2->2
 *      3
 *      Output:
 *      3->2->2->2
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/insert-into-a-cyclic-sorted-list/description
 * @date   2019-07-11 18:34:23
 */
public class L_0599_Insert_into_a_Cyclic_Sorted_List {

    /**
     * 环形链表不需要考虑插入头部或尾部的问题，因为循环总会使得新的结点是插入到两个结点之间
     * 
     * 那么两个结点就有两种情况
     *      1. 增序的两个结点之间
     *          prev - > newNode -> next 
     *      
     *      2. 头尾之间
     *          head - > newNode -> tail
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public ListNode insert(ListNode node, int x) {
            
            if (node  == null) {
                node = new ListNode(x);
                node.next = node;
                return node;
            }
            
            ListNode head = node;
            
            ListNode prev = node;
            node          = node.next;
            while (node != head) {
                if (prev.val <= node.val) {
                    if (prev.val <= x && node.val >= x) break;
                } else {
                    if (prev.val <= x || node.val >= x) break;
                }
                prev = node;
                node = node.next;
            }
            
            ListNode t = new ListNode(x);
            
            prev.next = t;
            t.next = node;
            
            return prev;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
