package com.rays.algo.graph.g;

import java.util.Scanner;
import com.ray.common.collections.Bag;

/**
 * ����ͼ
 * @author rays1
 *
 */
public class Graph {
	
	private final int V;			// ������
	private int E;					// ����
	private Bag<Integer>[] adj;		// �ڲ��洢���ݽṹ������ÿ������Ŀɴﶥ��
	
	/**
	 * ָ����������ʼ��ͼ
	 * @param V
	 */
	@SuppressWarnings("unchecked")
	public Graph(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for (int v = 0; v < V;  v ++)
		    adj[v] = new Bag<Integer>();
	}
	
	/**
	 * ����������ʼ��ͼ
	 * @param in
	 */
	public Graph(Scanner in) {
		this(in.nextInt());
		int e = in.nextInt();
		
		for (int i = 0; i < e; i++) {
			int v = in.nextInt();
			int w = in.nextInt();
			if (v == w || hasEdge(v, w)) // ����������Ի�
			    continue;
			addEdge(v, w);
		}
		
	}
	
	/**
	 * ���һ����
	 * @param v
	 * @param w
	 */
	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
		E ++;
	}
	
	/**
	 * �ж�ĳ�����Ƿ����
	 * @param w
	 * @param w
	 * @return
	 */
	public boolean hasEdge(int v, int w) {
	    for (int tempV : adj(v)) if (w == tempV) return true;
	    return false;
	}
	
	/**
	 * �Ͷ��� v ��ͨ�Ķ���
	 * @param v
	 * @return
	 */
	Iterable<Integer> adj(int v) {
		return adj[v];
	}
	
	/**
	 * �������
	 * @param G
	 * @param v
	 * @return
	 */
	public static int degree(Graph G, int v) {
		int degree = 0;
		for (@SuppressWarnings("unused") int w : G.adj(v)) degree ++;
		return degree;
	}
	
    public String toString() {
        String s = V + " vertices, " + E + " Edges\n";
        for (int v = 0; v < V(); v ++) {
            s += v + " : ";
            for (int w : this.adj(v)) s += w + " ";
            s += "\n";
        }
        return s;
    }
	   
    public int V() { return V; }
    public int E() { return E; }

}
