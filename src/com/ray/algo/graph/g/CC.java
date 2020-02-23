package com.ray.algo.graph.g;

import com.ray.algo.graph.Graph;

/**
 * 搜索图中的连通分量
 * @author rays1
 *
 */
public class CC {

    private boolean marked[];
    private int[] id;
    private int count;
    
    public CC(Graph G) {
        marked = new boolean[G.V()];
        id     = new int[G.V()];
        count  = 0;
        find(G);
    }
    
    /**
     * 搜索方法
     * @param G
     */
    public void find(Graph G) {
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]) {               // 若顶点未被标记，可能是因为 1，第一次查询；2，之前的查询没有遍历到该顶点
                dfs(G, i);                  // 搜索该顶点
                count ++;                   // 该顶点搜索完毕，无论1还是2，都表明该顶点位于新的连通分量之中，因此计数+1
            }
        }
    }
    
    /**
     * 深度优先搜索算法
     * @param g
     * @param s
     */
    private void dfs(Graph g, int s) {
        marked[s] = true;
        id[s]     = count;                  // id用于记录该顶点属于哪一个连通分量
        for (int v : g.adj(s)) {
            if (!marked[v]) {
                dfs(g, v);
            }
        }
    }

    public int[] getId() {
        return id;
    }

    public int getCount() {
        return count;
    }
    
}
