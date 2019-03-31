package com.rays.algo.graph.g;

import com.ray.util.collections.RaysIndexMinPQ;
import com.rays.algo.graph.DirectedEdge;
import com.rays.algo.graph.EdgeWeightedDigraph;

/**
 * 
 * Dijkstra算法<br/>
 * 有向加权图，最短路径搜索。<br/>
 * 
 * @author rays1
 *
 */
public class DijkstraSP extends SP {

    private RaysIndexMinPQ<Double>  pq;

    public DijkstraSP(EdgeWeightedDigraph G, int S) {
        
        pq  = new RaysIndexMinPQ<Double>(G.V());
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        
        for (int i = 0; i < distTo.length; i ++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        
        distTo[S] = 0;                                      // 初始化起点
        pq.insert(S, 0d);                                   // 初始化起点
        
        while (!pq.isEmpty()) {
            relax(G, pq.delMin());                          // 放松距离树最近的顶点
        }
        
    }
    
    @Override
    protected void relax(EdgeWeightedDigraph G, int v) {
        
        for (DirectedEdge e : G.adj(v)) {
            
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weighted()) {     // 如果从该顶点到其邻接点更近
                distTo[w] = distTo[v] + e.weighted();       // 更新邻接点
                edgeTo[w] = e;                              // 将到邻接点的路径设为该点

                // 将顶点相连的边插入队列或者更新
                if (pq.contains(w))
                    pq.changeKey(w, distTo[w]);
                else
                    pq.insert(w, distTo[w]);
            }
            
        }
        
    }

}
