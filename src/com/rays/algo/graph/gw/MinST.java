package com.rays.algo.graph.gw;

import com.rays.algo.graph.Edge;

/**
 * 加权图的最小生成树
 * @author rays1
 * 含有所有顶点的，边的权值和最小的，无环连通子图
 */
public interface MinST {
    
    Iterable<Edge> edges();
    double weight();
    
}
