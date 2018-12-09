package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * Given a linked list, return the node where the cycle begins.
 *
 * 检测链表中的环，若有环，返回环的起始顶点
 * 否则返回 null
 *
 * @author rays1
 *
 */
public class L_0103_Linked_List_Cycle_II {

    /**
     * xxxxxxxxxxxx yyyyyyyy
     * 
     * xxxxxxxxxxxx yyyyyyyy
     *              yyyyyyyyyyyyyyy
     *              yyyyyyyyyyyyyyy
     *              
     * 假设 非环部分长度为 x 环的部分长度为  y
     * 
     * 则慢遍历长度   ： x + y1
     *   快遍历长度   ： x + y2
     * 快遍历长度为慢遍历长度的 2 倍
     *      2*(x+y1) = x + y2
     *      x + 2*y1 = y2
     * 可得 
     *      y2 - y1 = x + y1
     * 同时在环的部分，y2 - y1 = n * y
     * 则可得
     *      x + y1 = n * y
     *      x = n * y - y1
     * 表示从x开始遍历到环的起点，和从慢遍历的终点到环的起点的距离是一样的（或者满遍历多绕几圈）
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        /**
         * @param head: The first node of linked list.
         * @return: The node where the cycle begins. if there is no cycle, return null
         */
        public ListNode detectCycle(ListNode head) {
            if (head == null) return null;
            
            ListNode n1 = head, n2 = head.next;
            while (n1 != n2) {
                if (n2 == null || n2.next == null)
                    return null;
                n1 = n1.next;
                n2 = n2.next.next;
            }
            Out.p(n1.val);
            while (head != n1.next) {
                head = head.next;
                n1 = n1.next;
            }
            return head;
        }
        
    }
    
    public static void main(String[] args) {
        
        ListNode head = ListNode.generate("{1,1,1,2,3,4,5,6}");
        head.nextVal(6).next = head.nextVal(2);
        
        Out.p(new Solution().detectCycle(head).val);
        
    }

}
