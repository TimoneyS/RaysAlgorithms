package com.ray.graph;

/**
 * 深度优先搜索<br>
 * 搜索一幅图，用一个递归方法来便利所有顶点，在访问其中一个顶点时：<br>
 * 	&nbsp;1.将其标记为已访问<br>
 *  &nbsp;2.递归的访问其未被访问的邻居节点<br>
 * @author rays1
 *
 */
public class DeepFirstSearch {
	
	private boolean[] marked;
	private int count;
	
	public DeepFirstSearch(Graph G, int s) {
		marked = new boolean[G.V()];
		search(G, s);
	}
	
	public void search(Graph G, int v) {
		marked[v] = true;
		count ++;
		for (int w : G.adj(v)) if (!marked[w]) search(G, w);
	}
	
	boolean marked(int v) {
		return marked[v];
	}

	int count() {
		return count;
	}
	
}
