package com.rays.algo.graph.gd;

import java.util.Stack;

import com.rays.algo.graph.g.Paths;

/**
 * ����ͼ�������������(������ͼ����������㷨����һ��)
 * @author rays1
 *
 */
public class DiDeepthFirstPaths implements Paths {

    private boolean[] marked; // ���ĳ�������Ƿ��Ѿ�������
    private int[]     edgeTo; // �����ĳ���һ���ڽӵ�
    private int       s;      // ���

    public DiDeepthFirstPaths(Digraph G, int s) {
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
    public void search(Digraph G, int v) {
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
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
    
}
