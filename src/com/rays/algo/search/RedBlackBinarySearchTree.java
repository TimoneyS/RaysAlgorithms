package com.rays.algo.search;

import static com.ray.util.io.Out.p;

import java.util.List;

import com.ray.util.ArrayUtil;
import com.ray.util.RMath;
import com.ray.util.RString;
import com.ray.util.Timer;
import com.ray.util.io.Out;

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
        if (!isRed(root.left) && !isRed(root.right))    // 根结点为2-结点
            root.color = RED;
        root = deleteMin(root);
        if (!isEmpty())
            root.color = BLACK;
    }
    
    /**
     * 删除最小结点的辅助方法
     * @param h
     * @return
     */
    public Node deleteMin(Node h) {
        if (h.left == null) return null;
        // 自上而下的变换，目的是在左侧最终构建一个3-结点或者4-结点
        if (!isRed(h.left) && !isRed(h.left.left))   // 左子节点为 2-结点
            h = moveRedLeft(h);
        h.left = deleteMin(h.left);
        return balance(h);
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
     * 将根结点的右子树里左子数最近的红链接移至右结点处
     * @param h
     * @return
     */
    private Node moveRedLeft(Node h) {
        flipColors(h);
        if (isRed(h.right.left)) {              // 右子树为非  2-结点
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
            flipColors(h);
        }
        return h;
    }
    
    private Node balance(Node h) {
        // assert (h != null);

        if (isRed(h.right))                      h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right))     flipColors(h);

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }
    
    public void show(String msg) {
        show(msg, root);
    }
    
    public void show(String msg, Node node) {
        Out.p("== " + msg + " " + RString.multiString('=', 40-msg.length()-4));
        if (root != null) tree(node, 1, 0);
        Out.p(RString.multiString('=', 40));
    }
    
    public void show() {
        show("tree");
    }
    
    public void show(Node node) {
        show("tree Node" + node.key, node);
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
        
        int size = 10;
        Integer[] arr = ArrayUtil.integerArr(size);
        ArrayUtil.shuffle(arr);
        
        Out.p(arr);
        RedBlackBinarySearchTree<Integer, Integer> st = new RedBlackBinarySearchTree<>();
        for (Integer i : arr) {
            st.put(i, i);
        }
        st.show();
        
        st.deleteMin();
        
        st.show();
        
    }
	
}
