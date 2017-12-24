package com.ray.graph.gwd;

import java.util.Stack;

/**
 * 有向加权图的最短路径
 * @author rays1
 *
 */
public abstract class SP {

    protected DirectedEdge[]    edgeTo;
    protected double[]          distTo;
    
    /**
     * 边的松弛
     * @param e
     */
    protected void relax(DirectedEdge e) {
        int v = e.from(), w = e.to();                       // 边的起点和终点
        if (distTo[w] > distTo[v] + e.weighted()) {         // 从生成树到 w 的距离，比从该边起点到 w 要远
            edgeTo[w] = e;                                  // 将到 w 的边设置为该边
            distTo[w] = distTo[v] + e.weighted();           // 将到 w 的距离设为从该边到 w 的距离
        }
    }
    
    /**
     * 松弛顶点 （即松弛和顶点连接的所有的边）
     * @param G
     * @param v
     */
    protected void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weighted()) {
                distTo[w] = distTo[v] + e.weighted();
                edgeTo[w] = e;
            }
        }
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Stack<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for (DirectedEdge e = edgeTo[v]; e !=null; e = edgeTo[e.from()])
            path.push(e);
        
        return path;
    }

    
}
