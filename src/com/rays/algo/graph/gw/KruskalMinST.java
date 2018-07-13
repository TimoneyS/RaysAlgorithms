package com.rays.algo.graph.gw;

import java.util.Arrays;

import com.ray.util.collections.MinPQ;
import com.ray.util.collections.RaysMinPQ;
import com.rays.algo.graph.Edge;
import com.rays.algo.graph.EdgeWeightedGraph;

public class KruskalMinST implements MinST {
    
    private Edge[]      edges;
    private MinPQ<Edge> pq;
    private int[]       group;      // ������ͨ�����ķ���
    private int         id;         // ��ͨ��������ID
    private double      weight;
    
    public KruskalMinST(EdgeWeightedGraph G) {
        
        group = new int[G.V()];
        edges = new Edge[G.V()];
        pq = new RaysMinPQ<>(G.E());
        weight = 0;
        id = 1;
        
        int cursor = 0;
        
        for (int i = 0; i < group.length; i++) {
            group[i] = -1;
        }
        
        for (Edge edge : G.edges()) {
            pq.insert(edge);
        }
        
        while (!pq.isEmpty()) {
            Edge e = pq.delMin();
            
            int v = e.either();
            int w = e.other(v);
            
            // ������������ͬһ��������������ɻ�����˸ñ����ڷ����ߣ�����
            if (group[v] == group[w] && group[v] != -1) {
                continue;
            }
            
            if (group[v] == group[w] && group[v] == -1) {
                // �������㶼�Ƕ�������
                group[v] = id;
                group[w] = id;
                id++;
            } else if (group[v] == -1) { // v �Ƕ������㣬��v����w���ڵ�����
                group[v] = group[w];
            } else if (group[w] == -1) { // w �Ƕ������㣬��w����w���ڵ�����
                group[w] = group[v];
            } else {
                // v w�ֱ����ڶ��������������������ϲ�
                int temp = group[w];
                for (int i = 0; i < group.length; i++) {
                    if (group[i] == temp)
                        group[i] = group[v];
                }
            }
            
            edges[cursor++] = e;
            weight += e.getWeighted();
            
            if (cursor == G.V()-1) break;
            
        }
        
    }

    @Override
    public Iterable<Edge> edges() {
        return Arrays.asList(edges);
    }

    @Override
    public double weight() {
        return weight;
    }
    
}
