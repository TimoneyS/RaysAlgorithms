package com.ray.graph;

import java.util.Scanner;

import com.ray.utils.In;
import com.ray.utils.Out;

/**
 * ≤‚ ‘”–œÚÕº
 * @author rays1
 *
 */
public class TestDigraph {
    
	public static void main(String[] args) {
	    initGraph("");
	}
	
	
    
    public static void initGraph(String fileName) {
        Scanner in = In.getProjectScanner("src/com/ray/graph/" + fileName);
        G = new Digraph(in);
        Out.p(G);
    }
	
    private static Digraph G;
    
}
