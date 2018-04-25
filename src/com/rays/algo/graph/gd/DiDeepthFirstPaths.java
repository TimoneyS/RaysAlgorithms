package com.rays.algo.graph.gd;

import java.util.Stack;

import com.rays.algo.graph.g.Paths;

/**
 * 有向图的深度优先搜索(和无向图的深度优先算法代码一致)
 * @author rays1
 *
 */
public class DiDeepthFirstPaths implements Paths {

    private boolean[] marked; // 标记某个顶点是否已经被访问
    private int[]     edgeTo; // 存放至某点的一个邻接点
    private int       s;      // 起点

    public DiDeepthFirstPaths(Digraph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        search(G, s);
    }

    /**
     * 搜索算法
     * 
     * @param G
     * @param v
     */
    public void search(Digraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                search(G, w);
            }
        }
    }

    /**
     * 查询起点和v是否连通
     * 
     * @param v
     * @return
     */
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /**
     * 获取起点至v的路径
     * 
     * @param v
     * @return
     */
    public Stack<Integer> pathTo(int v) {
        if (!hasPathTo(v))
            return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
    
}
