package com.ray.LintCode.done;

import com.ray.LintCode.util.ListNode;
import com.ray.util.Timer;

/**
 * 描述：
 *      给定一个单链表和数值x，划分链表使得所有小于x的节点排在大于等于x的节点之前。
 *      你应该保留两部分内链表节点原有的相对顺序。
 * 用例：
 *      **Example 1:**
 *      Input:  list = 1->4->3->2->5->2->null, x = 3
 *      Output: 1->2->2->4->3->5->null	
 *      Explanation:  keep the original relative order of the nodes in each of the two partitions.
 * 难度： Simple
 *   
 * @author rays1
 * @link   https://www.lintcode.cn/problem/partition-list/description
 * @since  2019-07-11 18:30:11
 */
public class L_0096_Partition_List {
    /**
     * 新建两个结点，分别指向大于等于x和小于x的结点，然后合并即可。
     * 链表的合并是无消耗的，因此效果和用一个链表，插入元素是一样的。
     */
    static class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode pileLow = new ListNode(Integer.MIN_VALUE);
            ListNode pileBig = new ListNode(x);
            ListNode tailLow = pileLow, tailBig = pileBig;

            for (ListNode n = head; n != null; n = n.next) {
                if (n.val >= x) {
                    tailBig.next = n;
                    tailBig = tailBig.next;
                } else {
                    tailLow.next = n;
                    tailLow = tailLow.next;
                }
            }
            tailLow.next = pileBig.next;
            tailBig.next = null; // 防止环路
            return pileLow.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = ListNode.randomList(10000000, 100);
        int x = 3;
        Timer.CLICK();
        new Solution().partition(head, x);
        Timer.STOP();
    }
}
