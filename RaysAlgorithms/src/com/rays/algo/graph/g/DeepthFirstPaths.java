package com.rays.algo.graph.g;

import java.util.Stack;

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
    private int       s;      // ���

    public DeepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        search(G, s);
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

    /**
     * ��ѯ����v�Ƿ���ͨ
     * 
     * @param v
     * @return
     */
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /**
     * ��ȡ�����v��·��
     * 
     * @param v
     * @return
     */
    public Stack<Integer> pathTo(int v) {
        if (!hasPathTo(v))
            return null;

        Stack<Integer> stack = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(s);
        return stack;
    }

}
