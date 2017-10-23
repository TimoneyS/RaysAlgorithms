package com.ray.graph;

/**
 * 搜索图中的连通分量
 * @author rays1
 *
 */
public class CC {

    private boolean marked[];
    private int[] id;
    private int count;
    
    public CC(Graph g) {
        marked = new boolean[g.V()];
        id     = new int[g.V()];
        count  = 0;
        find(g);
    }
    
    public void find(Graph g) {
        for (int i = 0; i < g.V(); i++) {
            if (!marked[i]) {
                dfs(g, i);
                count ++;
            }
        }
    }
    
    public void dfs(Graph g, int s) {
        marked[s] = true;
        id[s]     = count;
        for (int v : g.adj(s)) {
            if (!marked[v]) {
                dfs(g, v);
            }
        }
    }

    public boolean[] getMarked() {
        return marked;
    }

    public int[] getId() {
        return id;
    }

    public int getCount() {
        return count;
    }
    
}
