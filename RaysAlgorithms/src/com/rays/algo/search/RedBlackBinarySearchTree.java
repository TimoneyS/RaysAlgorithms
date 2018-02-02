package com.rays.algo.search;

import static com.ray.common.io.Out.p;
import static com.ray.common.io.Out.pf;

/**
 * 红黑树 实现的 2-3 树结构的符号表查找插入算法
 * @author Ray
 *
 * @param <Key>
 * @param <Value>
 */
public class RedBlackBinarySearchTree<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {
	
	private static final boolean RED   = true;
	private static final boolean BLACK = false;
	
	private Node root;
	
	private class Node {
		Key key;
		Value value;
		Node left, right;
		int N;
		boolean color;
		Node(Key k, Value v, int n, boolean c) {
			key 	= k;
			value 	= v;
			N 		= n;
			color 	= c;
		}
	}
	
	public Value get(Key key) {
		Node n = root;
		while ( n != null ) {
			if (n.key.equals(key)) 				return n.value;
			else if ( n.key.compareTo(key) > 0) n = n.left;
			else 								n = n.right;
		}
		return null;
	}
	
	private Node getNode(Key key) {
		Node n = root;
		while ( n != null && key != null) {
			if (n.key.equals(key)) 				return n;
			else if ( n.key.compareTo(key) > 0) n = n.left;
			else 								n = n.right;
		}
		return null;
	}
	
	public void put(Key key, Value value) {
		root = put(root, key, value);
		root.color = BLACK;
	}
	
	public Node put(Node node, Key key, Value value) {
		
		if (node == null) return new Node(key, value, 1, RED);	// 这个决定了新节点以红链接加入树中
		
		int cmp = key.compareTo(node.key);
		
		if      (cmp < 0) node.left  = put( node.left, key, value);
		else if (cmp > 0) node.right = put(node.right, key, value);
		else			  node.value = value;
//		else 			  { node.value = value; return node;}
		
		if (isRed(node.right) && !isRed(node.left)) 	node = rotateLeft(node);
		if (isRed(node.left) && isRed(node.left.left)) 	node = rotateRight(node);
		if (isRed(node.left) && isRed(node.right)) 		flipColors(node);
		
		node.N = 1 + size(node.left) + size(node.right);
		
		return node;
	}
	
	public void flipColors(Node n) {
		// 反转颜色，两个子红链接变为黑链接，然后将中间父连接变为红链接
		n.color = RED;
		n.left.color = BLACK;
		n.right.color = BLACK;
	}
	
	Node rotateLeft(Node h) {
		// 左旋转
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;
	}
	
	Node rotateRight(Node h) {
		// 右旋转
		Node x = h.left;
		
		h.left = x.right;
		x.right = h;
		x.N = h.N;
		
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		
		return x;
	}
	
	private boolean isRed(Node x) {
		if(x == null) return false;
		return x.color == RED;
	}
	
	private int size(Node n) {
		if(n == null) return 0;
		return n.N;
	}
	
	@SuppressWarnings("unchecked")
	public void show() {
		int count = root.N;
		
		Key[][] keys = (Key[][]) new Comparable[count][count];
		
		tree( root, keys, 0, (root.left == null ? 0 : root.left.N));
		for(Key[] row : keys) {
			boolean emptyRow = true;
			for(Key k : row) {
				Node n = getNode(k);
				pf( "%4s",  ( k == null ? " " : k + ( isRed(n) ? "*" : "") ) );
				if(k != null) emptyRow = false;
			}
			p("");
			if(emptyRow) break;
		}
	}
	
	public void tree(Node n, Key[][] keys,int deep,  int seq) {
		keys[deep][seq] = n.key;
		if(n.left  != null) tree(  n.left, keys, deep+1, seq - (n.left.right == null ? 1 : n.left.right.N+1) );
		if(n.right != null) tree( n.right, keys, deep+1, seq + (n.right.left == null ? 1 : n.right.left.N+1) );
	}
	
}
