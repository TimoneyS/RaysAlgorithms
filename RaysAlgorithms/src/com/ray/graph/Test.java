package com.ray.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

import com.ray.graph.intf.Paths;
import com.ray.utils.StdOut;

public class Test {
    
	public static void main(String[] args) {
//        initGraph("tinyG.txt");
//        testDeepFirstPaths();
//        testBreadthFirstPaths();
        
	    initGraph("ccG.txt");
	    testCC();
	}
	
	public static void testCC() {
	    CC cc = new CC(G);
	    StdOut.p("cc done");
	    StdOut.p(cc.getCount());
	    StdOut.p(Arrays.toString(cc.getId()));
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
	
    private static Graph G;
    
}
