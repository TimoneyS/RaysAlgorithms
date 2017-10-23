package com.ray.graph.intf;

import com.ray.graph.Graph;

/**
 * 搜索路径API
 * @author rays1
 *
 */
public abstract class Paths {
	
	public Paths(Graph G, int s) {
	}
	
	/**
	 * 检查某点是否可达
	 * @param v
	 * @return
	 */
	abstract boolean hashPathTo(int v);
	
	/**
	 * 到某点的路径点列表
	 * @param v
	 * @return
	 */
	abstract Iterable<Integer> pathTo(int v);
	
}
