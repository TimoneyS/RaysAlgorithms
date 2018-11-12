package com.rays.algo.search;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import com.ray.io.Out;

/**
 * 拉链法实现的散列表
 * @author rays1
 *
 * @param <Key>
 * @param <Value>
 */
public class ChainingHashST<Key, Value> implements SymbolTable<Key, Value> {

    private int M;      // 桶的大小
    private int size;   // 尺寸
    
    Node[] st;
    
    class Node {
        Key key;
        Value value;
        Node next;
        public Node(Key k, Value val) {
            this.key = k;
            this.value = val;
        }
    }
    
    @SuppressWarnings("unchecked")
    public ChainingHashST(int M) {
        this.M = M;
//        st = (Node[])new Object[M];
        
        st = (ChainingHashST<Key, Value>.Node[]) Array.newInstance(Node.class, M);
    }
    
    @Override
    public Value get(Key key) {
        int index = getIndex(key);
        
        Node n = st[index];
        if (n == null) return null;
        
        while (n != null) {
            if (n.key.equals(key))
                return n.value;
            else
                n = n.next;
        }
        return null;
    }

    @Override
    public void put(Key key, Value value) {
        int index = getIndex(key);
        Node n = st[index];
        if (n == null) {
            st[index] = new Node(key, value);
            size ++;
        } else {
            while(n.next != null) {
                if (n.key.equals(key)) {
                    n.value = value;
                    return;
                }
                n = n.next;
            }
            n.next = new Node(key, value);
            size ++;
        }
    }

    @Override
    public void delete(Key key) {
        Node n = st[getIndex(key)];
        if (n == null) return;
        
        while (n != null) {
            if (n.next != null && n.next.key.equals(key)) {
                n.next = n.next.next;
                size --;
                return;
            }
            n = n.next;
        }
        
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Key key) {
        return get(key) == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<Key> keys() {
        List<Key> keys = new ArrayList<>();
        for (Node n : st) {
            while (n!=null) {
                keys.add(n.key);
                n = n.next;
            }
        }
        return keys;
    }
    
    public void show() {
        
        Out.p("st.size = " + size);
        int w = String.valueOf(M).length();
        int index = 0;
        for (Node n : st) {
            Out.pf("%"+w+"s ", index++);
            while (n != null) {
                Out.pt(" -> " + n.key);
                n = n.next;
            }
            Out.p();
        }
    }
    
    private int getIndex(Key key) {
        return key.hashCode() % M;
    }

}
 