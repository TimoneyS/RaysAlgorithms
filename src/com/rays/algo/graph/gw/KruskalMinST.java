package com.rays.algo.graph.gw;

import java.util.ArrayDeque;
import java.util.Queue;

import com.rays.algo.graph.Edge;
import com.rays.algo.graph.EdgeWeightedGraph;

public class KruskalMinST {
    
    @SuppressWarnings("unused")
    private Queue<Edge> mst;
    
    public KruskalMinST(EdgeWeightedGraph G) {
        mst = new ArrayDeque<Edge>();
    }
    
}
