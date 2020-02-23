package com.ray.algo.graph.g;

import java.util.Stack;

import com.ray.algo.graph.Digraph;

/**
 * 检测有向环
 * @author rays1
 *
 */
public class DiCycle {
    
    private int[]     pathTo;
    private boolean[] marked;
    private boolean[] onStack;
    private Stack<Integer> cycle;
    
    public DiCycle(Digraph G, int s) {
        
        marked = new boolean[G.V()];
        onStack  = new boolean[G.V()];
        pathTo   = new int[G.V()];
        
        search(G, s);
    }

    private void search(Digraph G, int v) {
        onStack[v] = true;
        marked[v]  = true;
        for (int w : G.adj(v)) {
            if (hasCycle()) break;
            
            if (!marked[w]) {
                pathTo[w] = v;
                search(G, w);
            } else if (onStack[w]) {
                cycle = new Stack<Integer>();
                cycle.push(w);  // 终点是w
                for (int i = v; i != w; i = pathTo[i]) cycle.push(i);
                cycle.push(w);  // 起点是w
            }
            
        }
        onStack[v] = false;
    }
    
    public Stack<Integer> getCycle() {
        return cycle;
    }
    
    public boolean hasCycle() {
        return cycle != null;
    }
    
}
