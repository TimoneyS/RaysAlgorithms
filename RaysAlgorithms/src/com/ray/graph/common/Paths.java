package com.ray.graph.common;

import java.util.LinkedList;

/**
 * 搜索路径API
 * @author rays1
 *
 */
public interface Paths {
	
	/**
	 * 检查某点是否可达
	 * @param v
	 * @return
	 */
	public boolean hasPathTo(int v);
	
	/**
	 * 到某点的路径点列表
	 * @param v
	 * @return
	 */
	public LinkedList<Integer> pathTo(int v);
	
}
