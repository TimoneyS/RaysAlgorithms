package com.rays.algo.graph.gw;

import java.util.Scanner;

import com.ray.util.io.In;
import com.ray.util.io.Out;
import com.rays.algo.graph.Edge;
import com.rays.algo.graph.EdgeWeightedGraph;
import com.rays.algo.graph.gw.LazyPrimMinST;
import com.rays.algo.graph.gw.PrimMinST;

/**
 * ��������ͼ
 * @author rays1
 *
 */
public class TestGraphEW {
    
    public static void main(String[] args) {
        testPrimMinST();
    }
    
    public static void testPrimMinST() {
        
        EdgeWeightedGraph G = getGraph("primMST.txt");
        PrimMinST primMST = new PrimMinST(G);
        
        for (Edge e : primMST.edges()) {
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
        Scanner in = In.getClassPathScanner(TestGraphEW.class, fileName);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        Out.p(G);
        return G;
    }
    
}
