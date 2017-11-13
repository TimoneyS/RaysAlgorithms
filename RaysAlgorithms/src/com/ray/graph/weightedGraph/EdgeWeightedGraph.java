package com.ray.graph.weightedGraph;

import java.util.Scanner;

import com.ray.utils.Bag;

/**
<<<<<<< HEAD
 * 加权图(不允许自环和平行边)
 * @author rays1
 *
 */
public class EdgeWeightedGraph {
    
    private final int V;            // 顶点数
    private int E;                  // 边数
    private Bag<Edge>[] adj;     // 内部存储数据结构，保存每个顶点的可达边
    
    /**
     * 指定顶点数初始化图
     * @param V
     */
    @SuppressWarnings("unchecked")
    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];            // 初始化adj
        for (int v = 0; v < V;  v ++)
            adj[v] = new Bag<Edge>();
    }
    
    /**
     * 从输入流初始化图
     * @param in
     */
    public EdgeWeightedGraph(Scanner in) {
        this(in.nextInt());
        int e = in.nextInt();
        
        for (int i = 0; i < e; i++) {
            int v = in.nextInt();
            int w = in.nextInt();
            double weighted = in.nextDouble();
            if (v == w || hasEdge(v, w))                          // 不允许出现自环
                continue;
            addEdge(new Edge(v, w, weighted));
        }
        
    }
    
    /**
     * 添加一条边
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
     * 判断某条边是否存在
     * @param w
     * @param w
     * @return
     */
    public boolean hasEdge(int v, int w) {
        for (Edge e : adj(v)) if (e.other(v)==w) return true;
        return false;
    }
    
    /**
     * 和顶点 v 连通的顶点
     * @param v
     * @return
     */
    Iterable<Edge> adj(int v) {
        return adj[v];
=======
 * 加权图
 * @author rays1
 *
 */
public class EdgeWeightedGraph {
    
    private final int V;            // 顶点数
    private int E;                  // 边数
    private Bag<Edge>[] adj;     // 内部存储数据结构，保存每个顶点的可达边
    
    /**
     * 指定顶点数初始化图
     * @param V
     */
    @SuppressWarnings("unchecked")
    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];            // 初始化adj
        for (int v = 0; v < V;  v ++)
            adj[v] = new Bag<Edge>();
    }
    
    /**
     * 从输入流初始化图
     * @param in
     */
    public EdgeWeightedGraph(Scanner in) {
        this(in.nextInt());
        int e = in.nextInt();
        
        for (int i = 0; i < e; i++) {
            int v = in.nextInt();
            int w = in.nextInt();
            int weighted = in.nextInt();
            if (v == w || hasEdge(v, w))                          // 不允许出现自环
                continue;
            addEdge(new Edge(v, w, weighted));
        }
        
    }
    
    /**
     * 添加一条边
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
     * 判断某条边是否存在
     * @param w
     * @param w
     * @return
     */
    public boolean hasEdge(int v, int w) {
        for (Edge e : adj(v)) if (e.other(v)==w) return true;
        return false;
    }
    
    /**
     * 和顶点 v 连通的顶点
     * @param v
     * @return
     */
    Iterable<Edge> adj(int v) {
        return adj[v];
    }
    
    /**
     * 计算度数
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
     * 计算所有顶点的最大度数
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
     * 计算所有顶点的平均度数
     * @param G
     * @return
     */
    public static int avgDegree(EdgeWeightedGraph G) {
        return 2 * G.E() / G.V();
    }
    
    /**
     * 计算自环的个数
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
     * 打印图
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
