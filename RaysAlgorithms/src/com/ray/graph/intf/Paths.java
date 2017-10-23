package com.ray.graph.intf;

/**
 * 搜索路径API
 * @author rays1
 *
 */
public abstract class Paths {
	
	/**
	 * 检查某点是否可达
	 * @param v
	 * @return
	 */
	public abstract boolean hasPathTo(int v);
	
	/**
	 * 到某点的路径点列表
	 * @param v
	 * @return
	 */
	public abstract Iterable<Integer> pathTo(int v);
	
}
