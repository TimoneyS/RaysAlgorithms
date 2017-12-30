package com.rays.algo.graph.gd;

import java.util.Stack;

import com.ray.common.utils.Out;

/**
 * 搜索有向图的强连通分量<br/>
 * Kosaraju算法<br/>
 * 1.使用DiDFOrder计算其反向图的逆后序排列<br/>
 * 2.使用计算得到的顺序，对图进行深度优先搜索<br/>
 * 3.所有被同一个dfs访问到的顶点，都在同一个强连通分量
 * @author rays1
 * @证明
 *  已知：按照逆后续dfs(S)访问到dfs(V)<br/>
 *  推论1 ： S -> V 有路径<br/>
 *  推论2 ：反向图的深度优先搜索时，V比S先完成<br/>
 *  由推论2可得两种情况：<br/>
 *      情况1,先dfs(V)，完成后再dfs(S)<br/>
 *      情况2,先dfs(S)，未完成就进行dfs(V)<br/>
 *<br/>
 *      情况1：因为原图 S -> V 有路径，则反向图V -> S有路径;<br/>
 *              若此时S未被访问到，dfs(V)必然访问到S，则S比V先完成，矛盾<br/>
 *              若此时S已经被访问，因为V比S先完成，所以 dfs(S)必然会访问到dfs(V)，则和情况2一致<br/>
 *      情况2：说明S -> V 有路径，反推可得原图 V -> S 有路径<br/>
 *<br/>
 *      S -> V 有路径 && V -> S 有路径 => S 和 V 是强连通分量<br/>
 */
public class SCC {
    
    private boolean[] marked;           // 标记某个顶点是否已经被访问
    private Stack<Integer> reverPost;   // 逆后序排列
    private int[] id;
    private int count;
    
    public SCC(Digraph G) {
        // 初始化
        marked = new boolean[G.V()];
        reverPost = new Stack<Integer>();
        id = new int[G.V()];
        // 计算逆后序排列
        Digraph Gr = G.reverse();
        Out.p("反向图：");
        Out.p(Gr.toString());
        for (int i = 0 ; i < Gr.V(); i++)
            if (!marked[i]) search(Gr, i);
        
        for (int i = 0; i < marked.length; i++) {
            marked[i] = false;
        }
        // 深度优先搜索
        while (!reverPost.isEmpty()) {
            int v = reverPost.pop();
            Out.pt(v + " ");
            if (!marked[v]) {
                dfs(G, v);
                count ++;
            }
        }
        Out.p(" ");
    }
    
    /**
     * 判断顶点是否是强连通
     * @param v
     * @param w
     * @return
     */
    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }
    
    /**
     * 返回强连通分量的个数
     * @return
     */
    public int count() {
        return count;
    }
    
    /**
     * 返回顶点所在连通分量的标识符
     * @return
     */
    public int[] id() {
        return id;
    }
    
    /**
     * 搜索算法
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
    
    public void dfs(Digraph g, int s) {       // 深度优先搜索算法
        marked[s] = true;
        id[s]     = count;                    // id用于记录该顶点属于哪一个连通分量
        for (int v : g.adj(s)) {
            if (!marked[v]) {
                dfs(g, v);
            }
        }
    }
    
}

