package com.ray.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

import com.ray.graph.intf.Paths;
import com.ray.utils.Out;

public class Test {
    
	public static void main(String[] args) {
//        initGraph("tinyG.txt");
//        testDeepFirstPaths();
//        testBreadthFirstPaths();
	    
//	    initGraph("ccG.txt");
//	    testCC();
	    
//	    testSymbolGraph();
	
	    testSGBFS();
	}
	
	/**
	 * 测试符号图广度优先搜索
	 */
	public static void testSGBFS() {
	    String s = "小红";
	    String e = "小花";
	    
	    String res = "src/com/ray/graph/symbolG.txt";
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
	    String res = "src/com/ray/graph/symbolG.txt";
	    String deli = " ";
	    SymbolGraph g = new SymbolGraph( res, deli);
	    Out.p(g.G());
	}
	
	/**
	 * 测试获取连通分量
	 */
	public static void testCC() {
	    CC cc = new CC(G);
	    Out.p("cc done");
	    Out.p(cc.getCount());
	    Out.p(Arrays.toString(cc.getId()));
	}
	
    /**
     * 测试深度优先搜索
     */
    public static void testDeepFirstPaths() {
        testPaths(new DeepFirstPaths(G, 0));
    }
    
    /**
     * 测试广度优先搜索
     */
    public static void testBreadthFirstPaths() {
        testPaths(new BreadthFirstPaths(G, 0));
    }
    
    /**
     * 通用方法
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
        Scanner in = getScanner(fileName);
        G = new Graph(in);
        Out.p(G);
    }
    
    private static Scanner getScanner(String fileName) {
        String filePath = "src/com/ray/graph/" + fileName;
        Scanner in = null;
        try {
            in = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return in;
    }
	
    private static Graph G;
    
}
