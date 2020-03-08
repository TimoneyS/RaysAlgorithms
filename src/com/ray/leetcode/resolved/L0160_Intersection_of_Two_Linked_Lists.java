package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.ListNode;

/**
 * Intersection of Two Linked Lists
 * -----------------------------------------------------------------------------
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * For example, the following two linked lists:
 * begin to intersect at node c1.
 *
 * Example:
 *      Example 1
 *      Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 *      Output: Reference of the node with value = 8
 *      Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 *      Example 2
 *      Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 *      Output: Reference of the node with value = 2
 *      Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 *      Example 3
 *      Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 *      Output: null
 *      Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
 *      Explanation: The two lists do not intersect, so return null.
 *      Notes:
 *      	If the two linked lists have no intersection at all, return null.
 *      	The linked lists must retain their original structure after the function returns.
 *      	You may assume there are no cycles anywhere in the entire linked structure.
 *      	Your code should preferably run in O(n) time and use only O(1) memory.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * @since   2020-03-07 21:35:18
 */
public class L0160_Intersection_of_Two_Linked_Lists {
    /**
     * 先统计两个链表长度
     * 然后长的链表先从前侧截取，然后齐头并进寻找 n1 == n2
     */
    public static class Solution {
        public ListNode getIntersectionNode(ListNode A, ListNode B) {
            int m = 0, n = 0;
            for (ListNode n1 = A; n1 != null; n1 = n1.next) {
                m ++;
            }
            for (ListNode n1 = B; n1 != null; n1 = n1.next) {
                n ++;
            }
            if (m < n) {
                return isIntersect(A, B, m, n);
            } else {
                return isIntersect(B, A, n, m);
            }
        }

        ListNode isIntersect(ListNode A, ListNode B, int m, int n) {
            for (int i = m; i < n; i++)  B = B.next;
            while (A != null && B != null) {
                if (A.val == B.val) {
                    return A;
                }
                A = A.next;
                B = B.next;
            }
            return null;
        }
    }
    
    public static void main(String[] args) {
        ListNode l1 = ListNode.parse("{4,5,8,9}");
        ListNode l2 = ListNode.parse("{1,2,3,8,9}");
        Out.p(new Solution().getIntersectionNode(l1, l2));
    }
}
