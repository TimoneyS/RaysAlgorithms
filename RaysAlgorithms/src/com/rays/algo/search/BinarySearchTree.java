package com.rays.algo.search;

import static com.ray.common.io.Out.*;

import java.util.LinkedList;
import java.util.List;

import com.ray.common.io.Out;

/**
 * ���������
 * @author rays1
 *
 * @param <Key>
 * @param <Value>
 */
public class BinarySearchTree<Key extends Comparable<Key>,Value> implements SortedSymbolTable<Key, Value> {
	
	private Node root;
	
	private final class Node {
        Node  left;                             // ����
        Node  right;                            // �ҽ��
        Key   key;                              // ��
        Value value;                            // ֵ
        int   size;                             // �Ըý��Ϊ���������ܽ�����
		public Node(Key key, Value value) {
			this.key = key;
			this.value = value;
			this.size = 1;
		}
	}
	
	@Override
	public void put(Key key, Value value) {
	    root = put(root, key, value);
	}
	
	/**
	 * �ڸ����Ϊn�����в����½��
	 * @param n
	 * @param key
	 * @param value
	 * @return
	 */
	private Node put(Node n, Key key, Value value) {
	    if (n == null) return new Node(key, value);
	    int c =  n.key.compareTo(key);
        if (c == 0)                                     // �Ѿ����ڼ�
            n.value = value;
        else if ( c > 0)                                // �����ڼ�������������
            n.left = put(n.left, key, value);
        else                                            // ��С�ڼ�������������
            n.right = put(n.right, key, value);
        n.size = size(n.left) + size(n.right) + 1;
        return n;
	}

	@Override
	public Value get(Key key) {
	    return get(root, key).value;
	}
	
	/**
	 * ��nodeΪ�������в���key
	 * @param node
	 * @param key
	 * @return
	 */
	private Node get(Node node, Key key) {
	    if (node == null) return null;
	    int c = node.key.compareTo(key);
        if (c == 0)                         // ����
            return node;
        else if ( c > 0)                    // �����ڼ�����Ҫ���������в���
            return get(node.left, key);
        else                                // ��С�ڼ�����Ҫ���������в���
            return get(node.right, key);
	}
	
    @Override
    public void delete(Key key) {
        root = delete(key, root);
    }
    
    /**
     * ��nodeΪ����������ɾ��key
     * @param key
     * @param n
     */
    private Node delete(Key key, Node node) {
        int c = key.compareTo(node.key);
        if (c == 0) {                                   // ���и���㣬ɾ�����ڵ�
            if (node.left  == null) return node.right;  // �����������Ϊ�գ���������滻Ϊ���ҽ��
            if (node.right == null) return node.left;   // �����������Ϊ�գ���������滻Ϊ������
            Node t = node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left  = t.left;
        } else if ( c > 0) {                            // ����������
            node.right = delete(key, node.right);
        } else {                                        // ����������
            node.left = delete(key, node.left);
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Key key) {
        return get(key) == null;
    }

    @Override
    public int size() {
        return size(root);
    }
    
    private int size(Node n) {
        if (n == null) return 0;
        return n.size;
    }

    @Override
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    @Override
    public Key min() {
        return min(root).key;
    }
    
    /**
     * ����nodeΪ���������в�����С���
     * @param node
     * @return
     */
    private Node min(Node node) {
        if (node.left == null) return node;
        else return min(node.left);
    }

    @Override
    public Key max() {
        return max(root).key;
    }

    private Node max(Node node) {
        if (node.right == null) return node;
        else return max(node.right);
    }
    
    @Override
    public void deleteMin() {
        root = deleteMin(root);
    }
    
    /**
     * ɾ��ĳ������µ���С���
     * @param node
     */
    private Node deleteMin(Node node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public void deleteMax() {
        Node n = root;
        Node bak_root = n.left;
        while(n.right != null) {            // ѭ���ҵ����Ľ�� n
            bak_root = n;
            n.size = n.size - 1;
            n = n.right;
        }
        if (n == root) root = bak_root;     // ɾ������㣨��ʱ������Ȼ���������� - �����ҽ������Ϊ�µĸ����
        else bak_root.right = n.left;       // ɾ������� n - ��n�ĸ��ڵ���ҽ�㣬����Ϊn������
    }

    @Override
    public Key floor(Key key) {
        return floor(key, root);
    }
    
    private Key floor(Key key, Node node) {
        if (node == null) return null;
        int c = key.compareTo(node.key);
        if (c == 0 ) {                                  // ���и����
            return node.key;
        } else if (c > 0) {                             // ��������Ŀ����
            Key rs = floor(key, node.right);            // ���������в���
            if (rs == null)                             // ���������޷��ϵĽ���򷵻ظ����
                return node.key;
            else                                        // ���򷵻��������еĽ��
                return rs;
        } else {
            return floor(key, node.left);
        }
    }

    @Override
    public Key ceiling(Key key) {
        return ceiling(key, root);
    }
    
    private Key ceiling(Key key, Node node) {
        if (node == null) return null;
        int c = key.compareTo(node.key);
        if(c == 0) {
            return node.key;
        } else if (c > 0){
            return ceiling(key, node.right);
        } else {
            Key rs = ceiling(key, node.left);
            if (rs == null)
                return node.key;
            else
                return rs;
        }
        
    }

    @Override
    public int rank(Key key) {
        return rank(key, root);
    }
    
    public int rank(Key key, Node node) {
        if(node == null) return 0;
        int c = key.compareTo(node.key);
        if (c == 0) {
            return size(node.left);
        } else if (c > 0) {
            int rs = rank(key, node.right);
            return rs + size(node.left) + 1;
        } else {
            return rank(key, node.left);
        }
    }

    @Override 
    public Key select(int k) {
        return null;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        List<Key> list = new LinkedList<>();
        keys(root, list, lo, hi);
        return list;
    }
    
    public void keys(Node node, List<Key> list, Key lo, Key hi) {
        if (node == null) return;
        
        int cl = node.key.compareTo(lo);
        int ch = node.key.compareTo(hi);
        
        if (cl > 0) keys(node.left, list, lo, hi);
        if (ch < 0) keys(node.right, list, lo, hi);
        if (cl >= 0 && ch <= 0) list.add(node.key);
    }
    
    public void show() {
        p("== tree ===========================");
        if (root != null) tree(root, 1);
    	p("===================================");
    }

    public void tree(Node node, int deepth) {
        if (node.right != null) tree(node.right, deepth+1);
        Out.pf("%"+(deepth*10)+"s", " ");
        Out.pf("[%2s,size:%2s]\n", node.key, node.size);
        if (node.left  != null) tree(node.left, deepth+1);
    }

    public static void main(String[] args) {
        //Integer[] arr = ArrayUtil.intArr(size);
        Integer[] arr = new Integer[] {8, 4, 10, 2, 6, 9, 11, 1, 3, 5, 7};
        BinarySearchTree<Integer, Integer> st = new BinarySearchTree<>();
        for (Integer i : arr) st.put(i,i);
        st.show();

        
        int l = 0;
        int h = 9;
        Out.pf("keys %s - %s :", l, h);
        for (Integer i : st.keys(l, h)) {
            Out.pf("%s ", i);
        }
        Out.p();
        
//        for (Integer i : arr) {
//            Out.pf("rank %s : %s\n", i, st.rank(i));
//        }
        
    }

}
