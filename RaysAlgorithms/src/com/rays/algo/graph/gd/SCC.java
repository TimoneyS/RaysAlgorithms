package com.rays.algo.graph.gd;

import java.util.Stack;

import com.ray.common.utils.Out;

/**
 * ��������ͼ��ǿ��ͨ����<br/>
 * Kosaraju�㷨<br/>
 * 1.ʹ��DiDFOrder�����䷴��ͼ�����������<br/>
 * 2.ʹ�ü���õ���˳�򣬶�ͼ���������������<br/>
 * 3.���б�ͬһ��dfs���ʵ��Ķ��㣬����ͬһ��ǿ��ͨ����
 * @author rays1
 * @֤��
 *  ��֪�����������dfs(S)���ʵ�dfs(V)<br/>
 *  ����1 �� S -> V ��·��<br/>
 *  ����2 ������ͼ�������������ʱ��V��S�����<br/>
 *  ������2�ɵ����������<br/>
 *      ���1,��dfs(V)����ɺ���dfs(S)<br/>
 *      ���2,��dfs(S)��δ��ɾͽ���dfs(V)<br/>
 *<br/>
 *      ���1����Ϊԭͼ S -> V ��·��������ͼV -> S��·��;<br/>
 *              ����ʱSδ�����ʵ���dfs(V)��Ȼ���ʵ�S����S��V����ɣ�ì��<br/>
 *              ����ʱS�Ѿ������ʣ���ΪV��S����ɣ����� dfs(S)��Ȼ����ʵ�dfs(V)��������2һ��<br/>
 *      ���2��˵��S -> V ��·�������ƿɵ�ԭͼ V -> S ��·��<br/>
 *<br/>
 *      S -> V ��·�� && V -> S ��·�� => S �� V ��ǿ��ͨ����<br/>
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
        Out.p("����ͼ��");
        Out.p(Gr.toString());
        for (int i = 0 ; i < Gr.V(); i++)
            if (!marked[i]) search(Gr, i);
        
        for (int i = 0; i < marked.length; i++) {
            marked[i] = false;
        }
        // �����������
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
        id[s]     = count;                    // id���ڼ�¼�ö���������һ����ͨ����
        for (int v : g.adj(s)) {
            if (!marked[v]) {
                dfs(g, v);
            }
        }
    }
    
}

