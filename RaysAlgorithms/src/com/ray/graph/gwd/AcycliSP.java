package com.ray.graph.gwd;

import java.util.Stack;

import com.ray.graph.gd.TopoLogical;

/**
 * �޻���Ȩ����ͼ���·����������<br>
 * ��������������ɶ��㣬ÿ���ȷ��ɵĶ��㶼ֻ�ᱻ����һ��<br>
 * @author rays1
 * 
 */
public class AcycliSP {
    
    private DirectedEdge[]      edgeTo;
    private double[]            distTo;
    
    public AcycliSP(EdgeWeightedDigraph G, int S) {

        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        
        for (int i=0; i< G.V(); i ++)
            distTo[i] = Double.POSITIVE_INFINITY;

        distTo[S] = 0.0;
        
        TopoLogical topo = new TopoLogical(G);
        Stack<Integer> stack = topo.order();
        
        while (!stack.empty()) {
            for (DirectedEdge e : G.adj(stack.pop()))
                relax(e);
        }

    }

    /**
     * ����һ����
     * @param e
     */
    private void relax(DirectedEdge e) {
        int v = e.from(), w = e.to();                       // �ߵ������յ�
        if (distTo[w] > distTo[v] + e.weighted()) {         // ���������� w �ľ��룬�ȴӸñ���㵽 w ҪԶ
            edgeTo[w] = e;                                  // ���� w �ı�����Ϊ�ñ�
            distTo[w] = distTo[v] + e.weighted();           // ���� w �ľ�����Ϊ�Ӹñߵ� w �ľ���
        }
    }
    
    double distTo(int v) {
        return distTo[v];
    }

    boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }
    
    Stack<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v))
            return null;

        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
            path.push(e);

        return path;
    }
    
}
