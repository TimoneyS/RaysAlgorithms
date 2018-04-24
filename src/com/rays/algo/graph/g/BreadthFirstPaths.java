package com.rays.algo.graph.g;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * �����������<br>
 *  ѭ�����ʶ������ж��㣬�ڷ�������һ������ʱ<br>
 *    1.��ȡ������δ����ǵĶ���<br>
 *    2.�����ϵ����ڵĶ��������в����<br>
 * @author rays1
 *
 */
public class BreadthFirstPaths implements Paths {

    private boolean[]           marked;     // ���ĳ����������ʱ�Ƿ��Ѿ�������
    private int[]               edgeTo;     // �����ĳ���һ���ڽӵ�
    private int                 start;      // ���
    private Queue<Integer>      queue;

    public BreadthFirstPaths(Graph G, int s) {
        
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        queue = new ArrayDeque<Integer>(G.V());
        
        this.start = s;
        queue.add(s);
        marked[s] = true;
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
