package com.ray.graph.wDigraph;

import java.util.Stack;

import com.ray.utils.collections.RaysStack;

/**
 * 无环加权有向图最短路径搜索方法<br>
 * 按照拓扑排序放松顶点，每个先放松的顶点都只会被放松一次<br>
 * @author rays1
 * 
 */
public class AcycliSP {
    
    private boolean[]           marked;           // 标记某个顶点是否已经被访问
    private Stack<Integer>      stack;            // 逆后序排列
    private DirectedEdge[]      edgeTo;
    private double[]            distTo;
    
    public AcycliSP(EdgeWeightedDigraph G, int S) {

        marked = new boolean[G.V()];
        stack  = new Stack<Integer>();
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];

        for (int i = 0; i < G.V(); i ++) {
            distTo[i] = Double.POSITIVE_INFINITY;
            if (!marked[i]) search(G, i);
        }
        distTo[S] = 0.0;

        while (!stack.empty()) {
            int v = stack.pop();
            for (DirectedEdge e : G.adj(v))
                relax(e);
        }

    }

    /**
     * 放松一条边
     * @param e
     */
    private void relax(DirectedEdge e) {
        int v = e.from();                                   // 边的起点
        int w = e.to();                                     // 边的终点
        if (distTo[w] > distTo[v] + e.weighted()) {         // 从生成树到 w 的距离，比从该边起点到 w 要远
            edgeTo[w] = e;                                  // 将到 w 的边设置为该边
            distTo[w] = distTo[v] + e.weighted();           // 将到 w 的距离设为从该边到 w 的距离
        }
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
        stack.push(v);                          // 完成后的顶点加入栈，后完成的顶点在栈顶
    }
    
    double distTo(int v) {
        return distTo[v];
    }

    boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }
    
    RaysStack<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v))
            return null;

        RaysStack<DirectedEdge> path = new RaysStack<DirectedEdge>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
            path.push(e);

        return path;
    }
    
}
