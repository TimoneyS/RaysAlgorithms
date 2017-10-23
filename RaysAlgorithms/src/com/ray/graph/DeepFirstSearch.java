package com.ray.graph;

import com.ray.graph.intf.Search;

/**
 * 深度优先搜索<br>
 * 搜索一幅图，用一个递归方法来遍历所有顶点，在访问其中一个顶点时：<br>
 * 1.将其标记为已访问<br>
 * 2.递归的访问其未被访问的邻居节点<br>
 * 
 * @author rays1
 *
 */
public class DeepFirstSearch extends Search {

    private boolean[] marked;   // 标记某个顶点是否已经被访问
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
