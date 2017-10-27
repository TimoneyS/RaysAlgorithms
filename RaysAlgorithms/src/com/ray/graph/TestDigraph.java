package com.ray.graph;

import java.util.LinkedList;
import java.util.Scanner;

import com.ray.utils.In;
import com.ray.utils.Out;

/**
 * ��������ͼ
 * @author rays1
 *
 */
public class TestDigraph {
    
	public static void main(String[] args) {
	    initGraph("digraph.txt");
	    testDiDFP();
	}
	
	/**
	 * ��������ͼ���������·��
	 */
	public static void testDiDFP() {
	    int s = 0;
	    int e = 7;
	    
	    DiDFP dfp = new DiDFP(G, s);
	    
	    LinkedList<Integer> list = dfp.pathTo(e);
	    
	    for (int i : list)
	        Out.pt(i + " ");
	}
	
	/**
	 * ��ʼ��ͼ
	 * @param fileName
	 */
    public static void initGraph(String fileName) {
        Scanner in = In.getProjectScanner("src/com/ray/graph/" + fileName);
        G = new Digraph(in);
        Out.p(G);
    }
	
    private static Digraph G;
    
}
