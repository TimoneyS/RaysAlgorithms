package com.ray.graph.gwd;

import java.util.Stack;

/**
 * �����Ȩͼ�����·��
 * @author rays1
 *
 */
public abstract class SP {

    protected DirectedEdge[]    edgeTo;
    protected double[]          distTo;
    
    /**
     * �ߵ��ɳ�
     * @param e
     */
    protected void relax(DirectedEdge e) {
        int v = e.from(), w = e.to();                       // �ߵ������յ�
        if (distTo[w] > distTo[v] + e.weighted()) {         // ���������� w �ľ��룬�ȴӸñ���㵽 w ҪԶ
            edgeTo[w] = e;                                  // ���� w �ı�����Ϊ�ñ�
            distTo[w] = distTo[v] + e.weighted();           // ���� w �ľ�����Ϊ�Ӹñߵ� w �ľ���
        }
    }
    
    /**
     * �ɳڶ��� �����ɳںͶ������ӵ����еıߣ�
     * @param G
     * @param v
     */
    protected void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weighted()) {
                distTo[w] = distTo[v] + e.weighted();
                edgeTo[w] = e;
            }
        }
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Stack<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for (DirectedEdge e = edgeTo[v]; e !=null; e = edgeTo[e.from()])
            path.push(e);
        
        return path;
    }

    
}
