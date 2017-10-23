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
	 * ���Է���ͼ�����������
	 */
	public static void testSGBFS() {
	    String s = "С��";
	    String e = "С��";
	    
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
	 * ���Է���ͼ
	 */
	public static void testSymbolGraph() {
	    String res = "src/com/ray/graph/symbolG.txt";
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
