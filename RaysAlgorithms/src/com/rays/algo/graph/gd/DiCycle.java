package com.rays.algo.graph.gd;

import java.util.Stack;

/**
 * 检测有向图的环
 * @author rays1
 *
 */
public class DiCycle {
    
    int[]     pathTo;
    boolean[] marked;
    boolean[] onStack;
    Stack<Integer> cycle;
    
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
            if (hasCycle()) return;
            else if (!marked[w]) {
                pathTo[w] = v;
                search(G, w);
            } else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int i = v; i != w; i = pathTo[i])
                    cycle.push(i);
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }
    
    public Stack<Integer> getCycle() {
        return cycle;
    }
    
    boolean hasCycle() {
        return cycle != null;
    }
    
}
