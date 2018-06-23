package com.rays.algo.graph.gw;

import java.util.Scanner;

import com.ray.util.Timer;
import com.ray.util.io.In;
import com.ray.util.io.Out;
import com.rays.algo.graph.Edge;
import com.rays.algo.graph.EdgeWeightedGraph;
import com.rays.algo.graph.gw.PrimMinSTLazy;
import com.rays.algo.graph.gw.PrimMinST;

/**
 * ��������ͼ
 * 
 * @author rays1
 *
 */
public class TestGraphEW {

    public static void main(String[] args) {
        testPrimMinST();
    }

    public static void testPrimMinST() {

        EdgeWeightedGraph G = getGraph("10000EWG.txt");
        
        Timer t = Timer.create();
        
        t.click();
        PrimMinST primMST = new PrimMinST(G);
        t.click();
        PrimMinSTLazy primMSTLazy = new PrimMinSTLazy(G);
        t.stop();

//        Out.p(" ====== ��ӡ��С������ primMSTLazy ======");
//        for (Edge e : primMSTLazy.edges()) {
//            if (e != null)
//                Out.p(e.toString());
//        }
//        Out.p();
//        
//        Out.p(" ====== ��ӡ��С������ primMST ======");
//        for (Edge e : primMST.edges()) {
//            if (e != null)
//                Out.p(e.toString());
//        }
//        Out.p();

    }

    private static EdgeWeightedGraph getGraph(String fileName) {
        Timer t = Timer.create("����ͼ");
        
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
