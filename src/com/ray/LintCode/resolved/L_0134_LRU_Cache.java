package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present.
 *  When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * 继承 LRU (Least Recently Used) 缓存数据结构.支撑 get set 操作
 *      get(key) - 存在返回 key 否则返回 -1
 *      set(key, value) - 添加或者设置新值，如果达到容量上限，则应该清理使用频率最低得元素再添加。
 * @author rays1
 *
 */
public class L_0134_LRU_Cache {

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

        public void set(int key, int value) {
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
    
    public static void main(String[] args) {
        
        LRUCache cache = new LRUCache(1);
        
        cache.set(2, 1);
        Out.p(cache.get(2));
        cache.set(3, 2);
        Out.p(cache.get(2));
        Out.p(cache.get(3));        
        
    }

}
