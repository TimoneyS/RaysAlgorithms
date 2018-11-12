package com.rays.algo.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 加权无向图(不允许自环和平行边)
 * @author rays1
 *
 */
public class EdgeWeightedGraph {
    
    private final int       V;   // 顶点数
    private int             E;   // 边数
    private List<Edge>[]  adj; // 内部存储数据结构，保存每个顶点的可达边
    
    /**
     * 从输入流初始化图
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
     * 调整数组大小
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
     * 添加一条边
     * @param v
     * @param w
     */
    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        if (v == w || hasEdge(v, w)) return; // 不允许出现自环
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
    public Iterable<Edge> adj(int v) {
        return adj[v];
    }
    
    /**
     * 打印图
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(V).append(" vertices, ").append(E).append(" Edges\n");
        
        for (int v = 0; v < V(); v ++) {
            sb.append(v).append(" ");
            for (Edge e : this.adj(v)) {
                sb.append(e.other(v)).append(" ").append(e.getWeighted()).append("\n");
            }
        }
        return sb.toString();
    }
    /**
     * 获取所有边
     * @return
     */
    public Iterable<Edge> edges() {
        List<Edge> list = new ArrayList<Edge>(E);
        for (int v = 0; v < V; v++) {
            int selfLoops = 0;
            for (Edge e : adj(v)) {
                if (e.other(v) > v) {
                    list.add(e);
                } else if (e.other(v) == v) {
                    // add only one copy of each self loop (self loops will be consecutive)
                    if (selfLoops % 2 == 0)
                        list.add(e);
                    selfLoops++;
                }
            }
        }
        return list;
    }
    
    /**
     * 顶点数
     * @return
     */
    public int V() { return V; }
    
    /**
     * 边树
     * @return
     */
    public int E() { return E; }
    
}
