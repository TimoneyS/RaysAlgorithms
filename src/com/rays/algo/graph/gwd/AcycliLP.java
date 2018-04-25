package com.rays.algo.graph.gwd;

import java.util.Stack;

import com.rays.algo.graph.DirectedEdge;
import com.rays.algo.graph.EdgeWeightedDigraph;
import com.rays.algo.graph.g.DiTopoLogical;

/**
 * �޻���Ȩ����ͼ�·����������<br>
 * �·�������·������˼��һ�¡�<br>
 * ��֮ͬ�����ڣ���ʼ��ʱ�ߵľ���Ϊ������ڷ���ʱȡ��Զ�ı�
 * @author rays1
 * 
 */
public class AcycliLP extends SP {
    
    public AcycliLP(EdgeWeightedDigraph G, int S) {
        
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        
        for (int i=0; i< G.V(); i ++)
            distTo[i] = Double.NEGATIVE_INFINITY;

        distTo[S] = 0.0;
        
        DiTopoLogical topo = new DiTopoLogical(G);
        Stack<Integer> stack = topo.order();
        while (!stack.empty()) {
            for (DirectedEdge e : G.adj(stack.pop()))
                relax(e);
        }
    }
    
    /**
     * ���ɱߣ������·���ķ����෴���˴���ȡ�ϳ��ı�
     * @param e
     */
    protected void relax(DirectedEdge e) {
        int v = e.from(), w = e.to();                       // �ߵ������յ�
        if (distTo[w] < distTo[v] + e.weighted()) {         // �Ӹñ���㵽 w �ľ��룬�ȴ��������� w ҪԶ
            edgeTo[w] = e;                                  // ���� w �ı�����Ϊ�ñ�
            distTo[w] = distTo[v] + e.weighted();           // ���� w �ľ�����Ϊ�Ӹñߵ� w �ľ���
        }
    }

    public boolean hasPathTo(int v) {
        return distTo[v] > Double.NEGATIVE_INFINITY;
    }
    
}
