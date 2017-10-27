package com.ray.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

import com.ray.graph.intf.Paths;
import com.ray.utils.In;
import com.ray.utils.Out;

/**
 * ��������ͼ
 * @author rays1
 *
 */
public class TestGraph {
    
	public static void main(String[] args) {
	    initGraph("com/ray/graph/graphTiny.txt");
//        testDeepFirstPaths();
//        testBreadthFirstPaths();
	    
//	    initGraph("graphCC.txt");
//	    testCC();
	    
//	    testSymbolGraph();
	
//	    testSGBFS();
	}
	
	/**
	 * ���Է���ͼ�����������
	 */
	public static void testSGBFS() {
	    String s = "С��";
	    String e = "С��";
	    
	    String res = "src/com/ray/graph/graphSymbol.txt";
        String deli = " ";
        SymbolGraph g = new SymbolGraph( res, deli);
	    
	    BreadthFirstPaths bfp = new BreadthFirstPaths(g.G(), g.index(s));
	    
	    LinkedList<Integer> l = bfp.pathTo(g.index(e));
	    
	    while (!l.isEmpty()) {
	        Out.pt(g.name(l.pop()) + " ");
	    }
	}
	
	/**
	 * ���Է���ͼ
	 */
	public static void testSymbolGraph() {
	    String res = "src/com/ray/graph/graphSymbol.txt";
	    String deli = " ";
	    SymbolGraph g = new SymbolGraph( res, deli);
	    Out.p(g.G());
	}
	
	/**
	 * ���Ի�ȡ��ͨ����
	 */
	public static void testCC() {
	    CC cc = new CC(G);
	    Out.p("cc done");
	    Out.p(cc.getCount());
	    Out.p(Arrays.toString(cc.getId()));
	}
	
    /**
     * ���������������
     */
    public static void testDeepFirstPaths() {
        testPaths(new DeepFirstPaths(G, 0));
    }
    
    /**
     * ���Թ����������
     */
    public static void testBreadthFirstPaths() {
        testPaths(new BreadthFirstPaths(G, 0));
    }
    
    /**
     * ͨ�÷���
     * @param s
     */
    public static void testPaths(Paths s) {
        for (int i = 0; i < G.V(); i++) {
            if (s.hasPathTo(i)) {
                Out.pt("0 -> " + i + " : ");
                
                LinkedList<Integer> st = s.pathTo(i);
                while (!st.isEmpty())
                    Out.pt(st.pop() + " ");
                Out.p("");
            }
        }
    }
    
    public static void initGraph(String fileName) {
        Scanner in = In.getClassPathScanner(fileName);
        G = new Graph(in);
        Out.p(G);
    }
    private static Graph G;
    
}
