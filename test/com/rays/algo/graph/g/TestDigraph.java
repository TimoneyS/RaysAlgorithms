package com.rays.algo.graph.g;

import java.util.Scanner;
import java.util.Stack;

import com.ray.io.In;
import com.ray.io.Out;
import com.rays.algo.graph.Digraph;
import com.rays.algo.graph.Paths;

/**
 * ��������ͼ
 * @author rays1
 *
 */
public class TestDigraph {
    
	public static void main(String[] args) {
	    testDiDFOrder();
	}
	
	/**
	 * ����ǿ��ͨ����
	 */
	public static void testSCC() {
	    Digraph G = getDigraph("graphCC2.txt");
	    DiSCC scc = new DiSCC(G);
	    
	    for (int i = 0; i < scc.count(); i ++) {
	        Out.pf("��ͨ���� : %d\n[", i);
	        for (int j = 0; j < scc.id().length; j ++) {
	            if (scc.id()[j] == i) Out.pt(" " + j);
	        }
	        Out.p(" ]");
	    }
	        
	}
	
	/**
	 * ������������
	 * @return
	 */
	public static void testDiDFOrder() {
	    Digraph G = getDigraph("digraphTopo.txt");
	    DiTopoLogical topo = new DiTopoLogical(G);
	    
	    while (!topo.order().isEmpty())
	        Out.pt(topo.order().pop() + " -> ");
	    
	}
	
	/**
	 * ��������ͼ��Ѱ�һ�
	 */
	public static void testDiCycle() {
	    Digraph G = getDigraph("digraphCycle.txt");
	    DiCycle diCycle = new DiCycle(G, 0);
	    Out.p( (diCycle.hasCycle() ? "" : "��") + "���ڻ�");
	    
	    while (!diCycle.getCycle().isEmpty())
	        Out.pt(diCycle.getCycle().pop() + " -> ");
	    
	}
	
	 /**
     * ��������ͼ�Ĺ������·��
     */
    public static void testDiBFP() {
        Digraph G = getDigraph("digraph.txt");
        
        int s = 0;
        int e = 6;
        
        Paths dfp = new BreadthFirstPaths(G, s);
        
        Stack<Integer> stack = dfp.pathTo(e);
        
        while (!stack.isEmpty())
            Out.pt(stack.pop() + " ->");
            
    }
	
	/**
	 * ��������ͼ���������·��
	 */
	public static void testDiDFP() {
	    Digraph G = getDigraph("digraph.txt");
	    
	    int s = 0;
	    int e = 6;
	    
	    Paths dfp = new DeepthFirstPaths(G, s);
	    
	    Stack<Integer> stack = dfp.pathTo(e);
	    
	    while (!stack.isEmpty())
	        Out.pt(stack.pop() + " ->");
	        
	}
	
    private static Digraph getDigraph(String fileName) {
        Scanner in = In.getClassPathScanner(TestDigraph.class, fileName);
        Digraph G = new Digraph(in);
        Out.p(G);
        return G;
    }
    
}
