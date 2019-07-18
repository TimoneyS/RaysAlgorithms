package com.ray.LintCode.temp;

import com.ray.LintCode.util.ListNode;
import com.ray.io.Out;

/**
 * 描述：
 *      You have two numbers represented by linked list, where each node contains a single digit. The digits are stored in `forward` order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input: 6->1->7   2->9->5
 *      Output: 9->1->2
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input: 1->2->3   4->5->6
 *      Output: 5->7->9
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/add-two-numbers-ii/description
 * @date   2019-07-11 18:32:00
 */
public class L_0221_Add_Two_Numbers_II {

    static class Solution {
        
        /**
         * @param l1: the first list
         * @param l2: the second list
         * @return: the sum list of l1 and l2 
         */
        public ListNode addLists2(ListNode l1, ListNode l2) {
            ListNode n1 = l1;
            ListNode n2 = l2;
            while ( n1!= null || n2 != null) {
                if (n1 == null)
                    l1 = cover(l1, 0);
                else if (n2 == null)
                    l2 = cover(l2, 0);

                n1 = next(n1);
                n2 = next(n2);
            }
            
            ListNode rs = plus(l1, l2, null);
            int num = rs.val / 10;
            if( num != 0) {
                if(rs != null) rs.val = val(rs) % 10;
                rs = cover(rs, num);
            }
            
            return rs;
        }
        
        public ListNode next(ListNode node) {
            return (node == null ? null : node.next);
            
        }
        
        public ListNode plus(ListNode l1, ListNode l2, ListNode rsNode) {
            if(l1 == null && l2 == null) return rsNode;
            
            rsNode = plus(next(l1), next(l2), rsNode);
            
            int num    = l1.val + l2.val + val(rsNode)/10;
            if(rsNode != null) rsNode.val = val(rsNode) % 10;
            return cover(rsNode, num);
        }
        
        public int val (ListNode node) {
            return node == null ? 0 : node.val ;
        }
        
        public ListNode cover(ListNode node, int num) {
            ListNode n = new ListNode(num);
            n.next = node;
            return n;
        }
        
        public int carry(ListNode l1, ListNode l2) {
            return ( 
                    (l1 == null ? 0 : l1.val)
                  + (l2 == null ? 0 : l2.val)
                    ) / 10;
        }
        
        
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
