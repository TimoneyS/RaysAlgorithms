package com.rays.algo.graph.gw;

import com.rays.algo.graph.Edge;

/**
 * ��Ȩͼ����С������
 * @author rays1
 * �������ж���ģ��ߵ�Ȩֵ����С�ģ��޻���ͨ��ͼ
 */
public interface MinST {
    
    Iterable<Edge> edges();
    double weight();
    
}
