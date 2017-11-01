package com.ray.graph;

import java.util.Stack;

/**
 * ��������ͼ��ǿ��ͨ����<br/>
 * Kosaraju�㷨<br/>
 * 1.ʹ��DiDFOrder�����䷴��ͼ�����������<br/>
 * 2.ʹ�ü���õ���˳�򣬶�ͼ���������������<br/>
 * 3.���б�ͬһ��dfs���ʵ��Ķ��㣬����ͬһ��ǿ��ͨ����
 * @author rays1
 *
 */
public class SCC {
    
    private boolean[] marked;           // ���ĳ�������Ƿ��Ѿ�������
    private Stack<Integer> reverPost;   // ���������
    private int[] id;
    private int count;
    
    public SCC(Digraph G) {
        // ��ʼ��
        marked = new boolean[G.V()];
        reverPost = new Stack<Integer>();
        id = new int[G.V()];
        // �������������
        Digraph Gr = G.reverse();
        for (int i = 0 ; i < Gr.V(); i++)
            if (!marked[i]) search(Gr, i);
        
        for (int i = 0; i < marked.length; i++) {
            marked[i] = false;
        }
        // �����������
        while (!reverPost.isEmpty()) {
            int v = reverPost.pop();
            if (!marked[v]) {
                dfs(G, v);
                count ++;
            }
        }
    }
    
    /**
     * �ж϶����Ƿ���ǿ��ͨ
     * @param v
     * @param w
     * @return
     */
    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }
    
    /**
     * ����ǿ��ͨ�����ĸ���
     * @return
     */
    public int count() {
        return count;
    }
    
    /**
     * ���ض���������ͨ�����ı�ʶ��
     * @return
     */
    public int[] id() {
        return id;
    }
    
    /**
     * �����㷨
     * 
     * @param G
     * @param v
     */
    private void search(Digraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w])
                search(G, w);
        }
        reverPost.push(v);
    }
    
    public void dfs(Digraph g, int s) {       // ������������㷨
        marked[s] = true;
        id[s]     = count;                  // id���ڼ�¼�ö���������һ����ͨ����
        for (int v : g.adj(s)) {
            if (!marked[v]) {
                dfs(g, v);
            }
        }
    }
    
}
