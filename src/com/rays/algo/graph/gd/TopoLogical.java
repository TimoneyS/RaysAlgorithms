package com.rays.algo.graph.gd;

import java.util.Stack;

import com.rays.algo.graph.gwd.DirectedEdge;
import com.rays.algo.graph.gwd.EdgeWeightedDigraph;

/**
 * 图的拓扑排序
 * 
 * @author rays1
 *
 */
public class TopoLogical {
    private boolean[]      marked;      // 标记某个顶点是否已经被访问
    private Stack<Integer> reverPost;   // 逆后序排列

    /**
     * 有向图拓扑排序
     * @param G
     */
    public TopoLogical(Digraph G) {
        marked = new boolean[G.V()];
        reverPost = new Stack<Integer>();
        for (int v = 0; v < marked.length; v++)
            if (!marked[v]) search(G, v);
    }
    
    public TopoLogical(EdgeWeightedDigraph G) {
        marked = new boolean[G.V()];
        reverPost = new Stack<Integer>();
        for (int v = 0; v < marked.length; v++)
            if (!marked[v]) search(G, v);
    }

    public void search(Digraph G, int v) {
        marked[v] = true;                       // 将 v 标记为已经访问
        for (int w : G.adj(v))                  // 访问 v 的每个邻接顶点 w
            if (!marked[w]) search(G, w);       // 若邻接顶点未被访问，则访问其邻接顶点
        reverPost.push(v);                      // 完成后的顶点加入栈，后完成的顶点在栈顶
    }
    
    /**
     * 拓扑排序搜索
     * @param G
     * @param v
     */
    private void search(EdgeWeightedDigraph G, int v) {
        marked[v] = true;                       // 将 v 标记为已经访问
        for (DirectedEdge e : G.adj(v)) {       // 访问 v 的每条邻边 e
            int w = e.to();                     // 邻边 e 的终点
            if (!marked[w])                     // 若邻边未被访问
                search(G, w);                   // 访问其邻边
        }
        reverPost.push(v);                      // 完成后的顶点加入栈，后完成的顶点在栈顶
    }
    
    public Stack<Integer> order() {
        return reverPost;
    }

}
