package com.rays.algo.graph.g;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * �����������<br>
 * �Ƚ���������У�Ȼ���ظ�һ�²���ֱ������Ϊ�� <br>
 * 1.ȡ���е���һ�����㣬����Ǹö��� <br>
 * 2.����v���ڵ�����δ����ǵĶ���������
 * 
 * @author rays1
 *
 */
public class BreadthFirstPaths implements Paths {

    private boolean[]           marked; // ���ĳ����������ʱ�Ƿ��Ѿ�������
    private int[]               edgeTo; // �����ĳ���һ���ڽӵ�
    private int                 s;      // ���
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
