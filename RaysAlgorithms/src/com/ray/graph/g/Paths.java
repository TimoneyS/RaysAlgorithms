package com.ray.graph.g;

import java.util.Stack;

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
	public Stack<Integer> pathTo(int v);
	
}
