package com.ray.graph.weightedGraph;

import java.util.Stack;

import com.ray.utils.IndexMinPQ;
import com.ray.utils.Out;

/**
 * Dijkstra算法
 * 
 * @author rays1
 *
 */
public class DijkstraSP {

    private DirectedEdge[] edgeTo;
    private double[]       distTo;
    private IndexMinPQ<Double> pq;

    public DijkstraSP(EdgeWeightedDigraph G) {
        
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        for (int i = 0; i < distTo.length; i ++)
            distTo[i] = Double.POSITIVE_INFINITY;
        
        pq  = new IndexMinPQ<Double>(G.V());
        
        distTo[0] = 0;
        relax(G, 0);        
        pq.insert(0, 0d);
        
        //while (true) {
        
        for (int k = 0; k < 20; k++) {
            int v = pq.delMin();
            relax(G, v);
            for (DirectedEdge e : G.adj(v)) {
                int w = e.to();
                if (!pq.contains(w))
                pq.insert(w, distTo[w]);
            }
            
            Out.pt("pq : ");
            for (int i : pq)
                Out.pt(i + ", ");
            Out.p("");
            Out.pt("distTo : ");
            for (double i : distTo)
                Out.pt(i + ", ");
            Out.p("");
            Out.pt("edgeTo : ");
            for (DirectedEdge e : edgeTo)
                Out.pt(e + ", ");
            Out.p("\n===============");
           
            if (pq.size() == 0) 
                break;
        }
        
    }

    double distTo(int v) {
        return distTo[v];
    }

    boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v))
            return null;

        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
            path.push(e);

        return path;
    }

    /**
     * 边的松弛
     * 
     * @param e
     */
    private void realx(DirectedEdge e) {
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.weighted()) {
            distTo[w] = distTo[v] + e.weighted();
            edgeTo[w] = e;
        }

    }

    /**
     * 松弛顶点 （即松弛和顶点连接的所有的边）
     * 
     * @param G
     * @param v
     */
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
