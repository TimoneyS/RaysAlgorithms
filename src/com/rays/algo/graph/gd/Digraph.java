package com.rays.algo.graph.gd;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 有向图
 * @author rays1
 *
 */
public class Digraph {
    
    private int V;                  // 顶点数
    private int E;                  // 边数
    private List<Integer>[] adj;    // 内部存储数据结构，保存每个顶点的邻接顶点
    
    /**
     * 指定顶点数初始化图
     * @param V
     */
    @SuppressWarnings("unchecked")
    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (List<Integer>[]) new LinkedList[V];            // 初始化adj
        for (int v = 0; v < V;  v ++)
            adj[v] = new LinkedList<Integer>();
    }
    
    /**
     * 从输入流初始化图
     * @param in
     */
    public Digraph(Scanner in) {
        while (in.hasNext()) {
            int v = in.nextInt();
            int w = in.nextInt();
            // 判断是否需要调整数组大小
            adjustArrayTo(Math.max(v, w) + 1);
            if (v == w || hasEdge(v, w)) // 不允许出现自环
                continue;
            addEdge(v, w);
        }
        
        this.V = adj.length;
        
    }
    
    /**
     * 添加一条边
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        if (v == w || hasEdge(v, w)) return; // 不允许出现自环和平行边
        adj[v].add(w);
        E ++;
    }
    
    /**
     * 返回顶点的邻接顶点
     * @param v
     * @return
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
    
    /**
     * 返回该图的反向图
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
     * 判断某条边是否存在
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
     * 判断是否需要调整数组大小
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
