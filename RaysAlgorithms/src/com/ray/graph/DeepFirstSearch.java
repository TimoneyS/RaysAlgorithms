package com.ray.graph;

import com.ray.graph.intf.Search;

/**
 * �����������<br>
 * ����һ��ͼ����һ���ݹ鷽�����������ж��㣬�ڷ�������һ������ʱ��<br>
 * 1.������Ϊ�ѷ���<br>
 * 2.�ݹ�ķ�����δ�����ʵ��ھӽڵ�<br>
 * 
 * @author rays1
 *
 */
public class DeepFirstSearch extends Search {

    private boolean[] marked;   // ���ĳ�������Ƿ��Ѿ�������
    private int       count;    

    public DeepFirstSearch(Graph G, int s) {
        super(G, s);
        marked = new boolean[G.V()];
        search(G, s);
    }

    public void search(Graph G, int v) {
        marked[v] = true;
        count++;
        for (int w : G.adj(v))
            if (!marked[w])
                search(G, w);
    }

    public boolean marked(int v) {
        return marked[v];
    }

    public int count() {
        return count;
    }

}
