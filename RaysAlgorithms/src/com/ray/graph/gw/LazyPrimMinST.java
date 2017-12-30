package com.ray.graph.gw;

import com.ray.common.utils.collections.MinPQ;

/**
 * �ӳ�ɾ�������ıߵ�Prim�㷨
 * @author rays1
 *
 */
public class LazyPrimMinST {
    private boolean[]        marked;
    private Edge             edgeTo[];
    private MinPQ<Edge> PQ;
    
    public LazyPrimMinST(EdgeWeightedGraph G) {
        PQ = new MinPQ<Edge>(G.E());
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
     * ����һ�����㣨��������Ϊ�Է��ʣ����Ͷ������ӵ�δʧЧ�ı߼�����У�
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
