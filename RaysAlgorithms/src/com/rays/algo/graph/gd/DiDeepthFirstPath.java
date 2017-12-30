package com.rays.algo.graph.gd;

import java.util.LinkedList;

/**
 * 有向图的深度优先路径(和无向图的深度优先算法代码一样)
 * @author rays1
 *
 */
public class DiDeepthFirstPath {

    private boolean[] marked; // 标记某个顶点是否已经被访问
    private int[]     edgeTo; // 存放至某点的一个邻接点
    private int       s;      // 起点

    public DiDeepthFirstPath(Digraph G, int s) {
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
    public LinkedList<Integer> pathTo(int v) {
        if (!hasPathTo(v))
            return null;

        LinkedList<Integer> path = new LinkedList<Integer>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
    
}
