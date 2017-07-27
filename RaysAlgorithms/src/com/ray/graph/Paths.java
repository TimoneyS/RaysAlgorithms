package com.ray.graph;

/**
 * ����·���ĳ�����
 * @author rays1
 *
 */
public abstract class Paths {
	
	public Paths(Graph G, int s) {
	}
	
	/**
	 * ���ĳ���Ƿ�ɴ�
	 * @param v
	 * @return
	 */
	abstract boolean hashPathTo(int v);
	
	/**
	 * ��ĳ���·�����б�
	 * @param v
	 * @return
	 */
	abstract Iterable<Integer> pathTo(int v);
	
}
