package com.rays.algo.graph.gw;

import java.util.Scanner;

import com.ray.io.In;
import com.ray.io.Out;
import com.ray.util.Timer;
import com.rays.algo.graph.Edge;
import com.rays.algo.graph.EdgeWeightedGraph;
import com.rays.algo.graph.gw.PrimMinSTLazy;
import com.rays.algo.graph.gw.PrimMinST;

/**
 * 测试无向图
 * 
 * @author rays1
 *
 */
public class TestGraphEW {

    public static void main(String[] args) {
        testMinST();
    }
    
    public static void testMinST() {

        EdgeWeightedGraph G = getGraph("EWGTiny.txt");
        
        Timer t = Timer.create();
        
        t.click();
        PrimMinST primMST = new PrimMinST(G);
        t.click();
        PrimMinSTLazy primMSTLazy = new PrimMinSTLazy(G);
        t.click();
        KruskalMinST kruskalMinST = new KruskalMinST(G);
        t.stop();

        Out.p(" ====== 打印最小生成树 primMSTLazy ======");
        for (Edge e : primMSTLazy.edges()) {
            if (e != null)
                Out.p(e.toString());
        }
        Out.p();
        
        Out.p(" ====== 打印最小生成树 primMST ======");
        for (Edge e : primMST.edges()) {
            if (e != null)
                Out.p(e.toString());
        }
        Out.p();
        
        Out.p(" ====== 打印最小生成树 kruskalMinST ======");
        for (Edge e : kruskalMinST.edges()) {
            if (e != null)
                Out.p(e.toString());
        }
        Out.p();

    }

    private static EdgeWeightedGraph getGraph(String fileName) {
        Timer t = Timer.create("构建图");
        
        t.click();
        Scanner in = In.getClassPathScanner(TestGraphEW.class, fileName);
        t.click();
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        t.click();
        Out.p(G);
        t.stop();
        return G;
    }

}
