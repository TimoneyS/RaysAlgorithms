package com.ray.graph.weightedGraph;

/**
 * ����ͼ�߶���
 * @author rays1
 *
 */
public class DirectedEdge implements Comparable<DirectedEdge> {
    
    private final int from;                 // ���
    private final int to;                   // �յ�
    private final double weighted;          // Ȩ��
    
    public DirectedEdge(int from, int to, double weighted) {
        super();
        this.from = from;
        this.to = to;
        this.weighted = weighted;
    }

    @Override
    public int compareTo(DirectedEdge o) {
        return 0;
    }
    
    public int from() {
        return from;
    }
    
    public int to() {
        return to;
    }
    
    public double weighted() {
        return weighted;
    }
    
    @Override
    public String toString() {
        return String.format("%2s -> %2s %s", from, to, weighted);
    }
    
}