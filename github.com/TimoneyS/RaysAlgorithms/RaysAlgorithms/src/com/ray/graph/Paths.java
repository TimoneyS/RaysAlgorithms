package com.ray.graph;

/**
 * 搜索路径的抽象类
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
