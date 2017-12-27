package com.ray.graph.gwd;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * BellmanFord�㷨<br/>
 * �����⺬��V������ļ�Ȩ����ͼ�и������s��
 * ��s�޷������κθ�Ȩ�ػ������㷨���£�<br/><br/>
 * ��distTo[s]��ʼ��Ϊ0������distTo[]Ԫ�س�ʼ��Ϊ������<br/>
 * ������˳���������ͼ�����бߣ��ظ�V�֡�
 * 
 * @author rays1
 *
 */
public class BellmanFordSP extends SP {
    
    private boolean[]       onQ;
    private Queue<Integer>  queue;
    
    public BellmanFordSP(EdgeWeightedDigraph G, int s) {
        
        onQ  = new boolean[G.V()];
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        queue  = new ArrayDeque<Integer>(G.V());
        
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        
        queue.add(s);
        onQ[s] = true;
        distTo[s] = 0;
        
        while (!queue.isEmpty()) {
            int v = queue.poll();
            onQ[v] = false;
            relax(G, v);
        }
        
    }
    
    @Override
    protected void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weighted()) {
                distTo[w] = distTo[v] + e.weighted();
                edgeTo[w] = e;
                if (onQ[w] == false) {
                    queue.add(w);
                    onQ[w] = true;
                }
            }
        }
    }
    
    /*// ��ʵ�ַ�ʽ ��Ҫ ִ��V * E �Σ�������������õķ��ɲ���
    public BellmanFordSP(EdgeWeightedDigraph G, int s) {
        
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        
        distTo[0] = 0;
        search(G, s);
    }
    
    private void search(EdgeWeightedDigraph G, int s) {
        
        for (int pass = 0; pass < G.V(); pass ++) {
            for (DirectedEdge e : G.edges()) {
                relax(e);
            }
        }
        
    }
    */
}
