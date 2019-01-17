package com.ray.LintCode.resolved;

import com.ray.LintCode.help.ListNode;

/**
 * 继承方法删除单链表中的结点
 *
 * @author rays1
 *
 */
public class L_0372_Delete_Node_in_a_Linked_List {

    /**
     * 用下个结点的值，覆盖当前结点，然后删除下个结点
     * @author rays1
     *
     */
    static class Solution {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

}
