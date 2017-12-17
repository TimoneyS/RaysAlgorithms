package com.ray.graph.wDigraph;

import java.util.Stack;

import com.ray.utils.collections.RaysStack;

/**
 * �޻���Ȩ����ͼ���·����������<br>
 * ��������������ɶ��㣬ÿ���ȷ��ɵĶ��㶼ֻ�ᱻ����һ��<br>
 * @author rays1
 * 
 */
public class AcycliSP {
    
    private boolean[]           marked;           // ���ĳ�������Ƿ��Ѿ�������
    private Stack<Integer>      stack;            // ���������
    private DirectedEdge[]      edgeTo;
    private double[]            distTo;
    
    public AcycliSP(EdgeWeightedDigraph G, int S) {

        marked = new boolean[G.V()];
        stack  = new Stack<Integer>();
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];

        for (int i = 0; i < G.V(); i ++) {
            distTo[i] = Double.POSITIVE_INFINITY;
            if (!marked[i]) search(G, i);
        }
        distTo[S] = 0.0;

        while (!stack.empty()) {
            int v = stack.pop();
            for (DirectedEdge e : G.adj(v))
                relax(e);
        }

    }

    /**
     * ����һ����
     * @param e
     */
    private void relax(DirectedEdge e) {
        int v = e.from();                                   // �ߵ����
        int w = e.to();                                     // �ߵ��յ�
        if (distTo[w] > distTo[v] + e.weighted()) {         // ���������� w �ľ��룬�ȴӸñ���㵽 w ҪԶ
            edgeTo[w] = e;                                  // ���� w �ı�����Ϊ�ñ�
            distTo[w] = distTo[v] + e.weighted();           // ���� w �ľ�����Ϊ�Ӹñߵ� w �ľ���
        }
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
        stack.push(v);                          // ��ɺ�Ķ������ջ������ɵĶ�����ջ��
    }
    
    double distTo(int v) {
        return distTo[v];
    }

    boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }
    
    RaysStack<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v))
            return null;

        RaysStack<DirectedEdge> path = new RaysStack<DirectedEdge>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
            path.push(e);

        return path;
    }
    
}
