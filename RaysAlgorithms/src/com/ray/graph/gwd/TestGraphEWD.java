package com.ray.graph.gwd;

import java.util.Scanner;

import com.ray.utils.In;
import com.ray.utils.Out;
import com.ray.utils.collections.RaysStack;
import com.ray.utils.collections.Stack;

/**
 * 测试无向图
 * @author rays1
 *
 */
public class TestGraphEWD {
    
    public static void main(String[] args) {
        testDijkstraSP();
    }
    
    
    
    public static void testCPM() {
        Scanner in = In.getClassPathScanner("com/ray/graph/wDigraph/CPM.txt");
        
        CPM cpm = new CPM(in);
        
        Stack<DirectedEdge> stack = cpm.getPath();
        while (!stack.isEmpty()) {
            Out.pf(stack.pop() + "  ");
        }
        
    }
 
    /**
     * 无环有向图，最长路径
     */
    public static void testAcycliLP() {
        EdgeWeightedDigraph G = getDigraph("tinyEWDAG.txt");
        int s = 3;
        
        AcycliLP sp = new AcycliLP(G, s);
        
        for (int v = 0 ; v < G.V(); v ++) {
            if (v == s) continue;
            if (sp.hasPathTo(v)) {
                Out.pf("%d to %d (%.2f)  ", s, v, sp.distTo(v));
                RaysStack<DirectedEdge> stack = sp.pathTo(v);
                while (!stack.isEmpty()) Out.pt(stack.pop() + "    ");
            } else {
                Out.pf("%d to %d         no path", s, v);
            }
            Out.p();
        }
        
    }
    
    /**
     * 无环有向图，最短路径
     */
    public static void testAcycliSP() {
        EdgeWeightedDigraph G = getDigraph("tinyEWDAG.txt");
        int s = 3;
        
        AcycliSP sp = new AcycliSP(G, s);
        
        for (int v = 0 ; v < G.V(); v ++) {
            if (v == s) continue;
            if (sp.hasPathTo(v)) {
                Out.pf("%d to %d (%.2f)  ", s, v, sp.distTo(v));
                RaysStack<DirectedEdge> stack = sp.pathTo(v);
                while (!stack.isEmpty()) Out.pt(stack.pop() + "    ");
            } else {
                Out.pf("%d to %d         no path", s, v);
            }
            Out.p();
        }
        
    }
    
    /**
     * Dijkstra 算法 最短路径
     */
    public static void testDijkstraSP() {
        EdgeWeightedDigraph G = getDigraph("tinyEWD.txt");
        int s = 0;
        
        DijkstraSP sp = new DijkstraSP(G, s);
        
        for (int i = 0 ; i < G.V(); i ++) {
            if (s == i) continue;

            if (sp.hasPathTo(i)) {
                Out.pf("Path to %d(%.2f) : ", i, sp.distTo(i));
                Stack<DirectedEdge> stack  = sp.pathTo(i);
                while (!stack.isEmpty())
                    Out.pt(stack.pop() + "  ");
                Out.p();
            } else {
                Out.p("Path to " + i + " : no path");
            }
        }
        
    }
    
    private static EdgeWeightedDigraph getDigraph(String fileName) {
        Scanner in = In.getProjectScanner("src/com/ray/graph/gwd/" + fileName);
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
        Out.p(G);
        return G;
    }
    
}
