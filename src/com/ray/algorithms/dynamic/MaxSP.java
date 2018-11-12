package com.ray.algorithms.dynamic;

import java.util.Scanner;

import com.ray.io.Out;
import com.rays.algo.graph.DirectedEdge;
import com.rays.algo.graph.EdgeWeightedDigraph;

/**
 * 给定有向无环图，利用动态规划求两点之间最长路径
 * @author rays1
 *
 */
public class MaxSP {

    EdgeWeightedDigraph G;
    int[][] length;
    int[] nextTo;
    
    public MaxSP(EdgeWeightedDigraph G, int s, int t) {
        
        this.G = G;
        int V = G.V();
        
        length = new int[V+1][V+1];
        nextTo = new int[V+1];
        double l = search(s, t);
        
        Out.p(l);
        
        int v = s;
        
        while (v != 0) {
            Out.pt(v + " -> ");
            v = nextTo[v];
        }
        Out.p();
        
    }
    
    public double search(int s, int t) {
        
        if (s == t)
            return 0;
        
        double length = 0;
        for ( DirectedEdge e : G.adj(s)) {
            
            int w = e.to();
            
            double l = search(w, t);
            double tempLength = e.weighted() + l;
            
            if (length < tempLength) {
                length =  tempLength;
                nextTo[s] = w;
            }
        }
        
        return length;
        
    }
    
    public static void main(String[] args) {
        
        String GString =
                  "1 2 1\n"
                + "1 3 2\n"
                + "3 4 3\n"
                + "2 4 4\n"
                + "4 5 5\n"
                + "4 6 6\n"
                + "6 7 6\n"
                + "5 7 8\n";
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(new Scanner(GString));
        
        
        new MaxSP(G, 1, 7);
        
        
    }
    
}
