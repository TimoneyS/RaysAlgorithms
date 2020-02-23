package com.ray.algo.graph.g;

import java.util.Arrays;

import com.ray.util.collections.MinPQ;
import com.ray.util.collections.RaysMinPQ;
import com.ray.algo.graph.Edge;
import com.ray.algo.graph.EdgeWeightedGraph;

public class KruskalMinST implements MinST {
    
    private Edge[]      edges;
    private MinPQ<Edge> pq;
    private int[]       group;      // 保存联通分量的分组
    private int         id;         // 联通分量分组ID
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
            
            // 两个顶点属于同一个子树，如加入会成环，因此该边属于废弃边，跳过
            if (group[v] == group[w] && group[v] != -1) {
                continue;
            }
            
            if (group[v] == group[w] && group[v] == -1) {
                // 两个顶点都是独立顶点
                group[v] = id;
                group[w] = id;
                id++;
            } else if (group[v] == -1) { // v 是独立顶点，将v加入w所在的子数
                group[v] = group[w];
            } else if (group[w] == -1) { // w 是独立顶点，将w加入w所在的子树
                group[w] = group[v];
            } else {
                // v w分别属于独立的子树，两个子树合并
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
