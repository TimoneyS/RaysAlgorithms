package com.rays.algo.graph;

/**
 * 加权有向图边定义
 * @author rays1
 *
 */
public class DirectedEdge implements Comparable<DirectedEdge> {
    
    private final int from;                 // 起点
    private final int to;                   // 终点
    private final double weighted;          // 权重
    
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
     * 深复制
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