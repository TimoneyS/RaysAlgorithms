package com.ray.graph.gwd;

import com.ray.common.utils.collections.IndexMinPQ;

/**
 * Dijkstra算法<br/>
 * 有向加权图，最短路径搜索。<br/>
 * 若v是从起点可达的，则所有 v -> w 的边都只会被放松一次。<br/>
 * 当v被放松时，必有 distTo[v] <= distTo[w] + e.weight。<br/>
 * distTo[w] 的值只会变小，而distTo[v]的值不会变。<br/>
 * 因此在所有s可达的顶点均被添加到树中后，最短路径的最优性条件成立。<br/>
 * <br/>
 * 注：由于顶点在被放松后，还可能再一次加入队列。<br/>
 * 所以本算法实现实际上也能处理负权重的边，但是这种情况下极端的用例可能导致算法时间复杂度达到指数级别。
 * @author rays1
 *
 */
public class DijkstraSP extends SP {

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

}
