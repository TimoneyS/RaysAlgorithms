package com.rays.algo.graph;

import java.util.Scanner;

import com.ray.common.collections.Bag;

/**
 * ��Ȩ����ͼ(�������Ի���ƽ�б�)
 * @author rays1
 *
 */
public class EdgeWeightedDigraph {
    
    private final int   V;              // ������
    private int         E;              // ����
    private Bag<DirectedEdge>[] adj;    // �ڲ��洢���ݽṹ������ÿ������Ŀɴ��
    
    /**
     * ָ����������ʼ��ͼ
     * @param V
     */
    @SuppressWarnings("unchecked")
    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<DirectedEdge>[]) new Bag[V];            // ��ʼ��adj
        for (int v = 0; v < V;  v ++)
            adj[v] = new Bag<DirectedEdge>();
    }
    
    /**
     * ����������ʼ��ͼ
     * @param in
     */
    public EdgeWeightedDigraph(Scanner in) {
        this(in.nextInt());
        int e = in.nextInt();
        
        for (int i = 0; i < e; i++) {
            int from = in.nextInt();
            int to = in.nextInt();
            double weighted = in.nextDouble();
            if (from == to || hasEdge(from, to))                          // ����������Ի�
                continue;
            addEdge(new DirectedEdge(from, to, weighted));
        }
        
    }
    
    /**
     * ��������ͼ�����б�
     * @return
     */
    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> bag = new Bag<DirectedEdge>();
        
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
