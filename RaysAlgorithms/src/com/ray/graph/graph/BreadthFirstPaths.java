package com.ray.graph.graph;

import java.util.LinkedList;

import com.ray.graph.intf.Paths;

/**
 * ������������㷨<br>
 * �Ƚ���������У�Ȼ���ظ�һ�²���ֱ������Ϊ�� <br>
 * 1.ȡ���е���һ�����㣬����Ǹö��� <br>
 * 2.����v���ڵ�����δ����ǵĶ���������
 * 
 * @author rays1
 *
 */
public class BreadthFirstPaths implements Paths {

    private boolean[]           marked; // ���ĳ����������ʱ�Ƿ��Ѿ�������
    private int[]               edgeTo; // �����ĳ���һ���ڽӵ�
    private int                 s;      // ���
    private LinkedList<Integer> queue;

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        queue = new LinkedList<Integer>();
        this.s = s;
        search(G, s);
    }

    public void search(Graph G, int s) {
        queue.add(s);
        marked[s] = true;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.add(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public LinkedList<Integer> pathTo(int v) {
        if (!marked[v])
            return null;
        LinkedList<Integer> list = new LinkedList<Integer>();

        for (int x = v; x != s; x = edgeTo[x]) {
            list.push(x);
        }
        list.push(s);
        return list;
    }

}
