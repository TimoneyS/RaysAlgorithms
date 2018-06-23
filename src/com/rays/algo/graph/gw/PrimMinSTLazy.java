package com.rays.algo.graph.gw;

import java.util.Arrays;

import com.ray.common.collections.MinPQ;
import com.ray.common.collections.RaysMinPQ;
import com.rays.algo.graph.Edge;
import com.rays.algo.graph.EdgeWeightedGraph;

/**
 * �ӳ�ɾ�������ıߵ�Prim�㷨
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
        
        // ����������Ȩ��
        weight = 0;
        for (Edge edge : edgeTo) {
            if (edge!= null)
                weight +=  edge.getWeighted();
        }
        
    }
    
    /**
     * ����һ�����㣨��������Ϊ�Է��ʣ����Ͷ������ӵ�δʧЧ�ı߼�����У�
     * @param G
     * @param v
     */
    public void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            if (marked[e.other(v)]) continue;   // ʧЧ�ı�
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
