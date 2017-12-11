package com.ray.graph.weightedDigraph;

import java.util.Scanner;

import com.ray.utils.In;
import com.ray.utils.Out;
import com.ray.utils.collections.RaysStack;

/**
 * ≤‚ ‘ŒﬁœÚÕº
 * @author rays1
 *
 */
public class TestGraphEWD {
    
    public static void main(String[] args) {
        testAcycliSP();
    }
    
    public static void testAcycliSP() {
        EdgeWeightedDigraph G = getDigraph("tinyEWDAG2.txt");
        int s = 0;
        
        AcycliSP sp = new AcycliSP(G, s);
        
        for (int v = 0 ; v < G.V(); v ++) {
            
            if (sp.hasPathTo(v)) {
                Out.pf("%d to %d (%.2f)  ", s, v, sp.distTo(v));
                RaysStack<DirectedEdge> stack = sp.pathTo(v);
                while (!stack.isEmpty())
                    Out.pt(stack.pop() + "    ");
                Out.p();
            } else {
                Out.pf("%d to %d         no path\n", s, v);
            }
            
        }
        
    }
    
    public static void testDijkstraSP() {
        EdgeWeightedDigraph G = getDigraph("tinyEWD2.txt");
        DijkstraSP sp = new DijkstraSP(G, 0);
        
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
    
    private static EdgeWeightedDigraph getDigraph(String fileName) {
        Scanner in = In.getProjectScanner("src/com/ray/graph/weightedDigraph/" + fileName);
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
        Out.p(G);
        return G;
    }
    
}
