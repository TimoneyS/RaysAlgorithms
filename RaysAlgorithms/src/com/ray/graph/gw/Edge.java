package com.ray.graph.gw;

/**
 * ��Ȩ��
 * @author rays1
 *
 */
public class Edge implements Comparable<Edge> {
    
    private final int v;                    // ����һ
    private final int w;                    // �����
    private final double weighted;          // Ȩ��
    
    public Edge(int v, int w, double weighted) {
        super();
        this.v = v;
        this.w = w;
        this.weighted = weighted;
    }
    
    public int either() { return v; }
    
    /**
     * ���رߵ���һ������
     * @param vertex
     * @return
     */
    public int other(int vertex) {
        if (vertex == v) return w;
        else if (vertex == w) return v;
        else throw new RuntimeException("�����ߴ���");
    }

    /**
     * Ŀ��߱ȵ�ǰ��Ȩ�ش�ķ�������
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