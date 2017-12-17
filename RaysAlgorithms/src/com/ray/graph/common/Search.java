package com.ray.graph.common;

import com.ray.graph.graph.Graph;

/**
 * 搜索API
 * @author rays1
 *
 */
public abstract class Search {
	
	/**
	 * 找到和起点s连通的所有顶点
	 * @param G
	 * @param s
	 */
	public Search(Graph G, int s) {}
	
	/**
	 * v 和 s 是否连通
	 * @param v
	 * @return
	 */
	public abstract boolean marked(int v);
	
	/**
	 * 与 s 连通的顶点总数
	 * @return
	 */
	public abstract int count();
	
}
