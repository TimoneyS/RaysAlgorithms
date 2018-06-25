package com.rays.algo.graph.gwd;

import java.util.ArrayDeque;
import java.util.Queue;

import com.ray.util.io.Out;
import com.rays.algo.graph.DirectedEdge;
import com.rays.algo.graph.EdgeWeightedDigraph;

/**
 * BellmanFord�㷨<br/>
 * �����⺬��V������ļ�Ȩ����ͼ�и������s��
 * ��s�޷������κθ�Ȩ�ػ������㷨���£�<br/><br/>
 * �� distTo[s] ��ʼ��Ϊ0������ distTo[] Ԫ�س�ʼ��Ϊ������<br/>
 * ������˳���������ͼ�����бߣ��ظ� V �֡�
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
            relax(G, queue.poll());
        }
        
    }
    
    @Override
    protected void relax(EdgeWeightedDigraph G, int v) {
        
        Out.pf("����%s:\n", v);
        onQ[v] = false;
        for (DirectedEdge e : G.adj(v)) {
            
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weighted()) {
                distTo[w] = distTo[v] + e.weighted();
                edgeTo[w] = e;
                
                Out.pf("  ����%s - �� %s -> %s �������·����", w, v, w);
                
                if (onQ[w] == false) {
                    Out.pf("����������\n", w);
                    queue.add(w);
                    onQ[w] = true;
                } else {
                    Out.pf("�����Ѿ��ڶ���\n", w);
                }
                
            } else {
                Out.pf("  ����%s - �� %s -> %s ����\n", w, v, w);
            }
            
        }
        
        Out.p();
        
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
