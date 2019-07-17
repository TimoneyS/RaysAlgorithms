package com.ray.LintCode.done;

import com.ray.LintCode.util.ListNode;

/**
 * 描述：
 *      翻转链表中位置 m 到 n 之间的元素
 *
 * 用例：
 *      Example 1:
 *      Input: 1->2->3->4->5->NULL, m = 2 and n = 4, 
 *      Output: 1->4->3->2->5->NULL.

 * 挑战：
 *      原地一次遍历完成
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/reverse-linked-list-ii/description
 * @date   2019-07-11 17:42:48
 */
public class L_0036_Reverse_Linked_List_II {

    /**
     * 先遍历找到中断点
     * 
     *      翻转部分会有 head -> ... -> tail
     *      
     * 完全翻转后，需要将中断点链接新链的head
     * 中新链的尾部需要链接原链的后续部分。
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (m == n) return head;
            
            int index = 0;
            ListNode oldHead  = head;
            ListNode cut  = null;   // 开始翻转的中断点
            ListNode tail = null;
            ListNode prev = null;
            ListNode next = null;
            
            while (index < m) {
                index ++;
                
                tail = head;
                cut  = prev;
                
                next = head.next;
                prev = head;
                head = next;
            }
            
            while (index < n) {
                index ++;
                next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }

            tail.next = head;

            if (cut == null) {
                return prev;
            } else {
                cut.next = prev;
                return oldHead;
            }

        }

    }
    
    public static void main(String[] args) {
        ListNode head = ListNode.parse("{1,2,3,4,5}");
        head.show();
        head = new Solution().reverseBetween(head, 2, 4);
        head.show();
    }

}
