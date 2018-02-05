package com.rays.algo.search;

import static com.ray.common.io.Out.*;

import com.ray.common.io.Out;

/**
 * 二叉查找树
 * @author rays1
 *
 * @param <Key>
 * @param <Value>
 */
public class BinarySearchTree<Key extends Comparable<Key>,Value> implements SortedSymbolTable<Key, Value> {
	
	private Node root;
	
	private final class Node {
        Node  left;                             // 左结点
        Node  right;                            // 右结点
        Key   key;                              // 键
        Value value;                            // 值
        int   size;                             // 以该结点为根的子树总结点个数
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
	 * 在根结点为n的树中插入新结点
	 * @param n
	 * @param key
	 * @param value
	 * @return
	 */
	private Node put(Node n, Key key, Value value) {
	    if (n == null) return new Node(key, value);
	    int c =  n.key.compareTo(key);
        if (c == 0)                                     // 已经存在键
            n.value = value;
        else if ( c > 0)                                // 根大于键，放入左子树
            n.left = put(n.left, key, value);
        else                                            // 根小于键，放入右子树
            n.right = put(n.right, key, value);
        n.size = size(n.left) + size(n.right);
        return n;
	}

	@Override
	public Value get(Key key) {
	    return get(root, key).value;
	}
	
	/**
	 * 在node为根的树中查找key
	 * @param node
	 * @param key
	 * @return
	 */
	private Node get(Node node, Key key) {
	    if (node == null) return null;
	    int c = node.key.compareTo(key);
        if (c == 0)              // 命中
            return node;
        else if ( c > 0)         // 根大于键，需要在左子树中查找
            return get(node.left, key);
        else                     // 根小于键，需要在右子树中查找
            return get(node.right, key);
	}
	
    @Override
    public void delete(Key key) {
        root = delete(key, root);
    }
    
    /**
     * 在node为根的子树中删除key
     * @param key
     * @param n
     */
    private Node delete(Key key, Node node) {
        int c = key.compareTo(node.key);
        if (c == 0) {                                   // 命中根结点，删除根节点
            if (node.left  == null) return node.right;  // 根结点左子数为空，将根结点替换为其右结点
            if (node.right == null) return node.left;   // 根结点右子树为空，将根结点替换为其左结点
            Node t = node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left  = t.left;
        } else if ( c > 0) {                            // 命中右子树
            node.right = delete(key, node.right);
        } else {                                        // 命中左子树
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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Key min() {
        return min(root).key;
    }
    
    /**
     * 在以node为根的子树中查找最小结点
     * @param node
     * @return
     */
    private Node min(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    @Override
    public Key max() {
        Node n = root;
        while (n.right != null) {
            n = n.right;
        }
        return n.key;
    }

    @Override
    public void deleteMin() { deleteMin(root); }
    
    /**
     * 删除某个结点下的最小结点
     * @param node
     */
    private Node deleteMin(Node node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
//        Node bak_root = node.right;
//        while(node.left != null) {              // 循环找到最小的结点
//            bak_root = node;
//            node.size = node.size - 1;
//            node = node.left;
//        }
//        if (node == root)
//            root = bak_root;                    // 删除根结点（此时根结点必然无左子树） - 将其左结点设置为新的根结点
//        else if (bak_root != null)
//            bak_root.left = node.right;         // 删除最小结点n - 将n的父节点的左结点，设置为n的右结点
//        return bak_root;
    }

    @Override
    public void deleteMax() {
        Node n = root;
        Node bak_root = n.left;
        while(n.right != null) {            // 循环找到最大的结点 n
            bak_root = n;
            n.size = n.size - 1;
            n = n.right;
        }
        if (n == root) root = bak_root;     // 删除根结点（此时根结点必然无右子树） - 将其右结点设置为新的根结点
        else bak_root.right = n.left;       // 删除最大结点 n - 将n的父节点的右结点，设置为n的左结点
    }

    @Override
    public Key floor(Key key) {
        // TODO Auto-generated method stub
        return key;
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
    
    public void show() {
        p("== tree ===========================");
        if (root != null) tree(root, 1);
    	p("===================================");
    }

    public void tree(Node node, int deepth) {
        if (node.right != null) tree(node.right, deepth+1);
        Out.pf("%"+(deepth*10)+"s", " ");
        Out.pf("[%2s,s:%2s]\n", node.key, node.size);
        if (node.left  != null) tree(node.left, deepth+1);
    }

    public static void main(String[] args) {
        //Integer[] arr = ArrayUtil.intArr(size);
        Integer[] arr = new Integer[] {8, 4, 10, 2, 6, 9, 11, 1, 3, 5, 7};
        BinarySearchTree<Integer, Integer> st = new BinarySearchTree<>();
        for (Integer i : arr) st.put(i,i);
        st.show();

        for (Integer i : arr) {
            Out.p("delete " + i);
            st.delete(i);
            st.show();
        }
        
        st.show();
    }

}
