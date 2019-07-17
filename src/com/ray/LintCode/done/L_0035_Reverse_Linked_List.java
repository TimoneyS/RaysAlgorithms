package com.ray.LintCode.done;

import com.ray.LintCode.util.ListNode;

/**
 * 描述：
 *      翻转链表
 *
 * 用例：
 *      **用例 1:**
 *      输入: 1->2->3->null
 *      输出: 3->2->1->null
 *
 * 挑战：
 *      原地翻转
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/reverse-linked-list/description
 * @date   2019-07-11 17:42:25
 */
public class L_0035_Reverse_Linked_List {

    /**
     * 
     *  prev -> node -> next
     *  prev <- node <- next
     *  
     *  // 只需要翻转 node 和 prev 的链接，然后前进一格
     *  node.next = prev;
     *  
     *  // 下一次循环会处理下一个链
     *  prev = node
     *  node = next
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        public ListNode reverse(ListNode node) {
            ListNode prev = null;
            ListNode next = null;
            while (node != null) {
                next = node.next;
                
                node.next = prev;
                prev = node;
                node = next;
                
            }
            return prev;
        }
    }
    
    public static void main(String[] args) {
        ListNode head = ListNode.parse("{1,2,3}");
        head.show();
        ListNode newHead = new Solution().reverse(head);
        newHead.show();
    }

}
