package com.ray.graph.weightedDigraph;

import com.ray.utils.collections.RaysStack;

/**
 * �޻���Ȩ����ͼ�·����������<br>
 * ����һ���µ�ͼ����ͼ������·����Ȩ��Ϊԭ���ĸ�ֵ��Ȼ�����������·��������
 * @author rays1
 * 
 */
public class AcycliLP {
    
    AcycliSP acycliSP;
    
    public AcycliLP(EdgeWeightedDigraph G, int S) {
        
        
    }
    
    double distTo(int v) {
        return 1;
    }

    boolean hasPathTo(int v) {
        return false;
    }
    
    RaysStack<DirectedEdge> pathTo(int v) {
        return null;
    }
    
}
