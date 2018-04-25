package com.rays.algo.graph.g;

import java.util.Stack;

import com.rays.algo.graph.Digraph;
import com.rays.algo.graph.Graph;
import com.rays.algo.graph.Paths;

/**
 * �����������<br>
 * ����һ��ͼ����һ���ݹ鷽�����������ж��㣬�ڷ�������һ������ʱ��<br>
 * 1.������Ϊ�ѷ���<br>
 * 2.�ݹ�ķ�����δ�����ʵ��ھӽڵ�<br>
 * 
 * @author rays1
 *
 */
public class DeepthFirstPaths implements Paths {
    
    private boolean[] marked; // ���ĳ�������Ƿ��Ѿ�������
    private int[]     edgeTo; // �����ĳ���һ���ڽӵ�
    private int       start;      // ���

    public DeepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        start = s;
        search(G, s);
    }
    
    /**
     * ����ͼ�������
     * @param G
     * @param s
     */
    public DeepthFirstPaths(Digraph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        start = s;
        search(G, s);
    }
    
    /**
     * ����ͼ�������
     * @param G
     * @param v
     */
    private void search(Digraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                search(G, w);
            }
        }
    }

    /**
     * �����㷨
     * 
     * @param G
     * @param v
     */
    public void search(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                search(G, w);
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Stack<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        
        Stack<Integer> stack = new Stack<Integer>();
        for (int x = v; x != start; x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(start);
        return stack;
    }

}
