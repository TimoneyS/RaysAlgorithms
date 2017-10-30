package com.ray.graph;

import java.util.Stack;

import com.ray.utils.Out;

/**
 * 拓扑排序
 * @author rays1
 *
 */
public class DiDFOrder {
    private static int level = 0;
    private boolean[] marked; // 标记某个顶点是否已经被访问
    private Stack<Integer> reverPost;

    public DiDFOrder(Digraph G) {
        marked = new boolean[G.V()];
        reverPost = new Stack<Integer>();
        for (int i = 0 ; i < G.V(); i++)
            if (!marked[i]) search(G, i);
    }

    /**
     * 搜索算法
     * 
     * @param G
     * @param v
     */
    public void search(Digraph G, int v) {
        marked[v] = true;
        level ++;
        Out.pf("%" + level*2 + "sdfs("+v+")\n", " ");
        for (int w : G.adj(v)) {
            if (!marked[w])
                search(G, w);
        }
        Out.pf("%" + level*2 + "s"+v+"done\n", " ");
        level --;
        reverPost.push(v);
    }
    
    public Stack<Integer> reverPost() {
        return reverPost;
    }
    
}
