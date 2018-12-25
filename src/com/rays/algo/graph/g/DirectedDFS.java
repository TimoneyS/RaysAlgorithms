package com.rays.algo.graph.g;

import com.rays.algo.graph.Digraph;

/**
 * 深度优先搜索<br>
 * 搜索一幅图，用一个递归方法来遍历所有顶点，在访问其中一个顶点时：<br>
 * 1.将其标记为已访问<br>
 * 2.递归的访问其未被访问的邻居节点<br>
 * 
 * @author rays1
 *
 */
public class DirectedDFS {
    
    private boolean[] marked; // 标记某个顶点是否已经被访问

    /**
     * 有向图深度优先
     * @param G
     * @param s
     */
    public DirectedDFS(Digraph G, int s) {
        init(G.V());
        dfs(G, s);
    }
    
    public DirectedDFS(Digraph G, Iterable<Integer> sources) {
        init(G.V());
        for (int v : sources)
            if (!marked[v]) dfs(G, v);
    }
    
    /**
     * 无向图深度优先
     * @param G
     * @param v
     */
    private void dfs(Digraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v))
            if (!marked[w]) dfs(G, w);
    }
    
    private void init(int V) {
        marked = new boolean[V];
    }
    
    public boolean marked(int v) {
        return marked[v];
    }

}
