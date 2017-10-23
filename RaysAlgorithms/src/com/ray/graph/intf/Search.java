package com.ray.graph.intf;

import com.ray.graph.Graph;

/**
 * ����API
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
	public abstract boolean marked(int v);
	
	/**
	 * �� s ��ͨ�Ķ�������
	 * @return
	 */
	public abstract int count();
	
}