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
	private Bag<Integer>[] adj;		// 内部存储数据结构
	
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
			addEdge(v, w);
		}
		
	}
	
	/**
	 * 添加一条边
	 * @param v
	 * @param w
	 */
	void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
		E ++;
	}
	
	/**
	 * 和定点 v 连通的顶点
	 * @param v
	 * @return
	 */
	Iterable<Integer> adj(int v) {
		return adj[v];
	}
	
	public String toString() {
		String s = V + " vertices, " + E + " Edges\n";
		for (int v = 0; v < V(); v ++) {
			s += v + ": ";
			for (int w : this.adj(v)) s += w + " ";
			s += "\n";
		}
		return s;
	}
	
	int V() { return V; }
	int E() { return E; }
	
	public static int degree(Graph G, int v) {
		// 计算度数
		int degree = 0;
		for (@SuppressWarnings("unused") int w : G.adj(v)) degree ++;
		return degree;
	}
	
	public static int maxDegree(Graph G) {
		// 计算所有顶点的最大度数
		int max = 0;
		for(int v = 0;  v < G.V(); v ++) {
			if(degree(G, v) > max) max = degree(G, v);
		}
		return max;
	}
	
	public static int avgDegree(Graph G) {
		// 计算所有顶点的平均度数
		return 2 * G.E() / G.V();
	}
	
	public static int numberOfSelfLoops(Graph G) {
		// 计算自环的个数
		int count = 0;
		for (int v = 0; v < G.V(); v ++) {
			for (int w : G.adj(v)) if (v == w) count ++;
		}
		return count/2;
	}

}
