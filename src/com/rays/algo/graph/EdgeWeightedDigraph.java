package com.rays.algo.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 加权有向图(不允许自环和平行边)
 * @author rays1
 *
 */
public class EdgeWeightedDigraph {
    
    private final int   V;              // 顶点数
    private int         E;              // 边数
    private List<DirectedEdge>[] adj;    // 内部存储数据结构，保存每个顶点的可达边
    
    @SuppressWarnings("unchecked")
    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (List<DirectedEdge>[]) new LinkedList[V];
        for (int v = 0; v < V;  v ++)
            adj[v] = new LinkedList<DirectedEdge>();
    }
    
    /**
     * 从输入流初始化图
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
     * 调整数组大小
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
     * 返回有向图的所有边
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
     * 添加一条边
     * @param v
     * @param w
     */
    public void addEdge(DirectedEdge e) {
        int from = e.from();
        int to = e.to();
        if (from == to || hasEdge(from, to)) return;  // 不允许出现自环
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
