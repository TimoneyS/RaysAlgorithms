package com.rays.algo.graph.g;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

import com.rays.algo.graph.Digraph;

/**
 * 深度优先过程中，几种顶点排序方式
 * @author rays1
 *
 */
public class DeepthFirstOrder {

    private boolean[] marked; 
    private Queue<Integer> preOrder;
    private Queue<Integer> postOrder;
    private Stack<Integer> reverPostOrder;
    
    public DeepthFirstOrder(Digraph G) {
        preOrder = new ArrayDeque<>(G.V());
        postOrder = new ArrayDeque<>(G.V());
        reverPostOrder = new Stack<Integer>();
        marked = new boolean[G.V()];
        
        for (int v = 0; v < G.V(); v ++ )
            if(!marked[v]) dfs(G, v);
    }
    
    private void dfs(Digraph G, int v) {
        preOrder.add(v);
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w])  dfs(G, w);
        }
        reverPostOrder.push(v);
        postOrder.add(v);
    }
    
    public Iterable<Integer> pre(){ return preOrder; }
    public Iterable<Integer> post(){ return postOrder; }
    public Iterable<Integer> reverPost(){ return reverPostOrder; }
    
}
