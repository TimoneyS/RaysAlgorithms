package com.rays.algo.graph.gw;

import com.ray.common.collections.MinPQ;
import com.ray.common.collections.RaysMinPQ;

/**
 * 延迟删除废弃的边的Prim算法
 * @author rays1
 *
 */
public class LazyPrimMinST {
    private boolean[]        marked;
    private Edge             edgeTo[];
    private MinPQ<Edge> PQ;
    
    public LazyPrimMinST(EdgeWeightedGraph G) {
        PQ = new RaysMinPQ<Edge>(G.E());
        edgeTo = new Edge[G.V()];
        marked = new boolean[G.V()];
        
        visit(G, 0);
        
        while (!PQ.isEmpty()) {
            Edge edge = PQ.delMin();
            int v = edge.either();
            if (marked[v]) {
                v = edge.other(v);
                if (marked[v])
                    continue;
            }
            
            edgeTo[v] = edge;
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
            if (marked[e.other(v)]) continue;
            PQ.insert(e);
        }
    }
    
    public Edge[] getEdgeTo() {
        return edgeTo;
    }
    
    public boolean[] getMarked() {
        return marked;
    }
}
