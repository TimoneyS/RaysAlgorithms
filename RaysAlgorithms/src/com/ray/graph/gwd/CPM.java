package com.ray.graph.gwd;

import java.util.Scanner;

import com.ray.utils.Out;
import com.ray.utils.collections.RaysStack;
import com.ray.utils.collections.Stack;

/**
 * 平行任务调度算法
 * @author rays1
 *
 */
public class CPM {
    
    private RaysStack<DirectedEdge> path;
    
    public CPM(Scanner in) {
        int N = in.nextInt();
        int S = 2 * N;
        int T = 2 * N + 1;
Out.p(N + " " + S + " " + T);        
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(2*N + 2);
        in.nextLine();        
        for (int i = 0; i < N; i++) {
            String[] arr = in.nextLine().split("\\s+");
            int v = Integer.valueOf(arr[0]);
            int v1 = v + N;
            double weight =  Double.valueOf(arr[1]);
            
            // 添加  v  -> v'
            G.addEdge(v, v1, weight);
            // 添加  v' -> t
            G.addEdge(v1, T, 0);
            // 添加  s  -> v
            G.addEdge(S, v, 0);
            
            if (arr.length > 2) {
                for (int j = 2; j < arr.length; j ++) {
                    // 添加  v' -> w
                    G.addEdge(v1, Integer.valueOf(arr[j]), 0);
                }
            }
        }
Out.p(G);        
       AcycliLP lp = new AcycliLP(G, S);
       path = lp.pathTo(T);
        
    }
    
    public Stack<DirectedEdge> getPath() {
        return path;
    }
    
}
