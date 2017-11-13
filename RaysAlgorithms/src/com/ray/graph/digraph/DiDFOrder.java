package com.ray.graph.digraph;

import java.util.Stack;

/**
 * �������� ����һ��ͼ�����������
 * @author rays1
 *
 */
public class DiDFOrder {
    private boolean[] marked;           // ���ĳ�������Ƿ��Ѿ�������
    private Stack<Integer> reverPost;   // ���������

    public DiDFOrder(Digraph G) {
        marked = new boolean[G.V()];
        reverPost = new Stack<Integer>();
        for (int i = 0 ; i < G.V(); i++)
            if (!marked[i]) search(G, i);
    }

    /**
     * �����㷨
     * 
     * @param G
     * @param v
     */
    private void search(Digraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w])
                search(G, w);
        }
        reverPost.push(v);
    }
    
    public Stack<Integer> reverPost() {
        return reverPost;
    }
    
}
