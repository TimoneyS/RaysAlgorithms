package com.rays.algo.search;

import java.util.NoSuchElementException;

import com.ray.io.Out;
import com.ray.util.ArrayUtil;

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
            N = 1;
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
        
        if (cmp == 0)       node.value = value;                         // ���н��
        else if (cmp > 0)   node.right = put(key, value, node.right);   // ����������
        else                node.left  = put(key, value, node.left);    // ����������
        
        if (!isRed(node.left) && isRed(node.right))      node = rotateLeft(node);   // �Ƿ���Ҫ����ת
        if ( isRed(node.left) && isRed(node.left.left))  node = rotateRight(node);  // �Ƿ���Ҫ����ת
        if ( isRed(node.left) && isRed(node.right))      flipColors(node);          // �Ƿ���Ҫ��ת��ɫ
        
        node.N = 1 + size(node.left) + size(node.right);
        
        return node;
    }

    @Override
    public void delete(Key key) { 
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        if (!contains(key)) return;

        // if both children of root are black, set root to red
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;

        root = delete(root, key);
        if (!isEmpty()) root.color = BLACK;
        // assert check();
    }
    
//    /**
//     * �����ɾ���ķ���
//     * @param h
//     * @param key
//     * @return
//     */
//    private Node delete(Node h, Key key) {
//        if (key.compareTo(h.key) > 0) {
//            if (isRed(h.left)) h = rotateRight(h);
//            if (!isRed(h.right) && !isRed(h.right.left)) h = moveRedRight(h);
//            h.right = delete(h.right, key);
//        } else {
//            if (h.left == null) return null;
//            if (!isRed(h.left) && !isRed(h.left.left))
//                h = moveRedLeft(h);
//            if (key.compareTo(h.key) == 0) {
//                Node x = max(h.left);
//                h.value = x.value;
//                h.key = x.key;
//                h.left = deleteMax(h.left);
//            } else
//                h.left = delete(h.left, key);
//        }
//        return balance(h);
//    }

    
    /**
     * ���Ҳ�ɾ���ķ���
     * @param h
     * @param key
     * @return
     */
    private Node delete(Node h, Key key) { 
        if (key.compareTo(h.key) < 0) {
            if (!isRed(h.left) && !isRed(h.left.left))   h = moveRedLeft(h);
            h.left = delete(h.left, key);
        } else {
            if (isRed(h.left)) {
                h = rotateRight(h);
            } else {
                if (h.right == null) return null;
                if (!isRed(h.right) && !isRed(h.right.left))
                    h = moveRedRight(h);
            }
            // ɾ����ǰ������������ɾ��
            if (key.compareTo(h.key) == 0) {
                Node x = min(h.right);
                h.key = x.key;
                h.value = x.value;
                h.right = deleteMin(h.right);
            } else
                h.right = delete(h.right, key);
        }
        return balance(h);
    }
    
    /**
     * ��ȡ��С���
     * @param right
     * @return
     */
    private Node min(Node node) {
        if (node.left != null) node = node.left;
        return node;
    }
    
    /**
     * ��ȡ�����
     * @param h
     * @return
     */
    public Node max(Node node) {
        if (node.right != null) node = node.right;
        return node;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
        return min(root).key;
    }

    @Override
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("calls max() with empty symbol table");
        return max(root).key;
    }

    @Override
    public void deleteMin() {
        if (!isRed(root.left) && !isRed(root.right))    // �����Ϊ2-��������ú�ɫ��Ŀ����Ϊ���ø����������������µ��߼�һ��
           root.color = RED;
        root = deleteMin(root);
        if (!isEmpty()) root.color = BLACK;
    }
 
    private Node deleteMin(Node h) {
        if (h.left == null) return null;    // ��ǰ��㼴Ϊ��С���
        
        // ���϶��µı任�����ӽڵ�Ϊ 2-��㣬��ȷ������Ϊ��2-���
        if (!isRed(h.left) && !isRed(h.left.left)) {
            // ȷ�ϵ�ǰ���Ϊ2-����ǰ��������Ϊ2-������ֱ�����µݹ鼴��
            h = moveRedLeft(h);
        }
        
        h.left = deleteMin(h.left);
        
        return balance(h);
    }

    @Override
    public void deleteMax() {
        // �����Ϊ2-��������ú�ɫ�����������ʵ���Բ���Ҫ!isRed(root.right)
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;
        root = deleteMax(root);
        if (!isEmpty()) root.color = BLACK;
    }
    
    /**
     * ɾ�������ĸ�������
     * @param h
     * @return
     */
    private Node deleteMax(Node h) {
        
        // ��ǰ���Ϊ3-��㣬ֱ������תȻ�����µݹ鼴��
        if (isRed(h.left)) h = rotateRight(h);
        
        if (h.right == null) return null;
        
        // ��Ϊ��һ����rotateRight�������ж�h�Ƿ�Ϊ2-����������Ϊ!isRed(h.right)
        // ��ǰ��2-���ҽ��Ϊ2-����Ҫ����
        if (!isRed(h.right) && !isRed(h.right.left))   
            h = moveRedRight(h);
        
        h.right = deleteMax(h.right);
        
        return balance(h);
    }

    @Override
    public Key floor(Key key) {
        // С�ڵ���key������
        Node n = floor(root, key);
        return (n == null) ? null : n.key;
    }
    
    /**
     * С�ڵ��� key�������
     * @param node
     * @param key
     * @return
     */
    public Node floor(Node node, Key key) {
        if (node == null) return null;
        
        int cmp =  key.compareTo(node.key);
        if (cmp < 0) {
            return floor(node.left, key);  
        } else if (cmp > 0) {
            Node n = floor(node.right, key);
            if (n == null) n = node;
            return n; 
        } else {
            return node;
        }
    }

    @Override
    public Key ceiling(Key key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int rank(Key key) {
        return rank(key, root);
    }
    
    /**
     * ��ȡrank<br/>
     * key >  node.key  ����size+����������rank<br/>
     * key >= node.key  ����size+����������rank+1<br/>
     * key <  node.key  ����������rank<br/>
     * @param key
     * @param node
     * @return
     */
    private int rank(Key key, Node node) {
        if (node == null) return 0;
        int cmp = key.compareTo(node.key);
        if (cmp >= 0) {
            int rank = rank(key, node.right);
            rank += size(node.left);
            if (cmp > 0) rank += 1;
            return rank;
        } else {
            return rank(key, node.left);
        }
    }

    @Override
    public Key select(int k) {
        Node n = select(root, k);
        return (n==null) ? null : n.key;
    }
    
    /**
     * �ӽ���л�ȡ����Ϊk�Ľ��
     * @param node
     * @param k
     * @return
     */
    private Node select(Node node, int k) {
        if (node == null) return null;
        int rank = rank(node.key);
        if (rank == k) {
            return node;
        } else if (rank > k) {
            return select(node.left, k);
        } else {
            return select(node.right, k);
        }
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
        return size(root);
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
        n.color = !n.color;
        n.left.color = !n.left.color;
        n.right.color = !n.right.color;
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
    
    /**
     * 
     * ��h�������������������ӽ��֮һ��Ϊ������<br/>
     *
     *     //        
     *     h         
     *    / \        
     *   l   r  ==>  l = h = r
     *      /           /
     *     [n]         [n]
     *     
     * *******************************************************************
     * 
     *     //                                                              //    
     *     h                                                               n    
     *    / \                           /                  /              / \    
     *   l   r  ==>  l = h = r  ==> l = h = n    ==>   h = n = r   ==>   h   r    
     *      //              //               \\       //               //    
     *      n               n                 r       l                l    
     *   
     * @param h
     * @return
     */
    private Node moveRedLeft(Node h) {
        // ִ�дη���ʱ�����Ⱦ������ǸĽ�������
        assert isRed(h);
        assert !isRed(h.left);
        assert !isRed(h.left.left);
        flipColors(h);
        if (isRed(h.right.left)) {
            // ������Ϊ��  2-���
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
            flipColors(h);
        }
        return h;
    }
    
    /**
     * ��h�������������������ӽ��֮һ��Ϊ������<br/>
     * 
     *      //             /  
     *      h             h   
     *     / \          // \\ 
     *    l   r  ==>    l   r 
     *   /             /      
     * [n]           [n]      
     * 
     * *******************************************************************
     * 
     *      //             /           /            //
     *      h             h           l             l
     *     / \          // \\       // \\          / \
     *    l   r  ==>    l   r  ==>  n   h    ==>  n   h
     *  //            //                 \\            \\
     *  n             n                   r             r
     *
     * @param h
     * @return
     */
    private Node moveRedRight(Node h) {
        flipColors(h);
        
        // ����Ϊ��2-����Ҫ�ƶ�һ����㵽�ҽ��
        if (isRed(h.left.left)) {
            h = rotateRight(h);
            flipColors(h);        
        }
        return h;
    }
    
    /**
     * ƽ����<br/>
     * ������ɫ�������ӡ������ĺ�ɫ�����Ӻ�4-���
     * @param h
     * @return
     */
    private Node balance(Node h) {

        if (isRed(h.right))                      h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right))     flipColors(h);

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }
    
    /**
     * ��ӡ��
     */
    public void show() {
        Out.p("============= tree =============");
        show(root);
    }
    
    /**
     * ��ӡ���
     */
    public void show(Node node) {
        int l = height()*2;
        int w = size(node)*2;
        String[][] nodes = new String[l][w];
        tree(node, 1, 0, 0, nodes);
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < w; j++)
                Out.pt(nodes[i][j] == null ? " " : nodes[i][j]);
            Out.p();
        }
    }
    
    /**
     * ��ȡ���߶�
     * @return
     */
    private int height() {
        return height(root, 0);
    }
    
    private int height(Node node, int height) {
        if (node == null) return height;
        height++;
        int h1 = height(node.left, height);
        int h2 = height(node.right, height);
        height = Math.max(h1, h2);
        return height;
    }

    private int tree(Node node, int deepth, int order, int side, String[][] nodes) {
        if (node == null) return order;
        order = tree(node.left, deepth+2, order, -1, nodes);
        
        nodes[deepth][order] = node.key.toString();
        
        String arrow = "";
        int    diff = 0;
        if (side == 0) {
            arrow = node.color == RED ? "��" : "|";
            diff = 0;
        } else if (side > 0) {
            arrow = "\\";
            diff = 1;
        } else {
            arrow = "/";
            diff = -1;
        }
        
        if (node.color == RED)
            nodes[deepth-1][order] = arrow;
        nodes[deepth-1][order-diff] = arrow;
       
        order+=2;
        order = tree(node.right, deepth+2, order, 1, nodes);
        return order;
    }
    
    public static void main(String[] args) {
        
        RedBlackBinarySearchTree<Integer, Integer> st = new RedBlackBinarySearchTree<>();
        Integer[] arr;
        
        int size = 9;
        
        arr = ArrayUtil.integerArr(size);
        ArrayUtil.shuffle(arr, 1);
        arr = new Integer[] {1,3,5,7,9}; 
        
        Out.p(arr);
        
        for (Integer i : arr)
            st.put(i, i);
        st.show();
        
        Out.p(st.floor(6));
        
//        st.show();
//        st.delete(4);
//        st.show();
        
//        for (int j : arr) {
//            st =  new RedBlackBinarySearchTree<>();
//            
//            for (Integer i : arr)
//                st.put(i, i);
//            
//            st.show();
//            Out.p("==== delete "+ j + " ====");
//            st.delete(j);
//            
//            st.show();
//        }
//        
        
        
//        for (int i = 0; i < arr.length; i++) {
//            // st.deleteMax();
//            // st.deleteMin();
//            
//            int k = st.root.key;
//            Out.p("\ndelete : " + k);
//            st.delete(k);
//            st.show();
//        }
        
    }
	
}
