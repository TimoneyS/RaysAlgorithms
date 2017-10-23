package com.ray.graph.intf;

import java.util.LinkedList;

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
	public LinkedList<Integer> pathTo(int v);
	
}
