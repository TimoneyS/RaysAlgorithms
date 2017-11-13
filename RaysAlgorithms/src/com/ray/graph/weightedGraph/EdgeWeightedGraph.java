package com.ray.graph.weightedGraph;

import java.util.Scanner;

import com.ray.utils.Bag;

/**
<<<<<<< HEAD
 * ��Ȩͼ(�������Ի���ƽ�б�)
 * @author rays1
 *
 */
public class EdgeWeightedGraph {
    
    private final int V;            // ������
    private int E;                  // ����
    private Bag<Edge>[] adj;     // �ڲ��洢���ݽṹ������ÿ������Ŀɴ��
    
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
=======
 * ��Ȩͼ
 * @author rays1
 *
 */
public class EdgeWeightedGraph {
    
    private final int V;            // ������
    private int E;                  // ����
    private Bag<Edge>[] adj;     // �ڲ��洢���ݽṹ������ÿ������Ŀɴ��
    
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
            int weighted = in.nextInt();
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
     * �������
     * @param G
     * @param v
     * @return
     */
    public static int degree(EdgeWeightedGraph G, int v) {
        int degree = 0;
        for (@SuppressWarnings("unused") Edge e : G.adj(v)) degree ++;
        return degree;
    }
    
    /**
     * �������ж����������
     * @param G
     * @return
     */
    public static int maxDegree(EdgeWeightedGraph G) {
        int max = 0;
        for(int v = 0;  v < G.V(); v ++) {
            if(degree(G, v) > max) max = degree(G, v);
        }
        return max;
    }
    
    /**
     * �������ж����ƽ������
     * @param G
     * @return
     */
    public static int avgDegree(EdgeWeightedGraph G) {
        return 2 * G.E() / G.V();
    }
    
    /**
     * �����Ի��ĸ���
     * @param G
     * @return
     */
    public static int numberOfSelfLoops(EdgeWeightedGraph G) {
        int count = 0;
        for (int v = 0; v < G.V(); v ++) {
            for (Edge e : G.adj(v)) if (e.other(v) == v) count ++;
        }
        return count/2;
>>>>>>> branch 'master' of https://github.com/TimoneyS/RaysAlgorithms
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
