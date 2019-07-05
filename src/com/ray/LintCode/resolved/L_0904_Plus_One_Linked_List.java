package com.ray.LintCode.resolved;

import com.ray.LintCode.util.ListNode;
import com.ray.io.Out;

/**
 * Description :
 *   Given a non-negative integer represented as **non-empty** a singly linked list of digits, plus one to the integer.
 * 
 *   You may assume the integer do not contain any leading zero, except the number 0 itself.
 * 
 *   The digits are stored such that the most significant digit is at the head of the list.
 *
 * Example :
 *   **Example1**
 *    ```
 *    Input: 1 -> 2 -> 3 -> null
 *    Output: 1 -> 2 -> 4 -> null
 *    Explanation:
 *    123 + 1 = 124
 *    ```
 *   
 *   **Example2**
 *    ```
 *    Input: 9 -> 9 -> null
 *    Output: 1 -> 0 -> 0 -> null
 *    Explanation:
 *    99 + 1 = 100
 *    ```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/plus-one-linked-list/description
 * @date   2019-07-03 17:34:10
 */
public class L_0904_Plus_One_Linked_List {

    /**
     * 运用桩，递归到最后一位加1，然后在结束递归后依次处理进位。
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public ListNode plusOne(ListNode head) {
            ListNode pile = new ListNode(0);
            pile.next = head;
            helper(pile);
            if (pile.val == 1) head = pile;
            return head;
        }
        
        public void helper(ListNode node) {
            if (node.next == null) {
                node.val += 1;
            } else {
                helper(node.next);
                if (node.next.val >= 10) {
                    node.next.val -= 10;
                    node.val += 1;
                }
            }
        }
    }
    
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
