package com.rays.algo.graph.g;

/**
 * �����������<br>
 * ����һ��ͼ����һ���ݹ鷽�����������ж��㣬�ڷ�������һ������ʱ��<br>
 * 1.������Ϊ�ѷ���<br>
 * 2.�ݹ�ķ�����δ�����ʵ��ھӽڵ�<br>
 * 
 * @author rays1
 *
 */
public class DeepthFirstSearch {

    private boolean[] marked;   // ���ĳ�������Ƿ��Ѿ�������

    public DeepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        search(G, s);
    }

    public void search(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                search(G, w);
            }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }

}
