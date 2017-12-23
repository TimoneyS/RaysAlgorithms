package com.ray.graph.gd;

import java.util.Scanner;

import com.ray.utils.collections.Bag;

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
            addEdge(v, w);
        }
        
    }
    
    /**
     * ���һ����
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        if (v == w || hasEdge(v, w))                          // ����������Ի���ƽ�б�
            return;
        adj[v].add(w);
        E ++;
    }
    
    /**
     * ���ض�����ڽӶ���
     * @param v
     * @return
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
    
    /**
     * ���ظ�ͼ�ķ���ͼ
     * @return
     */
    public Digraph reverse() {
        Digraph R = new Digraph(this.V);
        for (int v = 0; v < V; v ++) {
            for (int w : adj[v])
                R.addEdge(w, v);
        }
        return R;
    }
    
    /**
     * �ж�ĳ�����Ƿ����
     * @param w
     * @param w
     * @return
     */
    public boolean hasEdge(int v, int w) {
        for (int tempW : adj(v)) if (w == tempW) return true;
        return false;
    }
    
    /**
     * �ṩͼ�Ĵ�ӡ
     */
    public String toString() {
        String s = V + " vertices, " + E + " Edges\n";
        for (int v = 0; v < V; v ++) {
            s += v + " : ";
            for (int w : this.adj(v)) s += w + " ";
            s += "\n";
        }
        return s;
    }
    
    public int V() {return V;}
    public int E() {return E;}    
}
