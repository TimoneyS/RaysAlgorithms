package com.ray.graph.graph;

import java.util.LinkedList;

import com.ray.graph.intf.Paths;

/**
 * 深度优先搜索<br>
 * 搜索一幅图，用一个递归方法来遍历所有顶点，在访问其中一个顶点时：<br>
 * 1.将其标记为已访问<br>
 * 2.递归的访问其未被访问的邻居节点<br>
 * 
 * @author rays1
 *
 */
public class DeepthFirstPaths implements Paths {
    
    private boolean[] marked; // 标记某个顶点是否已经被访问
    private int[]     edgeTo; // 存放至某点的一个邻接点
    private int       s;      // 起点

    public DeepthFirstPaths(Graph G, int s) {
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
    public void search(Graph G, int v) {
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
