package com.rays.algo.search;

import static com.ray.util.io.Out.p;

import com.ray.util.ArrayUtil;
import com.ray.util.Timer;
import com.ray.util.io.Out;

/**
 * ���ں����ʵ�ֵ� 2-3���ṹ�ķ��ű�<br/>
 * �������һ��ƽ������������Ҫ������������ - �����Ӻͺ����ӡ������������С�ڽ�㣬�����������ڽ�㡣<br/>
 * ��������Ϊ�˱�֤��ƽ���һ���ֶΣ�ʵ��ʵ������2-3����3����һ�ֱ��Ρ�<br/>
 * ���������:<br/>
 *  1.�����Ӿ�Ϊ������<br/>
 *  2.��㲻��ͬʱ��������������<br/>
 *  3.��������ƽ��ģ�����������ӵ�������·���ϵĺ�����������ͬ<br/>
 * @author Ray
 *
 * @param <Key>
 * @param <Value>
 */
public class RedBlackBinarySearchTree<Key extends Comparable<Key>, Value> implements SortedSymbolTable<Key, Value> {
	
    private static final boolean BLACK = true;
    private static final boolean RED   = false;
    
    Node root;
    
    /**
     * ��������
     * @author rays1
     *
     */
    private class Node {
        boolean color;      // �ڵ���ɫ
        Node right;         // �ҽ��
        Node left;          // ����
        int  N;             // �ӽ������
        Key key;
        Value value;
        public Node(Key k, Value v, boolean c) {
            key = k;
            value = v;
            color = c;
        }
    }
    
    @Override
    public Value get(Key key) {
        return get(root, key).value;
    }
    

    private Node get(Node node, Key key) {
        if (node == null) return null;
        int cmp = node.key.compareTo(key);
        if (cmp == 0)                         // ����
            return node;
        else if ( cmp > 0)                    // �����ڼ�����Ҫ���������в���
            return get(node.left, key);
        else                                  // ��С�ڼ�����Ҫ���������в���
            return get(node.right, key);
    }

    @Override
    public void put(Key key, Value value) {
        root = put(key, value, root);
        root.color = BLACK;
    }
    
    /**
     * ����ڵ�Ϊnode�����������½��,����ֵΪ�������¸����<br/>
     * </p>
     * @param key
     * @param value
     * @param node
     */
    private Node put(Key key, Value value, Node node) {
        if (node == null) return new Node(key, value, RED);
        
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.value = value;                         // ���н��
        } else if (cmp > 0) {
            node.right = put(key, value, node.right);   // ����������
        } else {
            node.left  = put(key, value, node.left);    // ����������
        }
        
        if (!isRed(node.left) && isRed(node.right))      node = rotateLeft(node);   // �Ƿ���Ҫ����ת
        if ( isRed(node.left) && isRed(node.left.left))  node = rotateRight(node);  // �Ƿ���Ҫ����ת
        if ( isRed(node.left) && isRed(node.right))      flipColors(node);          // �Ƿ���Ҫ��ת��ɫ
        
        node.N = 1 + size(node.left) + size(node.right);
        return node;
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
    public Key min() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Key max() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteMin() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteMax() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Key floor(Key key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Key ceiling(Key key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int rank(Key key) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Key select(int k) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterable<Key> keys() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * ����ת<br/>
     * 
     *      h                      x
     *    /   \\                //   \
     *   n     x      ===>      h     r  
     *       /   \            /   \
     *      l     r          n     l
     *      
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
     * ����ת<br/>
     * 
     *         h                            x         
     *      //   \     routeRight(h)     //   \\      
     *      x     n    ==============>   l     h      
     *   //   \                              /   \    
     *   l     r                            r     n   
     *  
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
    
    /**
     * ��ת��ɫ�������Ӻ����ӱ�Ϊ�����ӣ�Ȼ���м丸���ӱ�Ϊ������
     * 
     *       /                  //
     *      n                   n
     *   //   \\      ===>    /   \
     *   l     r             l     r
     * 
     * @param n
     */
    private void flipColors(Node n) {
        n.color = RED;
        n.left.color = BLACK;
        n.right.color = BLACK;
    }
    
    private int size(Node n) {
        if(n == null) return 0;
        return n.N;
    }

    /**
     * �����������жϽ���Ƿ��Ǻ�����
     * @param x
     * @return
     */
    private boolean isRed(Node x) {
        if(x == null) return false;
        return x.color == RED;
    }

    public void show() {
        p("== tree ===========================");
        if (root != null) tree(root, 1, 0);
        p("===================================");
    }

    private void tree(Node node, int deepth, int c) {
        if (node == null)
            return;
        tree(node.right, deepth + 1, 1);
        Out.pf("%" + (deepth * 10) + "s", " ");
        String oper = "";
        
        if (isRed(node)) {
            if (c == 0) oper = "==";
            else if (c > -0) oper = "//";
            else oper = "\\\\";
        } else {
            if (c == 0) oper = "--";
            else if (c > -0) oper = "/";
            else oper = "\\";
        }
        Out.pf("%s[%2s,s:%2s]\n", oper, node.key, size(node));
        tree(node.left, deepth + 1, -1);
    }
    
    public static void main(String[] args) {
        
        Timer t = Timer.create();
        int size = 10;
        
        Integer[] arr = ArrayUtil.intArr(size);
        ArrayUtil.shuffle(arr);
        
        RedBlackBinarySearchTree<Integer, Integer> st = new RedBlackBinarySearchTree<>();
        
        t.click();
        for (Integer i : arr) {
            Out.pf("put(%s)\n", i);
            st.put(i, i);
            st.show();
        }
       
        t.click();
        for (Integer i : arr) {
            Integer temp = st.get(i);
            Out.pf("get(%s) = %s\n", i, temp);
        }
        t.click();
        
        t.show();
        
    }
	
}
