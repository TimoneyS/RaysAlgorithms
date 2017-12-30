package com.ray.graph.gwd;

import java.util.Scanner;
import java.util.Stack;

import com.ray.common.utils.In;
import com.ray.common.utils.Out;
import com.ray.common.utils.Timer;
/**
 * 测试无向图
 * @author rays1
 *
 */
public class TestGraphEWD {
    
    public static void main(String[] args) {
        testDijkstraSP();
    }
    
    /**
     * Bellman-Ford算法
     */
    public static void testBellmanFord() {
        EdgeWeightedDigraph G = getDigraph("tinyEWDn.txt");
        int s = 0;
        SP sp = new BellmanFordSP(G, s);
        printSP(sp, G, s);
    }
    
    public static void testCPM() {
        Scanner in = In.getClassPathScanner("com/ray/graph/gwd/CPM.txt");
        
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
        SP sp = new AcycliLP(G, s);
        printSP(sp, G, s);
        
    }
    
    /**
     * 无环有向图，最短路径
     */
    public static void testAcycliSP() {
        EdgeWeightedDigraph G = getDigraph("tinyEWDAG.txt");
        int s = 3;
        SP sp = new AcycliSP(G, s);
        printSP(sp, G, s);
        
    }
    
    /**
     * Dijkstra 算法 最短路径
     */
    public static void testDijkstraSP() {
        EdgeWeightedDigraph G = getDigraph("mediumEWG.txt");
        int s = 0;
        DijkstraSP sp = new DijkstraSP(G, s);
        printSP(sp, G, s);
    }
    
    private static void printSP(SP sp, EdgeWeightedDigraph G, int s) {
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
