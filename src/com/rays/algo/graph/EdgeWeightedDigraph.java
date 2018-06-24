package com.rays.algo.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * ��Ȩ����ͼ(�������Ի���ƽ�б�)
 * @author rays1
 *
 */
public class EdgeWeightedDigraph {
    
    private final int   V;              // ������
    private int         E;              // ����
    private List<DirectedEdge>[] adj;    // �ڲ��洢���ݽṹ������ÿ������Ŀɴ��
    
    @SuppressWarnings("unchecked")
    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (List<DirectedEdge>[]) new LinkedList[V];
        for (int v = 0; v < V;  v ++)
            adj[v] = new LinkedList<DirectedEdge>();
    }
    
    /**
     * ����������ʼ��ͼ
     * @param in
     */
    public EdgeWeightedDigraph(Scanner in) {
        while (in.hasNext()) {
            int from = in.nextInt();
            int to = in.nextInt();
            double weighted = in.nextDouble();
            adjustArrayTo(Math.max(from, to)+1);
            addEdge(new DirectedEdge(from, to, weighted));
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
        List<DirectedEdge>[] arr = adj;
        adj = (List<DirectedEdge>[]) new LinkedList[size];
        for (int v = 0; v < oldSize;  v ++)
            adj[v] = arr[v];
        for (int v = oldSize; v < size;  v ++)
            adj[v] = new LinkedList<DirectedEdge>();
    }
    
    
    /**
     * ��������ͼ�����б�
     * @return
     */
    public Iterable<DirectedEdge> edges() {
        List<DirectedEdge> bag = new LinkedList<DirectedEdge>();
        
        for (int i = 0; i < adj.length; i++) {
            for (DirectedEdge edge : adj[i])
                bag.add(edge);
        }
        
        return bag;
    }
    
    /**
     * ���һ����
     * @param v
     * @param w
     */
    public void addEdge(DirectedEdge e) {
        int from = e.from();
        int to = e.to();
        if (from == to || hasEdge(from, to)) return;  // ����������Ի�
        adj[from].add(e);
        E ++;
    }
    
    /**
     * ���һ����
     * @param v
     * @param w
     */
    public void addEdge(int v, int w, double weighted) {
        addEdge(new DirectedEdge(v, w, weighted));
    }
    
    /**
     * �ж�ĳ�����Ƿ����
     * @param w
     * @param w
     * @return
     */
    public boolean hasEdge(int from, int to) {
        for (DirectedEdge e : adj(from)) if (e.to()==to) return true;
        return false;
    }
    
    /**
     * �Ͷ��� v ��ͨ�Ķ���
     * @param v
     * @return
     */
    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }
    
    /**
     * ��ӡͼ
     */
    public String toString() {
        String s = V + " vertices, " + E + " Edges\n";
        for (int from = 0; from < V(); from ++) {
            String temp = from + " ";
            for (DirectedEdge e : this.adj(from)) {
                s += temp + e.to() + " " + e.weighted() + "\n";
            }
        }
        return s;
    }
    
    /**
     * ���
     * @return
     */
    public EdgeWeightedDigraph copy() {
        
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(V);
        
        for (int i = 0; i < V; i ++) {
            for (DirectedEdge e : adj[i]) {
                G.addEdge(e.copy());
            }
        }
        
        return G;
    }
       
    public int V() { return V; }
    public int E() { return E; }
    
}
