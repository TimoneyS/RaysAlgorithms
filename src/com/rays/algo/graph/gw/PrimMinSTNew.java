package com.rays.algo.graph.gw;

import java.util.Arrays;

import com.ray.common.collections.MinPQ;
import com.ray.common.collections.RaysMinPQ;
import com.rays.algo.graph.Edge;
import com.rays.algo.graph.EdgeWeightedGraph;

/**
 * Prim�㷨
 * 
 * @author rays1
 *
 */
public class PrimMinSTNew implements MinST{
    
    private Edge[]             edgeTo;  // ����������ĳ�������·��
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
            
            if (marked[v]) v = e.other(v);  // Ѱ���յ�
            if (marked[v]) continue;        // �����ӽڵ㶼���������У�˵���Ƿ����ı�
      
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
