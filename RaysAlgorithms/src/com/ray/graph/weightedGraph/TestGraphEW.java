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
        testDijkstraSP();
    }
    
    public static void testDijkstraSP() {
        EdgeWeightedDigraph G = getDigraph("tinyEWG.txt");
        DijkstraSP sp = new DijkstraSP(G);
        
        for (int i = 0 ; i < G.V(); i ++) {
            Out.p("Path to " + i + " : ");
            if (sp.hasPathTo(i)) {
                for (DirectedEdge e : sp.pathTo(i))
                    Out.pf("%s -> %s\n", e.from(), e.to());
            } else {
                Out.p("no path");
            }
        }
        
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
    
    private static EdgeWeightedDigraph getDigraph(String fileName) {
        Scanner in = In.getProjectScanner("src/com/ray/graph/weightedGraph/" + fileName);
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
        Out.p(G);
        return G;
    }
    
}
