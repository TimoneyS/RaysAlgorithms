package com.ray.algo.search;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>链表实现的符号表，查找算法为顺序查找</b>
 * @author Ray
 *
 */
public class SequentialSearchST <Key extends Comparable<Key>,Value> implements SymbolTable<Key, Value> {
	
    private Node head;
    private int size;
	
    /**
     * 内部节点类
     * @author rays1
     *
     */
	private final class Node {
		Node next;
		Key key;
		Value value;
		Node(Node next, Key key, Value value) {
			this.next = next;
			this.key = key;
			this.value = value;
		}
	}

	public SequentialSearchST() {
	    head = null;
	    size = 0;
    }
	    
    @Override
    public Value get(Key key) {
        for (Node n = head; n != null; n = n.next) {
            if (n.key.equals(key)) {
                return n.value;             // 键存在，返回值
            }
        }
        return null;                        // 不存在，返回空
    }

    @Override
    public void put(Key key, Value value) {
        for (Node n = head; n != null; n = n.next) {
            if (n.key.equals(key)) {
                n.value = value;
                return;                     // 键已经存在，只更新并返回 
            }
        }
        size ++;
        head = new Node(head, key, value);  // 新的键值对，插入链表第一位
    }

    @Override
    public void delete(Key key) {
        for (Node n = head; n != null && n.next != null; n = n.next) {
            if (n.next.key.equals(key)) {
                n.next = n.next.next;      // 删除n的下一个节点，将下一个节点指向邻接节点的邻接节点
                size --;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(Key key) {
        return get(key) == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<Key> keys() {
        List<Key> list = new ArrayList<Key>(size);
        for (Node n = head; n != null; n = n.next) {
            list.add(n.key);
        }
        return list;
    }

}
