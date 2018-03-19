package com.rays.algo.search;

import static com.ray.util.io.Out.p;

import com.ray.util.ArrayUtil;
import com.ray.util.Timer;
import com.ray.util.io.Out;

/**
 * ���ں����ʵ�ֵ� 2-3���ṹ�ķ��ű�<br/>
 * ������Ķ���:<br/>
 * 1.�����Ӿ�Ϊ������<br/>
 * 2.��㲻��ͬʱ��������������<br/>
 * 3.��������ƽ��ģ�����������ӵ�������·���ϵĺ�����������ͬ<br/>
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
        Key     key;
        Value   value;
        Node    left, right;
        int     N;
        boolean color;          // boolean���ͱ�ʾ������ɫ
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
	
	public void put(Key key, Value value) {
		root = put(root, key, value);
		root.color = BLACK;
	}
	
	public Node put(Node node, Key key, Value value) {
		
		if (node == null) return new Node(key, value, 1, RED);	// ����������½ڵ��Ժ����Ӽ�������
		
		int cmp = key.compareTo(node.key);
		
		if      (cmp < 0) node.left  = put( node.left, key, value);
		else if (cmp > 0) node.right = put(node.right, key, value);
		else			  node.value = value;
		
		if (isRed(node.right) && !isRed(node.left)) 	node = rotateLeft(node);
		if (isRed(node.left) && isRed(node.left.left)) 	node = rotateRight(node);
		if (isRed(node.left) && isRed(node.right)) 		flipColors(node);
		
		node.N = 1 + size(node.left) + size(node.right);
		
		return node;
	}
	
	/**
	 * ��ת��ɫ�������Ӻ����ӱ�Ϊ�����ӣ�Ȼ���м丸���ӱ�Ϊ������
	 * @param n
	 */
	public void flipColors(Node n) {
		n.color = RED;
		n.left.color = BLACK;
		n.right.color = BLACK;
	}
	
	/**
	 * ����ת����
	 *     h                           x      <br/>
	 *  n      x        ==>         h     r   <br/>
	 *       l   r                n   l       <br/>
	 * ����������ɫ��������
	 * @param h
	 * @return
	 */
	private Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		
		x.color = h.color;
		h.color = RED;
		
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		
		return x;
	}
	
	/**
	 * ����ת
	 *        h                        x
	 *    x       n        ==>     l       h
	 *  l   r                            r   n
	 * @param h
	 * @return
	 */
	private Node rotateRight(Node h) {
		Node x = h.left;
		
		h.left = x.right;
		x.right = h;
		
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
	
	public void show() {
        p("== tree ===========================");
        if (root != null) tree(root, 1);
        p("===================================");
	}
	
	public void tree(Node node, int deepth) {
        if(node == null) return;
        tree(node.right, deepth+1);
        Out.pf("%"+(deepth*10)+"s", " ");
        Out.pf("%s[%2s,s:%2s]\n", node.color == RED ? "==" : "--", node.key, size(node));
        tree(node.left, deepth+1);
	}

    @Override
    public void delete(Key key) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean contains(Key key) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Iterable<Key> keys() {
        // TODO Auto-generated method stub
        return null;
    }
    
    public static void main(String[] args) {
        
        Timer t = Timer.create();
        int size = 10;
        
        Integer[] arr = ArrayUtil.intArr(size);
        ArrayUtil.shuffle(arr);
        
        RedBlackBinarySearchTree<Integer, Integer> rbst = new RedBlackBinarySearchTree<>();
        
        t.click();
        for (Integer i : arr) {
            rbst.put(i, i);
        }
        rbst.show();
        t.click();
        for (Integer i : arr) {
            rbst.get(i);
        }
        t.click();
        
        t.show();
        
    }
	
}
