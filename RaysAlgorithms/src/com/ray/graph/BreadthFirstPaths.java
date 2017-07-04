package com.ray.graph;

import java.util.LinkedList;

/**
 * ������������㷨<br>
 * �Ƚ���������У�Ȼ���ظ�һ�²���ֱ������Ϊ��
 * 1.ȡ���е���һ�����㣬����Ǹö���
 * 2.����v���ڵ�����δ����ǵĶ���������
 * @author rays1
 *
 */
public class BreadthFirstPaths {
	
	private boolean[] marked;
	private int[] 	  edgeTo;
	private int 	  s;
	private LinkedList<Integer> queue;
	
	public BreadthFirstPaths(Graph G, int s) {
		marked 	= new boolean[G.V()];
		edgeTo 	= new 	  int[G.V()];
		queue 	= new LinkedList<Integer>();
		this.s = s;
		search(G);
	}
	
	public void search(Graph G) {
		queue.add(s);
		marked[s] = true;
		while (!queue.isEmpty()) {
			int v = queue.poll();
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					edgeTo[w] = v;
					queue.add(w);
					marked[w] = true;
				}
			}
		}
	}
	
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v) {
		if (!marked[v]) return null;
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		for (int x = v; x != s; x = edgeTo[x]) {
			list.push(x);
		}
		list.push(s);
		return list;
	}
	
}
