package com.ray.algo.graph.g;

import java.util.Stack;

import com.ray.algo.graph.DirectedEdge;
import com.ray.algo.graph.EdgeWeightedDigraph;

/**
 * 无环加权有向图最短路径搜索方法<br>
 * 按照拓扑排序放松顶点，每个先放松的顶点都只会被放松一次<br>
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
        
        while (!stack.empty())
            relax(G, stack.pop());

    }
    
}
