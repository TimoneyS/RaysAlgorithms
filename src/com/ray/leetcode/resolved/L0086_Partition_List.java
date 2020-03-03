package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.ListNode;

/**
 * Partition List
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 *      Example 1
 *      Input: head = 1->4->3->2->5->2, x = 3
 *      Output: 1->2->2->4->3->5
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/partition-list/
 * @since   2020-03-01 23:32:29
 */
public class L0086_Partition_List {
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
        Out.p(new Solution());
    }
}
