package com.ray.LintCode.done;

import com.ray.LintCode.util.ListNode;
import com.ray.io.Out;

/**
 * 描述：
 *      Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:
 *      1->2->3->4->null
 *      3
 *      Output:
 *      1->2->4->null
 *      ```
 *      **Example 2:**
 *      ```
 *      Input:
 *      1->3->5->null
 *      3
 *      Output:
 *      1->5->null
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/delete-node-in-a-linked-list/description
 * @date   2019-07-11 18:32:16
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
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
