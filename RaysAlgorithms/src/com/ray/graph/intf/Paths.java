package com.ray.graph.intf;

/**
 * ����·��API
 * @author rays1
 *
 */
public abstract class Paths {
	
	/**
	 * ���ĳ���Ƿ�ɴ�
	 * @param v
	 * @return
	 */
	public abstract boolean hasPathTo(int v);
	
	/**
	 * ��ĳ���·�����б�
	 * @param v
	 * @return
	 */
	public abstract Iterable<Integer> pathTo(int v);
	
}
