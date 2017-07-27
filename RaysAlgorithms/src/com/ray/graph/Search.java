package com.ray.graph;

/**
 * �����ĳ�����
 * @author rays1
 *
 */
public abstract class Search {
	
	/**
	 * �ҵ������s��ͨ�����ж���
	 * @param G
	 * @param s
	 */
	public Search(Graph G, int s) {}
	
	/**
	 * v �� s �Ƿ���ͨ
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
