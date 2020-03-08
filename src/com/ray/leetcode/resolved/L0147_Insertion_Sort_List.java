package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.ListNode;

/**
 * Insertion Sort List
 * -----------------------------------------------------------------------------
 * Sort a linked list using insertion sort.
 * A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
 * With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
 * Algorithm of Insertion Sort:
 * 	Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * 	At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
 * 	It repeats until no input elements remain.
 *
 * Example:
 *      Example 1
 *      Input: 4->2->1->3
 *      Output: 1->2->3->4
 *      Example 2
 *      Input: -1->5->3->4->0
 *      Output: -1->0->3->4->5
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/insertion-sort-list/
 * @since   2020-03-07 21:07:50
 */
public class L0147_Insertion_Sort_List {
    /**
     * 插入排序将链表分为两部分，已排序和未排序部分
     * 插入排序每次从未排序部分寻找最小的结点，插入已经排序的部分的末尾
     */
    static class Solution {
        public ListNode insertionSortList(ListNode head) {
            ListNode pile = new ListNode(Integer.MIN_VALUE);
            pile.next     = head;
            ListNode lastSorted = pile;
            while (lastSorted.next != null) {
                // 从 lastSorted 之后寻找最小结点的前置结点
                ListNode prev = lastSorted;
                for (ListNode n = lastSorted; n.next != null; n = n.next) {
                    if (n.next.val < prev.next.val) {
                        prev = n;
                    }
                }
                // 将min结点从原位置移除
                ListNode min    = prev.next;
                prev.next       = prev.next.next;
                // min结点插入已经排序的末尾
                min.next        = lastSorted.next;
                lastSorted.next = min;

                lastSorted      = lastSorted.next;
            }
            return pile.next;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
