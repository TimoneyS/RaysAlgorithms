package com.rays.algo.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * ����ͼ
 * @author rays1
 *
 */
public class Graph {
	
	private final int V;			// ������
	private int E;					// ����
	private List<Integer>[] adj;	// �ڲ��洢���ݽṹ������ÿ������Ŀɴﶥ��
	
	/**
	 * ָ����������ʼ��ͼ
	 * @param V
	 */
	@SuppressWarnings("unchecked")
	public Graph(int V) {
		this.V = V;
		this.E = 0;
		adj = (List<Integer>[]) new LinkedList[V];
		for (int v = 0; v < V;  v ++)
		    adj[v] = new LinkedList<Integer>();
	}
	
	/**
	 * ����������ʼ��ͼ
	 * @param in
	 */
	public Graph(Scanner in) {
	    
	    while (in.hasNext()) {
	        int v = in.nextInt();
	        int w = in.nextInt();
	        // �ж��Ƿ���Ҫ���������С
            adjustArrayTo(Math.max(v, w) + 1);
            addEdge(v, w);
	    }
	    
	    this.V = adj.length;
	}
	
	/**
	 * �ж��Ƿ���Ҫ���������С
	 * @param size
	 */
	@SuppressWarnings("unchecked")
    private void adjustArrayTo(int size) {
	    if (adj != null && adj.length >= size) return ;
	    int oldSize = (adj == null) ? 0 : adj.length;
	    List<Integer>[] arr = adj;
	    adj = (List<Integer>[]) new LinkedList[size];
        for (int v = 0; v < oldSize;  v ++)
            adj[v] = arr[v];
        for (int v = oldSize; v < size;  v ++)
            adj[v] = new LinkedList<Integer>();
            
	}
	
	/**
	 * ���һ����
	 * @param v
	 * @param w
	 */
	public void addEdge(int v, int w) {
	    if (v == w || hasEdge(v, w))return; // ����������Ի���ƽ�б�
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
	    for (int tempV : adj(v))
	        if (w == tempV)
	            return true;
	    return false;
	}
	
	/**
	 * �Ͷ��� v ��ͨ�Ķ���
	 * @param v
	 * @return
	 */
	public Iterable<Integer> adj(int v) {
		return adj[v];
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
