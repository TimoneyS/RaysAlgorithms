package com.ray.graph.weightedDigraph;

import java.util.Stack;

/**
 * 有向加权图的最短路径
 * @author rays1
 *
 */
public class SP {

    DirectedEdge[]    edgeTo;
    double[]          distTo;
    
    double distTo(int v) {
        return distTo[v];
    }
    
    boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }
    
    Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for (DirectedEdge e = edgeTo[v]; e !=null; e = edgeTo[e.from()])
            path.push(e);
        
        return path;
    }
    
    /**
     * 边的松弛
     * @param e
     */
    @SuppressWarnings("unused")
    private void realx(DirectedEdge e) {
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.weighted()) {
            distTo[w] = distTo[v] + e.weighted();
            edgeTo[w] = e;
        }
        
    }
    
    /**
     * 松弛顶点 （即松弛和顶点连接的所有的边）
     * @param G
     * @param v
     */
    @SuppressWarnings("unused")
    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weighted()) {
                distTo[w] = distTo[v] + e.weighted();
                edgeTo[w] = e;
            }
        }
    }
    
    
}
