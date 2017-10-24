package com.ray.graph;

import java.util.Scanner;

import com.ray.utils.Bag;

/**
 * 无向图
 * @author rays1
 *
 */
public class Graph {
	
	private final int V;			// 顶点数
	private int E;					// 边数
	private Bag<Integer>[] adj;		// 内部存储数据结构，保存每个顶点的可达顶点
	
	/**
	 * 指定顶点数初始化图
	 * @param V
	 */
	@SuppressWarnings("unchecked")
	public Graph(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for (int v = 0; v < V;  v ++) adj[v] = new Bag<Integer>();
	}
	
	/**
	 * 
	 * @param in
	 */
	public Graph(Scanner in) {
		this(in.nextInt());
		int e = in.nextInt();
		
		for (int i = 0; i < e; i++) {
			int v = in.nextInt();
			int w = in.nextInt();
			if (v == w || hasEdge(v, w))                          // 不允许出现自环
			    continue;
			addEdge(v, w);
		}
		
	}
	
	/**
	 * 添加一条边
	 * @param v
	 * @param w
	 */
	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
		E ++;
	}
	
	/**
	 * 判断某条边是否存在
	 * @param w
	 * @param w
	 * @return
	 */
	public boolean hasEdge(int v, int w) {
	    for (int tempV : adj(v)) if (w == tempV) return true;
	    return false;
	}
	
	/**
	 * 和顶点 v 连通的顶点
	 * @param v
	 * @return
	 */
	Iterable<Integer> adj(int v) {
		return adj[v];
	}
	
	/**
	 * 计算度数
	 * @param G
	 * @param v
	 * @return
	 */
	public static int degree(Graph G, int v) {
		int degree = 0;
		for (@SuppressWarnings("unused") int w : G.adj(v)) degree ++;
		return degree;
	}
	
	/**
	 * 计算所有顶点的最大度数
	 * @param G
	 * @return
	 */
	public static int maxDegree(Graph G) {
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
	public static int avgDegree(Graph G) {
		return 2 * G.E() / G.V();
	}
	
	/**
	 * 计算自环的个数
	 * @param G
	 * @return
	 */
	public static int numberOfSelfLoops(Graph G) {
		int count = 0;
		for (int v = 0; v < G.V(); v ++) {
			for (int w : G.adj(v)) if (v == w) count ++;
		}
		return count/2;
	}
	
	   
    public String toString() {
        String s = V + " vertices, " + E + " Edges\n";
        for (int v = 0; v < V(); v ++) {
            s += v + " : ";
            for (int w : this.adj(v)) s += w + " ";
            s += "\n";
        }
        return s;
    }
	   
    int V() { return V; }
    int E() { return E; }

}
