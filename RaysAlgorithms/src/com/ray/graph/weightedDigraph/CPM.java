package com.ray.graph.weightedDigraph;

import java.util.Scanner;

public class CPM {
    
    public CPM(Scanner in) {
        int N = in.nextInt();
        int S = 2 * N;
        int T = 2 * N + 1;
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(2*N + 2);
        in.nextLine();        
        for (int i = 0; i < N; i++) {
            String[] arr = in.nextLine().split("\\s+");
            int v = Integer.valueOf(arr[0]);
            int v1 = v + N;
            double weight =  Double.valueOf(arr[1]);
            if (arr.length > 2) {
                for (int j = 2; j < arr.length; j ++) {
                    int w = Integer.valueOf(arr[j]);
                    // 添加  v  -> v'
                    G.addEdge(v, v1, weight);
                    // 添加  v' -> w
                    G.addEdge(v1, w, 0);
                    // 添加  s  -> v
                    G.addEdge(S, v, 0);
                    // 添加  v' -> t
                    G.addEdge(v1, T, 0);
                }
            }
        }
        
        AcycliLP lp = new AcycliLP(G, S);
        
        lp.pathTo(T);
        
    }
    
}
