package com.rays.algo.graph;

/**
 * ��Ȩ����ͼ�߶���
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
    
    /**
     * ���
     * @return
     */
    public DirectedEdge copy() {
        return new DirectedEdge(from, to, weighted);
    }
    
    @Override
    public String toString() {
        return String.format("%d -> %d(%.2f)", from, to, weighted);
    }
    
}