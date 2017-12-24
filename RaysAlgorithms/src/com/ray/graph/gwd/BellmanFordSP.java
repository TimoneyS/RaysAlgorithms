package com.ray.graph.gwd;

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
    
}
