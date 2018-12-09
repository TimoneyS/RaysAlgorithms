package com.ray.LintCode.resolved;

import java.util.HashMap;

/**
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 * 
 * 一个链表，每个结点都有一个额外的随机指针，指向链表中的其他结点或空。
 * 深拷贝这个链表
 *
 * @author rays1
 *
 */
public class L_0105_Copy_List_with_Random_Pointer {
    
    /**
     * 拷贝是建立一个 旧结点到新结点的映射，对于没有遍历到的结点，也可能被随机访问了，因此避免重复创建。
     * @author rays1
     *
     */
    static class Solution {
        
        /**
         * @param head: The head of linked list with a random pointer.
         * @return: A new head of a deep copy of the list.
         */
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
        
    }
    
}
