package com.ray.graph.gw;

/**
 * 加权边
 * @author rays1
 *
 */
public class Edge implements Comparable<Edge> {
    
    private final int v;                    // 顶点一
    private final int w;                    // 顶点二
    private final double weighted;          // 权重
    
    public Edge(int v, int w, double weighted) {
        super();
        this.v = v;
        this.w = w;
        this.weighted = weighted;
    }
    
    public int either() { return v; }
    
    /**
     * 返回边的另一个顶点
     * @param vertex
     * @return
     */
    public int other(int vertex) {
        if (vertex == v) return w;
        else if (vertex == w) return v;
        else throw new RuntimeException("解析边错误");
    }

    /**
     * 目标边比当前变权重大的返回正数
     */
    public int compareTo(Edge e) {
        return Double.compare(weighted, e.getWeighted());
    }
    
    public double getWeighted() {
        return weighted;
    }
    
    @Override
    public String toString() {
        return v + " " + w + " " + weighted;
    }
    
}