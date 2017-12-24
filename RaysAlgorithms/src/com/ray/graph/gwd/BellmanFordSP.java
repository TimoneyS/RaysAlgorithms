package com.ray.graph.gwd;

/**
 * BellmanFord算法<br/>
 * 在任意含有V个顶点的加权有向图中给定起点s，
 * 从s无法到达任何负权重环，则算法如下：<br/><br/>
 * 将distTo[s]初始化为0，其他distTo[]元素初始化为正无穷<br/>
 * 以任意顺序放松有向图的所有边，重复V轮。
 * 
 * @author rays1
 *
 */
public class BellmanFordSP extends SP {

    public BellmanFordSP(EdgeWeightedDigraph G, int s) {
        
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        
        distTo[0] = 0;
        search(G, s);
    }
    
    private void search(EdgeWeightedDigraph G, int s) {
        
        for (int pass = 0; pass < G.V(); pass ++) {
            for (DirectedEdge e : G.edges()) {
                relax(e);
            }
        }
        
    }
    
}
