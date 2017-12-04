package com.ray.graph.weightedDigraph;

import java.util.Stack;

import com.ray.utils.collections.IndexMinPQ;

/**
 * Dijkstra�㷨
 * �����Ȩͼ�����·��������
 * @author rays1
 *
 */
public class DijkstraSP {

    private DirectedEdge[]      edgeTo;
    private double[]            distTo;
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

    double distTo(int v) {
        return distTo[v];
    }

    boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v))
            return null;

        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
            path.push(e);

        return path;
    }

    /**
     * �ߵ��ɳ�
     * 
     * @param e
     */
    @SuppressWarnings("unused")
    private void realx(DirectedEdge e) {
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.weighted()) {
            distTo[w] = distTo[v] + e.weighted();
            edgeTo[w] = e;
        }
    }

    /**
     * �ɳڶ��� �����ɳںͶ������ӵ����еıߣ�
     * 
     * @param G
     * @param v
     */
    @SuppressWarnings("unused")
    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weighted()) {
                distTo[w] = distTo[v] + e.weighted();
                edgeTo[w] = e;
            }
        }
    }

}
