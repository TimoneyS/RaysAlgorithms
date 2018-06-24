package com.rays.algo.graph.gw;

import java.util.Arrays;

import com.ray.common.collections.RaysIndexMinPQ;
import com.rays.algo.graph.Edge;
import com.rays.algo.graph.EdgeWeightedGraph;

/**
 * Prim ��ʱ�㷨
 * 
 * ����ӱߵ�����ʱ������ÿ������ֻ�ᱣ����������ӵ����б���Ȩ����С��һ��
 * 
 * @author rays1
 *
 */
public class PrimMinST implements MinST {
    
    private Edge[]                 edgeTo; // ����������ĳ�������·��
    private RaysIndexMinPQ<Double> PQ;     // ������СȨ�صıߵ�����
    private boolean[]              marked; // ��Ƕ����Ƿ��Ѿ�������
    private double                 weight;

    public PrimMinST(EdgeWeightedGraph G) {
        
        PQ = new RaysIndexMinPQ<Double>(G.V());
        edgeTo = new Edge[G.V()];
        marked = new boolean[G.V()];
        PQ.insert(0, 0.0);

        while (!PQ.isEmpty()) {
            visit(G, PQ.delMin());
        }
        
        // ����������Ȩ��
        weight = 0;
        for (Edge edge : edgeTo) {
            if (edge!= null)
                weight +=  edge.getWeighted();
        }
        
    }
    
    /**
     * ����һ�����㣨��������Ϊ�ѷ��ʣ����Ͷ������ӵ�δʧЧ�ı߼�����У�
     * @param G
     * @param v
     */
    public void visit(EdgeWeightedGraph G, int v) {
        
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            
            int w = e.other(v);
            
            if (marked[w]) {
                continue;    // �����ı�
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
