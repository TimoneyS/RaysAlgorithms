package com.ray.graph;

public abstract class Search {
	
	/**
	 * �ҵ������s��ͨ�����ж���
	 * @param G
	 * @param s
	 */
	public Search(Graph G, int s) {}
	
	/**
	 * v �� s ����ͨ����
	 * @param v
	 * @return
	 */
	abstract boolean marked(int v);
	
	/**
	 * �� s ��ͨ�Ķ�������
	 * @return
	 */
	abstract int count();
	
}
