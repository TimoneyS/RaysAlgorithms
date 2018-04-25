package com.rays.algo.graph.gd;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * ����ͼ
 * @author rays1
 *
 */
public class Digraph {
    
    private int V;                  // ������
    private int E;                  // ����
    private List<Integer>[] adj;    // �ڲ��洢���ݽṹ������ÿ��������ڽӶ���
    
    /**
     * ָ����������ʼ��ͼ
     * @param V
     */
    @SuppressWarnings("unchecked")
    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (List<Integer>[]) new LinkedList[V];            // ��ʼ��adj
        for (int v = 0; v < V;  v ++)
            adj[v] = new LinkedList<Integer>();
    }
    
    /**
     * ����������ʼ��ͼ
     * @param in
     */
    public Digraph(Scanner in) {
        while (in.hasNext()) {
            int v = in.nextInt();
            int w = in.nextInt();
            // �ж��Ƿ���Ҫ���������С
            adjustArrayTo(Math.max(v, w) + 1);
            if (v == w || hasEdge(v, w)) // ����������Ի�
                continue;
            addEdge(v, w);
        }
        
        this.V = adj.length;
        
    }
    
    /**
     * ���һ����
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        if (v == w || hasEdge(v, w)) return; // ����������Ի���ƽ�б�
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
        for (int tempW : adj(v))
            if (w == tempW)
                return true;
        return false;
    }
    
    /**
     * �ж��Ƿ���Ҫ���������С
     * @param size
     */
    @SuppressWarnings("unchecked")
    private void adjustArrayTo(int size) {
        if (adj != null && adj.length >= size) return ;
        
        int oldSize = (adj == null) ? 0 : adj.length;
        List<Integer>[] arr = adj;
        adj = (List<Integer>[]) new LinkedList[size];
        for (int v = 0; v < oldSize;  v ++)
            adj[v] = arr[v];
        for (int v = oldSize; v < size;  v ++)
            adj[v] = new LinkedList<Integer>();
            
    }
    
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
