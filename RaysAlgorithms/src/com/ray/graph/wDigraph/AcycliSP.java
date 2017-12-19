package com.ray.graph.wDigraph;

import java.util.Stack;

import com.ray.graph.digraph.TopoLogical;
import com.ray.utils.collections.RaysStack;

/**
 * 无环加权有向图最短路径搜索方法<br>
 * 按照拓扑排序放松顶点，每个先放松的顶点都只会被放松一次<br>
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
     * 放松一条边
     * @param e
     */
    private void relax(DirectedEdge e) {
        int v = e.from(), w = e.to();                       // 边的起点和终点
        if (distTo[w] > distTo[v] + e.weighted()) {         // 从生成树到 w 的距离，比从该边起点到 w 要远
            edgeTo[w] = e;                                  // 将到 w 的边设置为该边
            distTo[w] = distTo[v] + e.weighted();           // 将到 w 的距离设为从该边到 w 的距离
        }
    }
    
    double distTo(int v) {
        return distTo[v];
    }

    boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }
    
    RaysStack<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v))
            return null;

        RaysStack<DirectedEdge> path = new RaysStack<DirectedEdge>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
            path.push(e);

        return path;
    }
    
}
