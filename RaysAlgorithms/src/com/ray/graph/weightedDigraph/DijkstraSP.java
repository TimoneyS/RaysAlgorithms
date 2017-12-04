package com.ray.graph.weightedDigraph;

import java.util.Stack;

import com.ray.utils.collections.IndexMinPQ;

/**
 * Dijkstra算法
 * 有向加权图，最短路径搜索。
 * @author rays1
 *
 */
public class DijkstraSP {

    private DirectedEdge[]      edgeTo;
    private double[]            distTo;
    private IndexMinPQ<Double>  pq;

    public DijkstraSP(EdgeWeightedDigraph G, int S) {
        
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        for (int i = 0; i < distTo.length; i ++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        pq  = new IndexMinPQ<Double>(G.V());
        search(G, S);
    }
    
    private void search(EdgeWeightedDigraph G,int S) {
        
        distTo[S] = 0;                                      // 初始化起点
        pq.insert(S, 0d);                                   // 初始化起点
        
        while (!pq.isEmpty()) {
            int min = pq.delMin();                                          // 获取距离树最近的顶点
            for (DirectedEdge e : G.adj(min)) {
                int w = e.to();
                if (distTo[w] > distTo[min] + e.weighted()) {               // 如果从该顶点到其邻接点更近
                    distTo[w] = distTo[min] + e.weighted();                 // 更新邻接点
                    edgeTo[w] = e;                                          // 将到邻接点的路径设为该点
                    
                    if (pq.contains(w)) pq.changeKey(w, distTo[w]);         // 邻接点的路径变了， 邻接点的邻接点也要变更，因此加入队列
                    else                pq.insert(w,  distTo[w]);
                }
            }
            
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
     * 
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
