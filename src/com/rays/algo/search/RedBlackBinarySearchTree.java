package com.rays.algo.search;

import java.util.NoSuchElementException;

import com.ray.io.Out;
import com.ray.util.ArrayUtil;

/**
 * 基于红黑树实现的 2-3树结构的符号表<br/>
 * 红黑树是一种平衡树，树中主要包含两种链接 - 红链接和黑链接。结点左子树均小于结点，右子树均大于结点。<br/>
 * 红链接是为了保证树平衡的一种手段，实际实际上是2-3树中3结点的一种变形。<br/>
 * 红黑树特征:<br/>
 *  1.红链接均为左链接<br/>
 *  2.结点不能同时存在两条红链接<br/>
 *  3.树是完美平衡的，即任意空链接到根结点的路径上的黑链接数量相同<br/>
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
     * 红黑树结点
     * @author rays1
     *
     */
    private class Node {
        boolean color;      // 节点颜色
        Node right;         // 右结点
        Node left;          // 左结点
        int  N;             // 子结点数量
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
        if (cmp == 0)                         // 命中
            return node;
        else if ( cmp > 0)                    // 根大于键，需要在左子树中查找
            return get(node.left, key);
        else                                  // 根小于键，需要在右子树中查找
            return get(node.right, key);
    }

    @Override
    public void put(Key key, Value value) {
        root = put(key, value, root);
        root.color = BLACK;
    }
    
    /**
     * 向根节点为node的子树插入新结点,返回值为子树的新根结点<br/>
     * </p>
     * @param key
     * @param value
     * @param node
     */
    private Node put(Key key, Value value, Node node) {
        if (node == null) return new Node(key, value, RED);
        
        int cmp = key.compareTo(node.key);
        
        if (cmp == 0)       node.value = value;                         // 命中结点
        else if (cmp > 0)   node.right = put(key, value, node.right);   // 放入右子树
        else                node.left  = put(key, value, node.left);    // 放入左子树
        
        if (!isRed(node.left) && isRed(node.right))      node = rotateLeft(node);   // 是否需要左旋转
        if ( isRed(node.left) && isRed(node.left.left))  node = rotateRight(node);  // 是否需要右旋转
        if ( isRed(node.left) && isRed(node.right))      flipColors(node);          // 是否需要翻转颜色
        
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
//     * 从左侧删除的方法
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
     * 从右侧删除的方法
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
            // 删除当前结点或右链接中删除
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
     * 获取最小结点
     * @param right
     * @return
     */
    private Node min(Node node) {
        if (node.left != null) node = node.left;
        return node;
    }
    
    /**
     * 获取最大结点
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
        if (!isRed(root.left) && !isRed(root.right))    // 根结点为2-结点则将其置红色，目的是为了让根结点和沿左链接向下的逻辑一致
           root.color = RED;
        root = deleteMin(root);
        if (!isEmpty()) root.color = BLACK;
    }
 
    private Node deleteMin(Node h) {
        if (h.left == null) return null;    // 当前结点即为最小结点
        
        // 自上而下的变换，左子节点为 2-结点，则确保左结点为非2-结点
        if (!isRed(h.left) && !isRed(h.left.left)) {
            // 确认当前结点为2-，当前结点的左结点为2-，否则直接向下递归即可
            h = moveRedLeft(h);
        }
        
        h.left = deleteMin(h.left);
        
        return balance(h);
    }

    @Override
    public void deleteMax() {
        // 根结点为2-结点则将其置红色，红黑树中其实可以不需要!isRed(root.right)
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;
        root = deleteMax(root);
        if (!isEmpty()) root.color = BLACK;
    }
    
    /**
     * 删除最大结点的辅助方法
     * @param h
     * @return
     */
    private Node deleteMax(Node h) {
        
        // 当前结点为3-结点，直接右旋转然后向下递归即可
        if (isRed(h.left)) h = rotateRight(h);
        
        if (h.right == null) return null;
        
        // 因为上一步的rotateRight，所以判断h是否为2-结点的条件变为!isRed(h.right)
        // 当前是2-，右结点为2-，需要处理
        if (!isRed(h.right) && !isRed(h.right.left))   
            h = moveRedRight(h);
        
        h.right = deleteMax(h.right);
        
        return balance(h);
    }

    @Override
    public Key floor(Key key) {
        // 小于等于key的最大键
        Node n = floor(root, key);
        return (n == null) ? null : n.key;
    }
    
    /**
     * 小于等于 key的最大结点
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
     * 获取rank<br/>
     * key >  node.key  左结点size+在右子树的rank<br/>
     * key >= node.key  左结点size+在右子树的rank+1<br/>
     * key <  node.key  在左子树的rank<br/>
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
     * 从结点中获取排名为k的结点
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
     * 左旋转<br/>
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
     * 右旋转<br/>
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
     * 反转颜色，两个子红链接变为黑链接，然后将中间父连接变为红链接
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
     * 辅助方法，判断结点是否是红链接
     * @param x
     * @return
     */
    private boolean isRed(Node x) {
        if(x == null) return false;
        return x.color == RED;
    }
    
    /**
     * 
     * 将h的左子树或左子树的子结点之一变为红链接<br/>
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
        // 执行次方法时，的先决条件是改结点的左结点
        assert isRed(h);
        assert !isRed(h.left);
        assert !isRed(h.left.left);
        flipColors(h);
        if (isRed(h.right.left)) {
            // 右子树为非  2-结点
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
            flipColors(h);
        }
        return h;
    }
    
    /**
     * 将h的右子树或右子树的子结点之一变为红链接<br/>
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
        
        // 左结点为非2-，需要移动一个结点到右结点
        if (isRed(h.left.left)) {
            h = rotateRight(h);
            flipColors(h);        
        }
        return h;
    }
    
    /**
     * 平衡结点<br/>
     * 消除红色的右链接、连续的红色左链接和4-结点
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
     * 打印树
     */
    public void show() {
        Out.p("============= tree =============");
        show(root);
    }
    
    /**
     * 打印结点
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
     * 获取树高度
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
            arrow = node.color == RED ? "∥" : "|";
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
