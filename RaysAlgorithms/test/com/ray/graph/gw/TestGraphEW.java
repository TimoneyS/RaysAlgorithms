package com.ray.graph.gw;

import java.util.Scanner;

import com.ray.graph.gw.Edge;
import com.ray.graph.gw.EdgeWeightedGraph;
import com.ray.graph.gw.LazyPrimMinST;
import com.ray.graph.gw.PrimMinST;
import com.ray.utils.In;
import com.ray.utils.Out;

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
