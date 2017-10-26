package com.ray.graph;

import java.util.Scanner;

import com.ray.utils.Bag;

/**
 * ����ͼ
 * @author rays1
 *
 */
public class Digraph {
    
    private int V;                  // ������
    private int E;                  // ����
    private Bag<Integer>[] adj;     // �ڲ��洢���ݽṹ������ÿ��������ڽӶ���
    
    /**
     * ָ����������ʼ��ͼ
     * @param V
     */
    @SuppressWarnings("unchecked")
    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];            // ��ʼ��adj
        for (int v = 0; v < V;  v ++)
            adj[v] = new Bag<Integer>();
    }
    
    /**
     * ����������ʼ��ͼ
     * @param in
     */
    public Digraph(Scanner in) {
        this(in.nextInt());
        int e = in.nextInt();
        
        for (int i = 0; i < e; i++) {
            int v = in.nextInt();
            int w = in.nextInt();
            if (v == w || hasEdge(v, w))                          // ����������Ի�
                continue;
            addEdge(v, w);
        }
    }
    
    /**
     * ���һ����
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
        E ++;
    }
    
    /**
     * ���ض�����ڽӶ���
     * @param v
     * @return
     */
    public Iterable<Integer> adj(int v) {
        return null;
    }
    
    /**
     * ���ظ�ͼ�ķ���ͼ
     * @return
     */
    public Digraph reverse() {
        return null;
    }
    
    /**
     * �ж�ĳ�����Ƿ����
     * @param w
     * @param w
     * @return
     */
    public boolean hasEdge(int v, int w) {
        for (int tempV : adj(v)) if (w == tempV) return true;
        return false;
    }
    
    /**
     * �ṩͼ�Ĵ�ӡ
     */
    public String toString() {
        return "";
    }
    
    int V() {return V;}
    int E() {return E;}    
}
