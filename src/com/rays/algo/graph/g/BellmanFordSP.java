package com.rays.algo.graph.g;

import java.util.ArrayDeque;
import java.util.Queue;

import com.ray.io.Out;
import com.rays.algo.graph.DirectedEdge;
import com.rays.algo.graph.EdgeWeightedDigraph;

/**
 * BellmanFord算法<br/>
 * 在任意含有V个顶点的加权有向图中给定起点s，
 * 从s无法到达任何负权重环，则算法如下：<br/><br/>
 * 将 distTo[s] 初始化为0，其他 distTo[] 元素初始化为正无穷<br/>
 * 以任意顺序放松有向图的所有边，重复 V 轮。
 * 
 * @author rays1
 *
 */
public class BellmanFordSP extends SP {
    
    private boolean[]       onQ;
    private Queue<Integer>  queue;
    
    public BellmanFordSP(EdgeWeightedDigraph G, int s) {
        
        onQ  = new boolean[G.V()];
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        queue  = new ArrayDeque<Integer>(G.V());
        
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        
        queue.add(s);
        onQ[s] = true;
        distTo[s] = 0;
        
        while (!queue.isEmpty()) {
            relax(G, queue.poll());
        }
        
    }
    
    @Override
    protected void relax(EdgeWeightedDigraph G, int v) {
        
        Out.pf("放松%s:\n", v);
        onQ[v] = false;
        for (DirectedEdge e : G.adj(v)) {
            
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weighted()) {
                distTo[w] = distTo[v] + e.weighted();
                edgeTo[w] = e;
                
                Out.pf("  顶点%s - 边 %s -> %s 加入最短路径，", w, v, w);
                
                if (onQ[w] == false) {
                    Out.pf("顶点加入队列\n", w);
                    queue.add(w);
                    onQ[w] = true;
                } else {
                    Out.pf("顶点已经在队列\n", w);
                }
                
            } else {
                Out.pf("  顶点%s - 边 %s -> %s 废弃\n", w, v, w);
            }
            
        }
        
        Out.p();
        
    }
    
    /*// 简单实现方式 需要 执行V * E 次，其中有许多无用的放松操作
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
    */
}
