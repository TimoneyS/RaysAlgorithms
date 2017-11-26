package com.ray.graph.weightedGraph;

import java.util.Stack;

/**
 * �����Ȩͼ�����·��
 * @author rays1
 *
 */
public class SP {

    DirectedEdge[]    edgeTo;
    double[]          distTo;
    
    public SP(EdgeWeightedDigraph G) {
        // TODO Auto-generated constructor stub
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        for (int i = 0; i < distTo.length; i ++)
            distTo[i] = Double.POSITIVE_INFINITY;
        
    }
    
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
     * �ߵ��ɳ�
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
     * �ɳڶ��� �����ɳںͶ������ӵ����еıߣ�
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
