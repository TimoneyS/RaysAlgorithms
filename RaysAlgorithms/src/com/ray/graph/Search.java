package com.ray.graph;

public abstract class Search {
	
	/**
	 * 找到和起点s联通的所有顶点
	 * @param G
	 * @param s
	 */
	public Search(Graph G, int s) {}
	
	/**
	 * v 和 s 是联通的吗
	 * @param v
	 * @return
	 */
	abstract boolean marked(int v);
	
	/**
	 * 与 s 联通的顶点总数
	 * @return
	 */
	abstract int count();
	
}
