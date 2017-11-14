package com.ray.graph.weightedGraph;

import com.ray.utils.MinPQ;

/**
 * Prim算法
 * @author rays1
 *
 */
public class PrimMinST {
    
    private boolean[]        marked;
    private Edge             edgeTo[];
    private MinPQ<Edge> PQ;
    private int              count;
    
    public PrimMinST(EdgeWeightedGraph G) {
        PQ = new MinPQ<Edge>(G.E());
        edgeTo = new Edge[G.V()];
        marked = new boolean[G.V()];
        
        count = 1;
        visit(G, 0);
        prim(G);
    }
    
    public void prim(EdgeWeightedGraph G) {
        while (!PQ.isEmpty()) {
            Edge edge = PQ.delMin();
            int v = edge.either();
            if (marked[v]) {
                v = edge.other(v);
                if (marked[v])
                    continue;
            }
            
            edgeTo[v] = edge;
            count += 1;
            visit(G, v);
            
        }
    }
    
    /**
     * 访问一个顶点（将顶点标记为以访问，将和顶点连接的未失效的边加入队列）
     * @param G
     * @param v
     */
    public void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            if (!marked[e.other(v)]) {
                PQ.insert(e);
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
