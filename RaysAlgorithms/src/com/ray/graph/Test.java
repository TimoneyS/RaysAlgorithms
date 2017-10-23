package com.ray.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.ray.utils.StdOut;

public class Test {
    
	public static void main(String[] args) {
        String fileName = "tinyG.txt";
        initGraph(fileName);
        testDeepFirstPaths();
	}
	
	static Graph G;
    
    /**
     * 测试深度优先搜索
     */
    public static void testDeepFirstPaths() {
        DeepFirstPaths s = new DeepFirstPaths(G, 0);
        StdOut.p(G);
        for (int i = 0; i < G.V(); i++) {
            if (s.hasPathTo(i)) {
                StdOut.pt("0->" + i + " : ");
                s.pathTo(i).iterator();
                for (int j : s.pathTo(i))
                    StdOut.pt(j + " ");
                StdOut.p("");
            }
        }
    }
    
    public static void initGraph(String fileName) {
        String filePath = System.getProperty("user.dir") + "/src/com/ray/graph/";
        Scanner in = null;
        try {
            in = new Scanner(new File(filePath + fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        G = new Graph(in);
    }
	
}
