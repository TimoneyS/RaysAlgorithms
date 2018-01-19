package com.rays.algo.graph.g;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 广度优先搜索<br>
 * 先将起点加入队列，然后重复一下步骤直到队列为空 <br>
 * 1.取队列的下一个顶点，并标记该顶点 <br>
 * 2.将与v相邻的所有未被标记的顶点加入队列
 * 
 * @author rays1
 *
 */
public class BreadthFirstPaths implements Paths {

    private boolean[]           marked; // 标记某个顶点搜索时是否已经被访问
    private int[]               edgeTo; // 存放至某点的一个邻接点
    private int                 s;      // 起点
    private Queue<Integer>      queue;

    public BreadthFirstPaths(Graph G, int s) {
        
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        queue = new ArrayDeque<Integer>(G.V());
        
        this.s = s;
        queue.add(s);
        marked[s] = true;
        
        search(G, s);
    }

    private void search(Graph G, int s) {
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.add(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Stack<Integer> pathTo(int v) {
        if (!marked[v])
            return null;
        Stack<Integer> stack = new Stack<Integer>();

        for (int x = v; x != s; x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(s);
        return stack;
    }

}
