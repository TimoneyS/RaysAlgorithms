package com.ray.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.ray.utils.StdOut;

public class Test {

	public static void main(String[] args) {
	    String filePath = System.getProperty("user.dir") + "/src/com/ray/graph/";
	    // String fileName = "tinyG.txt";
	    String fileName = "gameG.txt";
	    
	    
		Scanner in = null;
		try {
			in = new Scanner(new File(filePath + fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Graph G = new Graph(in);
		BreadthFirstPaths s = new BreadthFirstPaths(G, 0);
		
		StdOut.p(G);
		
		for(int i = 0; i < G.V(); i++) {
			
			if (s.hasPathTo(i)) {
				StdOut.pt("0->" + i + " : ");
				for (int j : s.pathTo(i)) StdOut.pt(j + " ");
				StdOut.p("");
			}
			
		}
		
	}

}
