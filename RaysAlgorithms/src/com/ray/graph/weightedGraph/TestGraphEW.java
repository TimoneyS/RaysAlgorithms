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
        testPrimMinST();
        testLazyPrimMinST();
    }
    
    public static void testPrimMinST() {
        EdgeWeightedGraph G = getDigraph("tinyEWG.txt");
        PrimMinST primMST = new PrimMinST(G);
        Edge[] edgeTo = primMST.getEdgeTo();
        
        for (Edge e : edgeTo) {
            if (e != null)
                Out.p(e.toString());
        }
        
    }
    
    public static void testLazyPrimMinST() {
        EdgeWeightedGraph G = getDigraph("tinyEWG.txt");
        LazyPrimMinST primMST = new LazyPrimMinST(G);
        Edge[] edgeTo = primMST.getEdgeTo();
        
        for (Edge e : edgeTo) {
            if (e != null)
                Out.p(e.toString());
        }
    }
    
    private static EdgeWeightedGraph getDigraph(String fileName) {
        Scanner in = In.getProjectScanner("src/com/ray/graph/weightedGraph/" + fileName);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        Out.p(G);
        return G;
    }
    
}
