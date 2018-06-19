package com.rays.algo.graph.gw;

import java.util.Scanner;

import com.ray.util.io.In;
import com.ray.util.io.Out;
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
        testPrimMinST();
    }

    public static void testPrimMinST() {

        EdgeWeightedGraph G = getGraph("primMST.txt");
        PrimMinST primMST = new PrimMinST(G);
        PrimMinSTNew primMSTNew = new PrimMinSTNew(G);

        Out.p(" ====== 打印最小生成树 primMSTNew ======");
        for (Edge e : primMSTNew.edges()) {
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

    }

    public static void testLazyPrimMinST() {
        EdgeWeightedGraph G = getGraph("tinyEWG.txt");
        PrimMinSTLazy primMST = new PrimMinSTLazy(G);
        Edge[] edgeTo = primMST.getEdgeTo();

        for (Edge e : edgeTo) {
            if (e != null)
                Out.p(e.toString());
        }
    }

    private static EdgeWeightedGraph getGraph(String fileName) {
        Scanner in = In.getClassPathScanner(TestGraphEW.class, fileName);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        Out.p(G);
        return G;
    }

}
