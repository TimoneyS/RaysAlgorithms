package com.rays.algo.graph.gwd;

import java.util.Stack;

import com.rays.algo.graph.DirectedEdge;
import com.rays.algo.graph.EdgeWeightedDigraph;
import com.rays.algo.graph.g.DiTopoLogical;

/**
 * �޻���Ȩ����ͼ���·����������<br>
 * ��������������ɶ��㣬ÿ���ȷ��ɵĶ��㶼ֻ�ᱻ����һ��<br>
 * @author rays1
 * 
 */
public class AcycliSP extends SP {
    
    public AcycliSP(EdgeWeightedDigraph G, int S) {

        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        
        for (int i=0; i< G.V(); i ++)
            distTo[i] = Double.POSITIVE_INFINITY;

        distTo[S] = 0.0;
        
        DiTopoLogical topo = new DiTopoLogical(G);
        Stack<Integer> stack = topo.order();
        
        while (!stack.empty()) {
            for (DirectedEdge e : G.adj(stack.pop()))
                relax(e);
        }

    }
    
}
