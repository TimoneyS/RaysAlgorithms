package com.ray.LintCode.done;

import com.ray.LintCode.util.ListNode;
import com.ray.io.Out;

/**
 * 描述：
 *      You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in `reverse` order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: 7->1->6->null, 5->9->2->null
 *      Output: 2->1->9->null	
 *      Explanation: 617 + 295 = 912, 912 to list:  2->1->9->null
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input:  3->1->5->null, 5->9->2->null
 *      Output: 8->0->8->null	
 *      Explanation: 513 + 295 = 808, 808 to list: 8->0->8->null
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/add-two-numbers/description
 * @date   2019-07-11 18:31:28
 */
public class L_0167_Add_Two_Numbers {

    static class Solution {
        public ListNode nthToLast(ListNode head, int n) {
            
            ListNode n1 = null, n2;
            
            int dist = 0;
            n2 = head;
            while (true) {
                if (dist == n) {
                    n1 = head;
                    break;
                }
                n2 = n2.next;
                dist++;
            }
            
            while (n1 != null && n2 != null) {
                n1 = n1.next;
                n2 = n2.next;
            }
            
            return n1;
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
