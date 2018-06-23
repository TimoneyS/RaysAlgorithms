package com.rays.algo.graph.g;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

import com.ray.util.io.In;
import com.ray.util.io.Out;
import com.rays.algo.graph.Graph;
import com.rays.algo.graph.Paths;
import com.rays.algo.graph.SymbolGraph;
import com.rays.algo.graph.g.BreadthFirstPaths;
import com.rays.algo.graph.g.CC;
import com.rays.algo.graph.g.DeepthFirstPaths;

/**
 * ��������ͼ
 * @author rays1
 *
 */
public class TestGraph {
    
	public static void main(String[] args) {
	    testCC();
	}
	
	/**
	 * ���Է���ͼ�����������
	 */
	public static void testSymbolGraphBFS() {
	    String s = "С��";
	    String e = "С��";
	    
	    String res = "test/com/rays/algo/graph/g/graphSymbol.txt";
        String deli = "  ";
        SymbolGraph g = new SymbolGraph( res, deli);
	    
	    BreadthFirstPaths bfp = new BreadthFirstPaths(g.G(), g.index(s));
	    
	    Stack<Integer> l = bfp.pathTo(g.index(e));
	    
	    while (!l.isEmpty()) {
	        Out.pt(g.name(l.pop()) + " ");
	    }
	}
	
	/**
	 * ���Ի�ȡ��ͨ����
	 */
	public static void testCC() {
	    Graph G = initGraph("graphCC.txt");
	    
	    CC cc = new CC(G);
	    Out.p("cc done");
	    Out.p(cc.getCount());
	    Out.p(Arrays.toString(cc.getId()));
	}
	
    /**
     * ���������������
     */
    public static void testDeepFirstPaths() {
        Graph G = initGraph("graphTiny.txt");
        testPaths(G, new DeepthFirstPaths(G, 0));
    }
    
    /**
     * ���Թ����������
     */
    public static void testBreadthFirstPaths() {
        Graph G = initGraph("graphTiny.txt");
        testPaths(G, new BreadthFirstPaths(G, 0));
    }
    
    /**
     * ͨ�÷���
     * @param s
     */
    private static void testPaths(Graph G, Paths s) {
        
        for (int i = 0; i < G.V(); i++) {
            if (s.hasPathTo(i)) {
                Out.pt("0 -> " + i + " : ");
                
                Stack<Integer> st = s.pathTo(i);
                while (!st.isEmpty())
                    Out.pt(st.pop() + " ");
                Out.p("");
            }
        }
    }
    
    private static Graph initGraph(String fileName) {
        Scanner in = In.getClassPathScanner(TestGraph.class ,fileName);
        Graph G = new Graph(in);
        Out.p(G);
        return G;
    }
    
}