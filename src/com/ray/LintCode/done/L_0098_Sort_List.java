package com.ray.LintCode.done;

import com.ray.LintCode.util.ListNode;

/**
 * 描述：
 *      Sort a linked list in O(*n* log *n*) time using constant space complexity.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input:  1->3->2->null
 *      Output:  1->2->3->null
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: 1->7->2->6->null
 *      Output: 1->2->6->7->null	
 *      ```
 *
 * 挑战：
 *      Solve it by merge sort & quick sort separately.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/sort-list/description
 * @date   2019-07-11 18:30:30
 */
public class L_0098_Sort_List {

    static class Solution {
        
        public ListNode sortList(ListNode head) {
            return sort(head, null);
        }
        
        public ListNode sort(ListNode head, ListNode tail) {
            
            if (head == tail || head ==null || head.next == null ) return head;
            
            ListNode t = head;
            ListNode mid = head;
            
            int l = 0,m = 0;
            while (t != tail) {
                if (m < l / 2) {
                    m = l / 2;
                    mid = mid.next;
                }
                l ++;
                t = t.next;
            }
            
            t = mid.next;
            mid.next = null;
            ListNode n1 = sort(head, mid);
            ListNode n2 = sort(t, tail);
            
            return merge(n1, n2);
        }
        
        public ListNode merge(ListNode n1, ListNode n2) {
            ListNode pile = new ListNode(0);
            ListNode head = pile;
            while (true) {
                if (n1 == null) {
                    head.next = n2;
                    break;
                } else if (n2 == null) {
                    head.next = n1;
                    break;
                } else {
                    if (n1.val < n2.val) {
                        head.next = n1;
                        n1 = n1.next;
                    } else {
                        head.next = n2;
                        n2 = n2.next;
                    }
                }
                head = head.next;
            }
            return pile.next;
        }
        
    }
    
    public static void main(String[] args) {
        
        ListNode head = ListNode.parse("{5,2,6,4,1,7}");
        
        ListNode rs = new Solution().sortList(head);
        ListNode.show(rs);
    }

}
