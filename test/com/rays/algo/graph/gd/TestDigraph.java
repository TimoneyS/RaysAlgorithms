package com.rays.algo.graph.gd;

import java.util.LinkedList;
import java.util.Scanner;

import com.ray.common.io.In;
import com.ray.common.io.Out;
import com.rays.algo.graph.gd.DiCycle;
import com.rays.algo.graph.gd.DiDeepthFirstPath;
import com.rays.algo.graph.gd.Digraph;
import com.rays.algo.graph.gd.SCC;
import com.rays.algo.graph.gd.TopoLogical;

/**
 * ��������ͼ
 * @author rays1
 *
 */
public class TestDigraph {
    
	public static void main(String[] args) {
	    testDiCycle();
	}
	
	/**
	 * ����ǿ��ͨ����
	 */
	public static void testSCC() {
	    Digraph G = getDigraph("graphCC2.txt");
	    SCC scc = new SCC(G);
	    
	    for (int i = 0; i < scc.count(); i ++) {
	        Out.pf("��ͨ���� : %d\n[", i);
	        for (int j = 0; j < scc.id().length; j ++) {
	            if (scc.id()[j] == i) Out.pt(" " + j);
	        }
	        Out.p(" ]");
	    }
	        
	}
	
	/**
	 * ������������
	 * @return
	 */
	public static void testDiDFOrder() {
	    Digraph G = getDigraph("digraphTopo.txt");
	    TopoLogical topo = new TopoLogical(G);
	    
	    while (!topo.order().isEmpty())
	        Out.pt(topo.order().pop() + " ");
	    
	}
	
	/**
	 * ��������ͼ��Ѱ�һ�
	 */
	public static void testDiCycle() {
	    Digraph G = getDigraph("digraphCycle.txt");
	    DiCycle diCycle = new DiCycle(G, 0);
	    Out.p(diCycle.hasCycle());
	    while (!diCycle.getCycle().isEmpty())
	        Out.pt(diCycle.getCycle().pop() + "  ");
	    
	}
	
	/**
	 * ��������ͼ���������·��
	 */
	public static void testDiDFP() {
	    Digraph G = getDigraph("digraph.txt");
	    
	    int s = 0;
	    int e = 7;
	    
	    DiDeepthFirstPath dfp = new DiDeepthFirstPath(G, s);
	    
	    LinkedList<Integer> list = dfp.pathTo(e);
	    
	    for (int i : list)
	        Out.pt(i + " ");
	}
	
    public static Digraph getDigraph(String fileName) {
        Scanner in = In.getClassPathScanner(TestDigraph.class, fileName);
        Digraph G = new Digraph(in);
        Out.p(G);
        return G;
    }
    
}
