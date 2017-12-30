package com.rays.algo.graph.gw;

import java.util.Scanner;

import com.ray.common.utils.In;
import com.ray.common.utils.Out;
import com.rays.algo.graph.gw.Edge;
import com.rays.algo.graph.gw.EdgeWeightedGraph;
import com.rays.algo.graph.gw.LazyPrimMinST;
import com.rays.algo.graph.gw.PrimMinST;

/**
 * ≤‚ ‘ŒﬁœÚÕº
 * @author rays1
 *
 */
public class TestGraphEW {
    
    public static void main(String[] args) {
    }
    
    public static void testPrimMinST() {
        EdgeWeightedGraph G = getGraph("tinyEWG.txt");
        PrimMinST primMST = new PrimMinST(G);
        Edge[] edgeTo = primMST.getEdgeTo();
        
        for (Edge e : edgeTo) {
            if (e != null)
                Out.p(e.toString());
        }
        
    }
    
    public static void testLazyPrimMinST() {
        EdgeWeightedGraph G = getGraph("tinyEWG.txt");
        LazyPrimMinST primMST = new LazyPrimMinST(G);
        Edge[] edgeTo = primMST.getEdgeTo();
        
        for (Edge e : edgeTo) {
            if (e != null)
                Out.p(e.toString());
        }
    }
    
    private static EdgeWeightedGraph getGraph(String fileName) {
        Scanner in = In.getProjectScanner("src/com/ray/graph/weightedGraph/" + fileName);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        Out.p(G);
        return G;
    }
    
}
