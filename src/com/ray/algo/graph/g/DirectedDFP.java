package com.ray.algo.graph.g;

import java.util.Stack;

import com.ray.algo.graph.Digraph;
import com.ray.algo.graph.Paths;

/**
 * 深度优先搜索<br>
 * 搜索一幅图，用一个递归方法来遍历所有顶点，在访问其中一个顶点时：<br>
 * 1.将其标记为已访问<br>
 * 2.递归的访问其未被访问的邻居节点<br>
 * 
 * @author rays1
 *
 */
public class DirectedDFP implements Paths {
    
    private boolean[] marked; // 标记某个顶点是否已经被访问
    private int[]     edgeTo; // 存放至某点的一个邻接点
    private int       start;      // 起点

    private DirectedDFP(int V, int s) {
        marked = new boolean[V];
        edgeTo = new int[V];
        start = s;
    }
    
    /**
     * 有向图深度优先
     * @param G
     * @param s
     */
    public DirectedDFP(Digraph G, int s) {
        this(G.V(), s);
        dfs(G, s);
    }
    
    public DirectedDFP(Digraph G, Iterable<Integer> sources) {
        this(G.V(), 0);
        for (int v : sources) {
            if (!marked[v]) dfs(G, v);
        }
    }
    
    /**
     * 无向图深度优先
     * @param G
     * @param v
     */
    private void dfs(Digraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }
    
    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Stack<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        
        Stack<Integer> stack = new Stack<Integer>();
        for (int x = v; x != start; x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(start);
        return stack;
    }

}
