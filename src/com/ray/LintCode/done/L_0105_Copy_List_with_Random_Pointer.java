package com.ray.LintCode.done;

import java.util.HashMap;

import com.ray.LintCode.util.RandomListNode;
import com.ray.io.Out;

/**
 * 描述：
 *      给出一个链表，每个节点包含一个额外增加的随机指针可以指向链表中的任何节点或空的节点。
 *      返回一个深拷贝的链表。
 * 挑战：
 *      Could you solve it with O(1) space?
 *
 * 难度： Medium
 *   
 * @author rays1
 * @link   https://www.lintcode.cn/problem/copy-list-with-random-pointer/description
 * @since  2019-07-11 18:30:36
 */
public class L_0105_Copy_List_with_Random_Pointer {

    /**
     * 拷贝时建立一个 旧结点到新结点的映射
     * 每次当某个旧结点指向另一个旧结点，我们都能找到旧结点的新结点，
     */
    static class Solution {
        public RandomListNode copyRandomList(RandomListNode head) {
            if (head == null) return null;
            
            HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
            RandomListNode pile = new RandomListNode(0);
            RandomListNode node = pile, newNode;
            
            while (head != null) {
                
                if (map.containsKey(head)) {
                    newNode = map.get(head);
                } else {
                    newNode = new RandomListNode(head.label);
                    map.put(head, newNode);
                }

                if (head.random != null) {
                    if (map.containsKey(head.random)) {
                        newNode.random = map.get(head.random);
                    } else {
                        newNode.random = new RandomListNode(head.random.label);
                        map.put(head.random, newNode.random);
                    }
                }
                
                node.next = newNode;
                node = node.next;
                head = head.next;
            }

            return pile.next;
        }

    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}