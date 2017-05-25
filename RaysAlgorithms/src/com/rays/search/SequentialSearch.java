package com.rays.search;

/**
 * <b>����ʵ�ֵķ��ű������㷨Ϊ˳�����</b>
 * @author Ray
 *
 */
public class SequentialSearch <Key extends Comparable<Key>,Value> implements SymbolTable<Key, Value> {
	private Node head;
	
	private class Node {
		public Node next;
		public Key key;
		public Value value;
		public Node(Node next, Key key, Value value) {
			this.next = next;
			this.key = key;
			this.value = value;
		}
	}
	
	public SequentialSearch() {
		head = null;
	}
	
	public void put(Key key, Value value) {
		for(Node n = head; n!= null; n = n.next)
			if(n.key.equals(key)) { n.value = value; return; } 
		head = new Node(head, key, value);
	}

	public Value get(Key key) {
		for(Node n = head; n!= null; n = n.next)
			if(n.key.equals(key)) return n.value;
		return null;
	}

}
