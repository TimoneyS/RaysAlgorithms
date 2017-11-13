package com.ray.graph.weightedGraph;

import java.util.Scanner;

import com.ray.utils.In;
import com.ray.utils.Out;

/**
 * ≤‚ ‘ŒﬁœÚÕº
 * @author rays1
 *
 */
public class TestGraphEW {
    
    public static void main(String[] args) {
        getDigraph("tinyEWG.txt");
    }
    
    public static EdgeWeightedGraph getDigraph(String fileName) {
        Scanner in = In.getProjectScanner("src/com/ray/graph/weightedGraph/" + fileName);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        Out.p(G);
        return G;
    }
    
}
