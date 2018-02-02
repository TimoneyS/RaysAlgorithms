package com.rays.algo.search;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>����ʵ�ֵķ��ű������㷨Ϊ˳�����</b>
 * @author Ray
 *
 */
public class SequentialSearchST <Key extends Comparable<Key>,Value> implements SymbolTable<Key, Value> {
	
    private Node head;
    private int size;
	
    /**
     * �ڲ��ڵ���
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
                return n.value;             // �����ڣ�����ֵ
            }
        }
        return null;                        // �����ڣ����ؿ�
    }

    @Override
    public void put(Key key, Value value) {
        for (Node n = head; n != null; n = n.next) {
            if (n.key.equals(key)) {
                n.value = value;
                return;                     // ���Ѿ����ڣ�ֻ���²����� 
            }
        }
        size ++;
        head = new Node(head, key, value);  // �µļ�ֵ�ԣ����������һλ
    }

    @Override
    public void delete(Key key) {
        for (Node n = head; n != null && n.next != null; n = n.next) {
            if (n.next.key.equals(key)) {
                n.next = n.next.next;      // ɾ��n����һ���ڵ㣬����һ���ڵ�ָ���ڽӽڵ���ڽӽڵ�
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
