package com.ray.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import com.ray.graph.intf.Paths;
import com.ray.utils.StdOut;

public class Test {
    
	public static void main(String[] args) {
        initGraph("tinyG.txt");
        testDeepFirstPaths();
        testBreadthFirstPaths();
	}
	
	private static Graph G;
    
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
                StdOut.pt("0 -> " + i + " : ");
                
                LinkedList<Integer> st = s.pathTo(i);
                while (!st.isEmpty())
                    StdOut.pt(st.pop() + " ");
                StdOut.p("");
            }
        }
    }
    
    public static void initGraph(String fileName) {
        String filePath = "src/com/ray/graph/" + fileName;
        Scanner in = null;
        try {
            in = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        G = new Graph(in);
        StdOut.p(G);
    }
	
}
