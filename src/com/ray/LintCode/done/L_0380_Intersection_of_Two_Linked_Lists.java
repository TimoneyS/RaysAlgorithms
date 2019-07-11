package com.ray.LintCode.done;

import com.ray.LintCode.util.ListNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input:
 *      	A:          a1 → a2
 *      	                   ↘
 *      	                     c1 → c2 → c3
 *      	                   ↗            
 *      	B:     b1 → b2 → b3
 *      Output: c1
 *      Explanation ：begin to intersect at node c1.
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input:
 *      Intersected at 6
 *      1->2->3->4->5->6->7->8->9->10->11->12->13->null
 *      6->7->8->9->10->11->12->13->null
 *      Output: Intersected at 6
 *      Explanation：begin to intersect at node 6.
 *      ```
 *
 * 挑战：
 *      Your code should preferably run in O(*n*) time and use only O(*1*) memory.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/intersection-of-two-linked-lists/description
 * @date   2019-07-11 18:32:20
 */
public class L_0380_Intersection_of_Two_Linked_Lists {


    /**
     * 过河拆桥的解法，先用一个结点再遍历的过程中，将所有的节点都指向桩节点
     * 第二个结点遍历时，发现的第一个指向桩的结点，就是交汇的结点。
     * 如果没有发现此类结点，则说明无交汇结点。
     * @author rays1
     *
     */
    static class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode rs = null;
            
            ListNode pile = new ListNode(Integer.MAX_VALUE);
            ListNode prev = headA;
            while ((prev = headA) != null) {
                headA = headA.next;
                prev.next = pile;
            }
            
            while (headB != null && headB.next != null) {
                if (headB.next.val == pile.val) {
                    rs = headB;
                    break;
                }
                headB = headB.next;
            }
            
            return rs;
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
