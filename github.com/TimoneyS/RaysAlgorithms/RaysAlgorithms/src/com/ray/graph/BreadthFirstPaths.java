package com.ray.graph;

import java.util.LinkedList;

/**
 * 广度优先搜索算法<br>
 * 先将起点加入队列，然后重复一下步骤直到队列为空
 * 1.取队列的下一个顶点，并标记该顶点
 * 2.将与v相邻的所有未被标记的顶点加入队列
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
