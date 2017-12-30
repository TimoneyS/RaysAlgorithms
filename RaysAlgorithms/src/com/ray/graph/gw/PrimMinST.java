package com.ray.graph.gw;

import com.ray.common.utils.collections.IndexMinPQ;

/**
 * Prim算法
 * @author rays1
 *
 */
public class PrimMinST {
    
    private Edge[]             edgeTo;
    private double[]           distTo;
    private boolean[]          marked;
    private IndexMinPQ<Double> PQ;
    
    public PrimMinST(EdgeWeightedGraph G) {
        
        PQ = new IndexMinPQ<Double>(G.V());
        edgeTo = new Edge[G.V()];
        marked = new boolean[G.V()];
        distTo = new double[G.V()];
        
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        
        distTo[0] = 0.0;
        PQ.insert(0, 0.0);
        
        visit(G, 0);
        
        while (!PQ.isEmpty()) {
            visit(G, PQ.delMin());
        }
        
    }
    
    /**
     * 访问一个顶点（将顶点标记为已访问，将和顶点连接的未失效的边加入队列）
     * @param G
     * @param v
     */
    public void visit(EdgeWeightedGraph G, int v) {
        
        marked[v] = true;
        
        for (Edge e : G.adj(v)) {
            
            int w = e.other(v);
            if (marked[w]) continue;
            
            if (e.getWeighted() < distTo[w]) {
                edgeTo[w] = e;
                distTo[w] = e.getWeighted();
                
                if (PQ.contains(w))
                    PQ.changeKey(w, distTo[w]);
                else
                    PQ.insert(w, distTo[w]);
            }
            
        }
    }
    
    public Edge[] getEdgeTo() {
        return edgeTo;
    }
    
    public boolean[] getMarked() {
        return marked;
    }
    
}
