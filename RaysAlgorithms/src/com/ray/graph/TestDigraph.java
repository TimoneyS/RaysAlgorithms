package com.ray.graph;

import java.util.LinkedList;
import java.util.Scanner;

import com.ray.utils.In;
import com.ray.utils.Out;

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
	    
	    DiDFP dfp = new DiDFP(G, s);
	    
	    LinkedList<Integer> list = dfp.pathTo(e);
	    
	    for (int i : list)
	        Out.pt(i + " ");
	}
	
    public static Digraph getDigraph(String fileName) {
        Scanner in = In.getProjectScanner("src/com/ray/graph/" + fileName);
        Digraph G = new Digraph(in);
        Out.p(G);
        return G;
    }
    
}
