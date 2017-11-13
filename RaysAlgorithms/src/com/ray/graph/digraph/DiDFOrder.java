package com.ray.graph.digraph;

import java.util.Stack;

/**
 * 拓扑排序， 计算一个图的逆后序排列
 * @author rays1
 *
 */
public class DiDFOrder {
    private boolean[] marked;           // 标记某个顶点是否已经被访问
    private Stack<Integer> reverPost;   // 逆后序排列

    public DiDFOrder(Digraph G) {
        marked = new boolean[G.V()];
        reverPost = new Stack<Integer>();
        for (int i = 0 ; i < G.V(); i++)
            if (!marked[i]) search(G, i);
    }

    /**
     * 搜索算法
     * 
     * @param G
     * @param v
     */
    private void search(Digraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w])
                search(G, w);
        }
        reverPost.push(v);
    }
    
    public Stack<Integer> reverPost() {
        return reverPost;
    }
    
}
