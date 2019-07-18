package com.ray.LintCode.temp;

import com.ray.LintCode.util.ListNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Implement a function to check if a linked list is a palindrome.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input: 1->2->1
 *      output: true
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input: 2->2->1
 *      output: false
 *      ```
 *
 * 挑战：
 *      Could you do it in O(n) time and O(1) space?
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/palindrome-linked-list/description
 * @date   2019-07-11 18:32:01
 */
public class L_0223_Palindrome_Linked_List {

    /**
     * 利用快慢结点，慢结点在前进的同时逆转链表。
     * @author rays1
     *
     */
    static class Solution {
        
        public boolean isPalindrome(ListNode head) {
            ListNode slow = head, fast = head;
            ListNode pprev = null;
            ListNode prev = null;
            while (fast != null && fast.next != null) {
                pprev = prev;
                prev  = slow;
                slow  = slow.next;
                fast = fast.next.next;
                
                prev.next = pprev;
            }
            
            if (fast != null) {
                slow = slow.next;
            }
            
            
            boolean rs = true;
            while (prev != null && slow != null) {
                if (prev.val != slow.val) {
                    rs = false;
                    break;
                }
                prev = prev.next;
                slow = slow.next;
            }
            
            return rs;
        }
        
    }
    
    public static void main(String[] args) {
        
        
        ListNode head = ListNode.parse("{1,2}");
        boolean rs = new Solution().isPalindrome(head);
        Out.p(rs);
    }

}
