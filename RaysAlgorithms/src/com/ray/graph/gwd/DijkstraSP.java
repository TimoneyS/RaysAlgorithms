package com.ray.graph.gwd;

import com.ray.common.utils.collections.IndexMinPQ;

/**
 * Dijkstra�㷨<br/>
 * �����Ȩͼ�����·��������<br/>
 * ��v�Ǵ����ɴ�ģ������� v -> w �ı߶�ֻ�ᱻ����һ�Ρ�<br/>
 * ��v������ʱ������ distTo[v] <= distTo[w] + e.weight��<br/>
 * distTo[w] ��ֵֻ���С����distTo[v]��ֵ����䡣<br/>
 * ���������s�ɴ�Ķ��������ӵ����к����·��������������������<br/>
 * <br/>
 * ע�����ڶ����ڱ����ɺ󣬻�������һ�μ�����С�<br/>
 * ���Ա��㷨ʵ��ʵ����Ҳ�ܴ���Ȩ�صıߣ�������������¼��˵��������ܵ����㷨ʱ�临�Ӷȴﵽָ������
 * @author rays1
 *
 */
public class DijkstraSP extends SP {

    private IndexMinPQ<Double>  pq;

    public DijkstraSP(EdgeWeightedDigraph G, int S) {
        
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        for (int i = 0; i < distTo.length; i ++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        pq  = new IndexMinPQ<Double>(G.V());
        search(G, S);
    }
    
    private void search(EdgeWeightedDigraph G,int S) {
        
        distTo[S] = 0;                                      // ��ʼ�����
        pq.insert(S, 0d);                                   // ��ʼ�����
        
        while (!pq.isEmpty()) {
            int min = pq.delMin();                                          // ��ȡ����������Ķ���
            for (DirectedEdge e : G.adj(min)) {
                int w = e.to();
                if (distTo[w] > distTo[min] + e.weighted()) {               // ����Ӹö��㵽���ڽӵ����
                    distTo[w] = distTo[min] + e.weighted();                 // �����ڽӵ�
                    edgeTo[w] = e;                                          // �����ڽӵ��·����Ϊ�õ�
                    
                    if (pq.contains(w)) pq.changeKey(w, distTo[w]);         // �ڽӵ��·�����ˣ� �ڽӵ���ڽӵ�ҲҪ�������˼������
                    else                pq.insert(w,  distTo[w]);
                }
            }
            
        }
        
    }

}
