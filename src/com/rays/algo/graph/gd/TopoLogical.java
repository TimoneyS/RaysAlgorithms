package com.rays.algo.graph.gd;

import java.util.Stack;

import com.rays.algo.graph.gwd.DirectedEdge;
import com.rays.algo.graph.gwd.EdgeWeightedDigraph;

/**
 * ͼ����������
 * 
 * @author rays1
 *
 */
public class TopoLogical {
    private boolean[]      marked;      // ���ĳ�������Ƿ��Ѿ�������
    private Stack<Integer> reverPost;   // ���������

    /**
     * ����ͼ��������
     * @param G
     */
    public TopoLogical(Digraph G) {
        marked = new boolean[G.V()];
        reverPost = new Stack<Integer>();
        for (int v = 0; v < marked.length; v++)
            if (!marked[v]) search(G, v);
    }
    
    public TopoLogical(EdgeWeightedDigraph G) {
        marked = new boolean[G.V()];
        reverPost = new Stack<Integer>();
        for (int v = 0; v < marked.length; v++)
            if (!marked[v]) search(G, v);
    }

    public void search(Digraph G, int v) {
        marked[v] = true;                       // �� v ���Ϊ�Ѿ�����
        for (int w : G.adj(v))                  // ���� v ��ÿ���ڽӶ��� w
            if (!marked[w]) search(G, w);       // ���ڽӶ���δ�����ʣ���������ڽӶ���
        reverPost.push(v);                      // ��ɺ�Ķ������ջ������ɵĶ�����ջ��
    }
    
    /**
     * ������������
     * @param G
     * @param v
     */
    private void search(EdgeWeightedDigraph G, int v) {
        marked[v] = true;                       // �� v ���Ϊ�Ѿ�����
        for (DirectedEdge e : G.adj(v)) {       // ���� v ��ÿ���ڱ� e
            int w = e.to();                     // �ڱ� e ���յ�
            if (!marked[w])                     // ���ڱ�δ������
                search(G, w);                   // �������ڱ�
        }
        reverPost.push(v);                      // ��ɺ�Ķ������ջ������ɵĶ�����ջ��
    }
    
    public Stack<Integer> order() {
        return reverPost;
    }

}
