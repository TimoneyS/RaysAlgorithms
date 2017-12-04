package com.ray.graph.weightedGraph;

import java.util.Scanner;

import com.ray.utils.collections.Bag;

/**
 * ��Ȩͼ(�������Ի���ƽ�б�)
 * @author rays1
 *
 */
public class EdgeWeightedGraph {
    
    private final int   V;   // ������
    private int         E;   // ����
    private Bag<Edge>[] adj; // �ڲ��洢���ݽṹ������ÿ������Ŀɴ��
    
    /**
     * ָ����������ʼ��ͼ
     * @param V
     */
    @SuppressWarnings("unchecked")
    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];            // ��ʼ��adj
        for (int v = 0; v < V;  v ++)
            adj[v] = new Bag<Edge>();
    }
    
    /**
     * ����������ʼ��ͼ
     * @param in
     */
    public EdgeWeightedGraph(Scanner in) {
        this(in.nextInt());
        int e = in.nextInt();
        
        for (int i = 0; i < e; i++) {
            int v = in.nextInt();
            int w = in.nextInt();
            double weighted = in.nextDouble();
            if (v == w || hasEdge(v, w))                          // ����������Ի�
                continue;
            addEdge(new Edge(v, w, weighted));
        }
        
    }
    
    /**
     * ���һ����
     * @param v
     * @param w
     */
    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);        
        E ++;
    }
    
    /**
     * �ж�ĳ�����Ƿ����
     * @param w
     * @param w
     * @return
     */
    public boolean hasEdge(int v, int w) {
        for (Edge e : adj(v)) if (e.other(v)==w) return true;
        return false;
    }
    
    /**
     * �Ͷ��� v ��ͨ�Ķ���
     * @param v
     * @return
     */
    Iterable<Edge> adj(int v) {
        return adj[v];
    }
    
    /**
     * ��ӡͼ
     */
    public String toString() {
        String s = V + " vertices, " + E + " Edges\n";
        for (int v = 0; v < V(); v ++) {
            String temp = v + " ";
            for (Edge e : this.adj(v)) {
                s += temp + e.other(v) + " " + e.getWeighted() + "\n";
            }
        }
        return s;
    }
       
    int V() { return V; }
    int E() { return E; }
    
}
