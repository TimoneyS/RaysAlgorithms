package com.rays.algo.graph.gw;

import java.util.Arrays;

import com.ray.common.collections.MinPQ;
import com.ray.common.collections.RaysMinPQ;
import com.rays.algo.graph.Edge;
import com.rays.algo.graph.EdgeWeightedGraph;

/**
 * 延迟删除废弃的边的Prim算法
 * 
 * 
 * @author rays1
 *
 */
public class PrimMinSTLazy implements MinST {
    
    private boolean[]        marked;
    private Edge[]           edgeTo;
    private MinPQ<Edge>      PQ;
    private double weight;
    
    public PrimMinSTLazy(EdgeWeightedGraph G) {
        
        PQ = new RaysMinPQ<Edge>(G.E());
        edgeTo = new Edge[G.V()];
        marked = new boolean[G.V()];
        
        visit(G, 0);
        
        while (!PQ.isEmpty()) {
            
            Edge edge = PQ.delMin();
            
            int v = edge.either();
            if (marked[v]) {
                v = edge.other(v);
                if (marked[v]) continue;
            }
            
            edgeTo[v] = edge;
            visit(G, v);
            
        }
        
        // 计算生成树权重
        weight = 0;
        for (Edge edge : edgeTo) {
            if (edge!= null)
                weight +=  edge.getWeighted();
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
            if (marked[e.other(v)]) continue;   // 失效的边
            PQ.insert(e);
        }
    }

    @Override
    public Iterable<Edge> edges() {
        return Arrays.asList(edgeTo);
    }

    @Override
    public double weight() {
        return weight;
    }
    
}
