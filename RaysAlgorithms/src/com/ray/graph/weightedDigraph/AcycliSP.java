package com.ray.graph.weightedDigraph;

import java.util.Stack;

import com.ray.utils.Out;
import com.ray.utils.collections.RaysStack;

/**
 * 无环加权有向图最短路径搜索方法
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
Out.p(edgeTo);
Out.p(distTo);
        }

    }

    private void relax(DirectedEdge e) {
        int v = e.from();
        int w = e.to();
        if (distTo[w] > distTo[v] + e.weighted()) {
            distTo[w] = distTo[v] + e.weighted();
            edgeTo[w] = e;
        }
    }
    
    private void search(EdgeWeightedDigraph G, int v) {
        
        marked[v] = true;
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (!marked[w])
                search(G, w);
        }
        stack.push(v);
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
