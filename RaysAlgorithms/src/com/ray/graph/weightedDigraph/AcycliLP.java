package com.ray.graph.weightedDigraph;

import com.ray.utils.collections.RaysStack;

/**
 * 无环加权有向图最长路径搜索方法<br>
 * 复制一张新的图，将图的所有路径的权设为原来的负值，然后对其进行最短路径搜索。
 * @author rays1
 * 
 */
public class AcycliLP {
    
    AcycliSP acycliSP;
    
    public AcycliLP(EdgeWeightedDigraph G, int S) {
        
        
    }
    
    double distTo(int v) {
        return 1;
    }

    boolean hasPathTo(int v) {
        return false;
    }
    
    RaysStack<DirectedEdge> pathTo(int v) {
        return null;
    }
    
}
