package com.rays.algo.graph.gw;

import java.util.Arrays;

import com.ray.common.collections.RaysIndexMinPQ;
import com.rays.algo.graph.Edge;
import com.rays.algo.graph.EdgeWeightedGraph;

/**
 * Prim 即时算法
 * 
 * 在添加边到队列时，对于每个顶点只会保存其和树连接的所有边中权重最小的一条
 * 
 * @author rays1
 *
 */
public class PrimMinST implements MinST {
    
    private Edge[]                 edgeTo; // 从生成树到某个顶点的路径
    private RaysIndexMinPQ<Double> PQ;     // 保存最小权重的边的索引
    private boolean[]              marked; // 标记顶点是否已经在树种
    private double                 weight;

    public PrimMinST(EdgeWeightedGraph G) {
        
        PQ = new RaysIndexMinPQ<Double>(G.V());
        edgeTo = new Edge[G.V()];
        marked = new boolean[G.V()];
        PQ.insert(0, 0.0);

        while (!PQ.isEmpty()) {
            visit(G, PQ.delMin());
        }
        
        // 计算生成树权重
        weight = 0;
        for (Edge edge : edgeTo) {
            if (edge!= null)
                weight +=  edge.getWeighted();
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
            
            if (marked[w]) {
                continue;    // 废弃的边
            }
            
            if (PQ.contains(w)) {
                
                if (e.getWeighted() < PQ.keyOf(w)) {
                    edgeTo[w] = e;
                    PQ.changeKey(w, e.getWeighted());
                }
            } else {
                edgeTo[w] = e;
                PQ.insert(w, e.getWeighted());
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
