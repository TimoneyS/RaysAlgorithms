package com.rays.algo.string.search;

import com.ray.io.Out;

public class RaysStringST<Value> implements StringST<Value> {
    
    private static int R = 256;
    
    Node<Value> root = new Node<Value>();
    int size = 0;
    
    public static class Node<Value> {
        
        public Value value;
        @SuppressWarnings("unchecked")
        public Node<Value>[] next = new Node[R];
        
        public static void printNode (Node<?> n, int deepth) {
            if (n.value != null) {
                Out.pt("(" + n.value + ")");
            }
            Out.p();
            
            for (int i = 0; i < n.next.length; i++) {
                if (n.next[i] != null) {
                    Out.pf("%"+(deepth*2)+"s", " ");
                    Out.pt((char)i);
                    printNode(n.next[i], deepth+1);
                }
            }
            
        }
        
    }
    
    @Override
    public void put(String key, Value val) {
        // root = put(root, key, val, 0);
        put(root, key, val);
    }
    
    /**
     * 非递归的添加方式
     * @param key
     * @param val
     * @param dummyTag
     */
    private void put(Node<Value> node, String key, Value val) {
        for (int d = 0; d < key.length(); d++) {
            char c = key.charAt(d);
            
            if ( (d+1) == key.length()) {
                node.value = val;
            }
            
            node.next[c] = put(node.next[c], key, val, d+1 ,0);
            node = node.next[c];
            
        }
        
    }
    
    private Node<Value> put(Node<Value> node, String key, Value val, int d, int dummyTag) {
        if (node == null) node = new Node<Value>();
        if ( (d == key.length()) && node.value == null) {
            node.value = val;
        }
        return node;
    }
    
    
    
    /**
     * 递归的添加的方式
     * @param node
     * @param key
     * @param val
     * @param d
     * @return
     */
    @SuppressWarnings("unused")
    private Node<Value> put(Node<Value> node, String key, Value val, int d) {
        
        if (node == null ) node = new Node<Value>();
        
        if (d == key.length()) {
            if(node.value == null) node.value = val;
        } else {
            char c = key.charAt(d);
            node.next[c] = put(node.next[c], key, val, d+1);
        }
        return node;
    }

    @Override
    public Value get(String key) {
        
        Node<Value> n = root;
        for (char c : key.toCharArray()) {
            if (n != null)
                n = n.next[c];
            else
                break;
        }
        if (n == root) n = null;
        
        return null;
    }

    @Override
    public void delete(String key) {
    }

    @Override
    public boolean contains(String key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public String longestPrefixOf(String s) {
        return null;
    }

    @Override
    public Iterable<String> keysWithPrefix(String s) {
        return null;
    }

    @Override
    public Iterable<String> keysMatch(String s) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterable<String> keys() {
        return null;
    }
    
    public Node<Value> getRoot() {
        return root;
    }

}
