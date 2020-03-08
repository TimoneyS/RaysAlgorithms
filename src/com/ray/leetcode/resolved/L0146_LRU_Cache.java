package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * LRU Cache
 * -----------------------------------------------------------------------------
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * The cache is initialized with a positive capacity.
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *      Example 1
 *      LRUCache cache = new LRUCache( 2 capacity);
 *      cache.put(1, 1);
 *      cache.put(2, 2);
 *      cache.get(1);       // returns 1
 *      cache.put(3, 3);    // evicts key 2
 *      cache.get(2);       // returns -1 (not found)
 *      cache.put(4, 4);    // evicts key 1
 *      cache.get(1);       // returns -1 (not found)
 *      cache.get(3);       // returns 3
 *      cache.get(4);       // returns 4
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/lru-cache/
 * @since   2020-03-07 21:03:28
 */
public class L0146_LRU_Cache {
    static class LRUCache {

        private int capacity;
        private int size;
        private Node head;
        private Node tail;

        class Node {
            int key;
            int val;
            Node next;
            Node prev;
            public Node() {
                key = -1;val = -1;
            }
        }

        void link(Node p, Node n) {
            if (p == n) return;
            if (p != null) p.next = n;
            if (n != null) n.prev = p;
        }

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            head = new Node();
            tail = new Node();

            link(head, tail);
        }

        public int get(int key) {
            for (Node n = head.next; n != tail; n = n.next) {
                if (n.key == key) {
                    link(n.prev, n.next);
                    link(n, head.next);
                    link(head, n);
                    return n.val;
                }
            }
            return -1;
        }

        public void put(int key, int value) {
            Node prev = head;
            for (Node n = head.next; n != tail; prev = n, n = n.next) {
                if (n.key == key) break;
            }
            if (prev.next == tail) {
                // add
                if (size >= capacity)
                    link(tail.prev.prev, tail);
                else {
                    size ++;
                }
                Node n = new Node();
                n.key = key;
                n.val = value;
                link(n, head.next);
                link(head, n);
            } else {
                // change
                prev.next.val = value;
                Node n = prev.next;
                link(prev, prev.next.next);
                link(n, head.next);
                link(head, n);
            }
        }
    }
    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */

    public static void main(String[] args) {
    }
}
