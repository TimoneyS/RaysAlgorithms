package com.rays.algo.graph.gw;

import java.util.Arrays;

import com.ray.common.collections.MinPQ;
import com.ray.common.collections.RaysMinPQ;
import com.rays.algo.graph.Edge;
import com.rays.algo.graph.EdgeWeightedGraph;

/**
 * Prim算法
 * 
 * @author rays1
 *
 */
public class PrimMinSTNew implements MinST{
    
    private Edge[]             edgeTo;  // 从生成树到某个顶点的路径
    private boolean[]          marked;
    private MinPQ<Edge> PQ;
    private double weight;
    
    public PrimMinSTNew(EdgeWeightedGraph G) {
        
        PQ = new RaysMinPQ<Edge>(G.V());
        edgeTo = new Edge[G.V()];
        marked = new boolean[G.V()];
        weight = 0;
        
        int s = 0;
        marked[s] = true;
        for (Edge e : G.adj(s)) {
            PQ.insert(e);
        }
        
        while (!PQ.isEmpty()) {
            
            Edge e = PQ.delMin();
            int v = e.either();
            
            if (marked[v]) v = e.other(v);  // 寻找终点
            if (marked[v]) continue;        // 两个子节点都包含在树中，说明是废弃的边
      
            edgeTo[v] = e;
            weight += e.getWeighted();
            marked[v] = true;
            
            for (Edge e1 : G.adj(v)) {
                int w = e1.other(v);
                if (marked[w]) continue;
                if (!PQ.contains(e1))
                    PQ.insert(e1);
            }

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
