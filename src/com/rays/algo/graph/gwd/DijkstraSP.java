package com.rays.algo.graph.gwd;

import com.ray.util.collections.RaysIndexMinPQ;
import com.rays.algo.graph.DirectedEdge;
import com.rays.algo.graph.EdgeWeightedDigraph;

/**
 * 
 * Dijkstra�㷨<br/>
 * �����Ȩͼ�����·��������<br/>
 * 
 * @author rays1
 *
 */
public class DijkstraSP extends SP {

    private RaysIndexMinPQ<Double>  pq;

    public DijkstraSP(EdgeWeightedDigraph G, int S) {
        
        pq  = new RaysIndexMinPQ<Double>(G.V());
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        
        for (int i = 0; i < distTo.length; i ++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        
        distTo[S] = 0;                                      // ��ʼ�����
        pq.insert(S, 0d);                                   // ��ʼ�����
        
        while (!pq.isEmpty()) {
            relax(G, pq.delMin());                          // ���ɾ���������Ķ���
        }
        
    }
    
    @Override
    protected void relax(EdgeWeightedDigraph G, int v) {
        
        for (DirectedEdge e : G.adj(v)) {
            
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weighted()) {     // ����Ӹö��㵽���ڽӵ����
                distTo[w] = distTo[v] + e.weighted();       // �����ڽӵ�
                edgeTo[w] = e;                              // �����ڽӵ��·����Ϊ�õ�

                // �����������ı߲�����л��߸���
                if (pq.contains(w))
                    pq.changeKey(w, distTo[w]);
                else
                    pq.insert(w, distTo[w]);
            }
            
        }
        
    }

}
