package com.rays.algo.graph;

import java.util.Scanner;

import com.ray.common.collections.Bag;

/**
 * 加权有向图(不允许自环和平行边)
 * @author rays1
 *
 */
public class EdgeWeightedDigraph {
    
    private final int   V;              // 顶点数
    private int         E;              // 边数
    private Bag<DirectedEdge>[] adj;    // 内部存储数据结构，保存每个顶点的可达边
    
    /**
     * 指定顶点数初始化图
     * @param V
     */
    @SuppressWarnings("unchecked")
    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<DirectedEdge>[]) new Bag[V];            // 初始化adj
        for (int v = 0; v < V;  v ++)
            adj[v] = new Bag<DirectedEdge>();
    }
    
    /**
     * 从输入流初始化图
     * @param in
     */
    public EdgeWeightedDigraph(Scanner in) {
        this(in.nextInt());
        int e = in.nextInt();
        
        for (int i = 0; i < e; i++) {
            int from = in.nextInt();
            int to = in.nextInt();
            double weighted = in.nextDouble();
            if (from == to || hasEdge(from, to))                          // 不允许出现自环
                continue;
            addEdge(new DirectedEdge(from, to, weighted));
        }
        
    }
    
    /**
     * 返回有向图的所有边
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
     * 添加一条边
     * @param v
     * @param w
     */
    public void addEdge(DirectedEdge e) {
        int from = e.from();
        adj[from].add(e);
        E ++;
    }
    
    /**
     * 添加一条边
     * @param v
     * @param w
     */
    public void addEdge(int v, int w, double weighted) {
        addEdge(new DirectedEdge(v, w, weighted));
    }
    
    /**
     * 判断某条边是否存在
     * @param w
     * @param w
     * @return
     */
    public boolean hasEdge(int from, int to) {
        for (DirectedEdge e : adj(from)) if (e.to()==to) return true;
        return false;
    }
    
    /**
     * 和顶点 v 连通的顶点
     * @param v
     * @return
     */
    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }
    
    /**
     * 打印图
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
     * 深复制
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
