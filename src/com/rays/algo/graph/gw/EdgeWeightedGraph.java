package com.rays.algo.graph.gw;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * ��Ȩ����ͼ(�������Ի���ƽ�б�)
 * @author rays1
 *
 */
public class EdgeWeightedGraph {
    
    private final int   V;   // ������
    private int         E;   // ����
    private List<Edge>[] adj; // �ڲ��洢���ݽṹ������ÿ������Ŀɴ��
    
    /**
     * ����������ʼ��ͼ
     * @param in
     */
    public EdgeWeightedGraph(Scanner in) {
        
        while (in.hasNext()) {
            int v = in.nextInt();
            int w = in.nextInt();
            double weighted = in.nextDouble();
            adjustArrayTo(Math.max(v, w)+1);
            addEdge(new Edge(v, w, weighted));
        }
        
        V = adj.length;
        
    }
    
    /**
     * ���������С
     * @param size
     */
    @SuppressWarnings("unchecked")
    private void adjustArrayTo(int size) {
        if (adj != null && adj.length >= size) return ;
        int oldSize = (adj == null) ? 0 : adj.length;
        List<Edge>[] arr = adj;
        adj = (List<Edge>[]) new LinkedList[size];
        for (int v = 0; v < oldSize;  v ++)
            adj[v] = arr[v];
        for (int v = oldSize; v < size;  v ++)
            adj[v] = new LinkedList<Edge>();
    }
    
    /**
     * ���һ����
     * @param v
     * @param w
     */
    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        if (v == w || hasEdge(v, w)) return; // ����������Ի�
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
