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
	    initGraph("digraph.txt");
	    testDiDFP();
	}
	
	/**
	 * 测试有向图的深度优先路径
	 */
	public static void testDiDFP() {
	    int s = 0;
	    int e = 7;
	    
	    DiDFP dfp = new DiDFP(G, s);
	    
	    LinkedList<Integer> list = dfp.pathTo(e);
	    
	    for (int i : list)
	        Out.pt(i + " ");
	}
	
	/**
	 * 初始化图
	 * @param fileName
	 */
    public static void initGraph(String fileName) {
        Scanner in = In.getProjectScanner("src/com/ray/graph/" + fileName);
        G = new Digraph(in);
        Out.p(G);
    }
	
    private static Digraph G;
    
}
