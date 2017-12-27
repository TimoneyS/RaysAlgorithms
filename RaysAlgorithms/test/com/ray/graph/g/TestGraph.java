package com.ray.graph.g;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

import com.ray.graph.common.Paths;
import com.ray.utils.In;
import com.ray.utils.Out;

/**
 * 测试无向图
 * @author rays1
 *
 */
public class TestGraph {
    
	public static void main(String[] args) {
	    // initGraph("com/ray/graph/graphTiny.txt");
	    testBreadthFirstPaths();
	}
	
	/**
	 * 测试符号图广度优先搜索
	 */
	public static void testSGBFS() {
	    String s = "小红";
	    String e = "小花";
	    
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
	 * 测试符号图
	 */
	public static void testSymbolGraph() {
	    String res = "src/com/ray/graph/graphSymbol.txt";
	    String deli = " ";
	    SymbolGraph g = new SymbolGraph( res, deli);
	    Out.p(g.G());
	}
	
	/**
	 * 测试获取连通分量
	 */
	public static void testCC() {
	    Graph G = initGraph("graphTiny.txt");
	    
	    CC cc = new CC(G);
	    Out.p("cc done");
	    Out.p(cc.getCount());
	    Out.p(Arrays.toString(cc.getId()));
	}
	
    /**
     * 测试深度优先搜索
     */
    public static void testDeepFirstPaths() {
        Graph G = initGraph("graphTiny.txt");
        testPaths(G, new DeepthFirstPaths(G, 0));
    }
    
    /**
     * 测试广度优先搜索
     */
    public static void testBreadthFirstPaths() {
        Graph G = initGraph("graphTiny.txt");
        testPaths(G, new BreadthFirstPaths(G, 0));
    }
    
    /**
     * 通用方法
     * @param s
     */
    private static void testPaths(Graph G, Paths s) {
        
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
    
    private static Graph initGraph(String fileName) {
        Scanner in = In.getClassPathScanner(fileName);
        Graph G = new Graph(in);
        Out.p(G);
        return G;
    }
    
}
