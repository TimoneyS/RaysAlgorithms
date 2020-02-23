package com.ray.algo.graph.g;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

import com.ray.algo.graph.Digraph;
import com.ray.algo.graph.Graph;
import com.ray.algo.graph.Paths;

/**
 * 广度优先搜索<br>
 *  循环访问队列所有顶点，在访问其中一个顶点时<br>
 *    1.获取其所有未被标记的顶点<br>
 *    2.将符合的相邻的顶点加入队列并标记<br>
 * @author rays1
 *
 */
public class BreadthFirstPaths implements Paths {

    private boolean[]           marked;     // 标记某个顶点搜索时是否已经被访问
    private int[]               edgeTo;     // 存放至某点的一个邻接点
    private int                 start;      // 起点
    private Queue<Integer>      queue;
    
    private BreadthFirstPaths(int V, int s) {
        marked = new boolean[V];
        edgeTo = new int[V];
        queue = new ArrayDeque<Integer>(V);
        
        start = s;
        queue.add(s);
        marked[s] = true;
        
    }
    
    /**
     * 无向图广度优先
     * @param G
     * @param s
     */
    public BreadthFirstPaths(Graph G, int s) {
        this(G.V(), s);
        search(G, s);
    }
    
    /**
     * 有向图广度优先
     * @param G
     * @param s
     */
    public BreadthFirstPaths(Digraph G, int s) {
        this(G.V(), s);
        search(G, s);
    }

    private void search(Graph G, int s) {
        while (!queue.isEmpty()) {
            int v = queue.poll();
            
            for (int w : G.adj(v)) {
                if (marked[w]) continue;
                edgeTo[w] = v;
                queue.add(w);
                marked[w] = true;
            }
        }
    }
    
    private void search(Digraph G, int s) {
        while (!queue.isEmpty()) {
            int v = queue.poll();
            
            for (int w : G.adj(v)) {
                if (marked[w]) continue;
                edgeTo[w] = v;
                queue.add(w);
                marked[w] = true;
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Stack<Integer> pathTo(int v) {
        if (!marked[v])
            return null;
        Stack<Integer> stack = new Stack<Integer>();

        for (int x = v; x != start; x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(start);
        return stack;
    }

}
