package com.rays.search;

import static com.rays.utils.StdOut.*;

@SuppressWarnings("unchecked")
public class BinarySearchTree<Key extends Comparable<Key>,Value> implements SymbolTable<Key, Value> {
	
	Node root;
	int maxDeep = 1;
	
	private class Node {
		Node left;
		Node right;
		Key key;
		Value value;
		int num;
		public Node(Key key, Value value) {
			this.key = key;
			this.value = value;
			this.num = 1;
		}
	}

	public void put(Key key, Value value) {
		Node newNode = new Node(key, value);
		if(root == null) { root = newNode; return; }
		
		Node n = root;
		while(true) {
			if(n.key.equals(key)) n.value = value;
			
			else if (key.compareTo(n.key) > 0) { 
				n.num = n.num+1;
				if(n.right == null) { n.right = newNode; return;}
				else { n = n.right;}
			} else {
				n.num = n.num+1;
				if(n.left == null) { n.left = newNode; return; }
				else n = n.left;
			}
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
	
	public void show() {
		int count = root.num;
		Key[][] keys = (Key[][]) new Comparable[count][count];
		
		tree( root, keys, 0, (root.left == null ? 0 : root.left.num));
		for(Key[] row : keys) {
			for(Key k : row) {
				if(k == null)
					pt("    ");
				else
					pf("%4s", k);
			}
			p("");
		}
		p("===================================");
	}
	
	public void tree(Node n, Key[][] keys,int deep,  int seq) {
		keys[deep][seq] = n.key;
		
		if(n.left  != null) {
			tree( n.left, keys, deep+1, seq - (n.left.right == null ? 1 : n.left.right.num+1));
		}
		if(n.right != null) {
			tree(n.right, keys, deep+1, seq + (n.right.left == null ? 1 : n.right.left.num+1));
		}
	}

}
