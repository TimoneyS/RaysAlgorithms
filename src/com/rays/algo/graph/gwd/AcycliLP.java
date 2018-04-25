package com.rays.algo.graph.gwd;

import java.util.Stack;

import com.rays.algo.graph.DirectedEdge;
import com.rays.algo.graph.EdgeWeightedDigraph;
import com.rays.algo.graph.g.DiTopoLogical;

/**
 * 无环加权有向图最长路径搜索方法<br>
 * 最长路径和最短路径搜索思想一致。<br>
 * 不同之处在于，初始化时边的距离为负无穷，在放松时取更远的边
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
     * 放松边，和最短路径的放松相反，此处是取较长的边
     * @param e
     */
    protected void relax(DirectedEdge e) {
        int v = e.from(), w = e.to();                       // 边的起点和终点
        if (distTo[w] < distTo[v] + e.weighted()) {         // 从该边起点到 w 的距离，比从生成树到 w 要远
            edgeTo[w] = e;                                  // 将到 w 的边设置为该边
            distTo[w] = distTo[v] + e.weighted();           // 将到 w 的距离设为从该边到 w 的距离
        }
    }

    public boolean hasPathTo(int v) {
        return distTo[v] > Double.NEGATIVE_INFINITY;
    }
    
}
