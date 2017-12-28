package com.ray.graph.g;

import java.util.Stack;

/**
 * ����·��API
 * @author rays1
 *
 */
public interface Paths {
	
	/**
	 * ���ĳ���Ƿ�ɴ�
	 * @param v
	 * @return
	 */
	public boolean hasPathTo(int v);
	
	/**
	 * ��ĳ���·�����б�
	 * @param v
	 * @return
	 */
	public Stack<Integer> pathTo(int v);
	
}
