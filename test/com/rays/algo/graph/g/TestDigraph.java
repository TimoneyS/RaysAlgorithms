package com.rays.algo.graph.g;

import java.util.Scanner;
import java.util.Stack;

import com.ray.util.io.In;
import com.ray.util.io.Out;
import com.rays.algo.graph.Digraph;
import com.rays.algo.graph.Paths;

/**
 * 测试有向图
 * @author rays1
 *
 */
public class TestDigraph {
    
	public static void main(String[] args) {
	    testDiCycle();
	}
	
	/**
	 * 测试强连通分量
	 */
	public static void testSCC() {
	    Digraph G = getDigraph("graphCC2.txt");
	    DiSCC scc = new DiSCC(G);
	    
	    for (int i = 0; i < scc.count(); i ++) {
	        Out.pf("连通分量 : %d\n[", i);
	        for (int j = 0; j < scc.id().length; j ++) {
	            if (scc.id()[j] == i) Out.pt(" " + j);
	        }
	        Out.p(" ]");
	    }
	        
	}
	
	/**
	 * 测试拓扑排序
	 * @return
	 */
	public static void testDiDFOrder() {
	    Digraph G = getDigraph("digraphTopo.txt");
	    DiTopoLogical topo = new DiTopoLogical(G);
	    
	    while (!topo.order().isEmpty())
	        Out.pt(topo.order().pop() + " ");
	    
	}
	
	/**
	 * 测试有向图，寻找环
	 */
	public static void testDiCycle() {
	    Digraph G = getDigraph("digraphCycle.txt");
	    DiCycle diCycle = new DiCycle(G, 0);
	    Out.p(diCycle.hasCycle());
	    while (!diCycle.getCycle().isEmpty())
	        Out.pt(diCycle.getCycle().pop() + "  ");
	    
	}
	
	/**
	 * 测试有向图的深度优先路径
	 */
	public static void testDiDFP() {
	    Digraph G = getDigraph("digraph.txt");
	    
	    int s = 0;
	    int e = 7;
	    
	    Paths dfp = new DeepthFirstPaths(G, s);
	    
	    Stack<Integer> list = dfp.pathTo(e);
	    
	    for (int i : list)
	        Out.pt(i + " ");
	}
	
    public static Digraph getDigraph(String fileName) {
        Scanner in = In.getClassPathScanner(TestDigraph.class, fileName);
        Digraph G = new Digraph(in);
        Out.p(G);
        return G;
    }
    
}
