package com.rays.ago.graph.g;

/**
 * ����ͼ�е���ͨ����
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
     * ��������
     * @param G
     */
    public void find(Graph G) {
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]) {               // ������δ����ǣ���������Ϊ 1����һ�β�ѯ��2��֮ǰ�Ĳ�ѯû�б������ö���
                dfs(G, i);                  // �����ö���
                count ++;                   // �ö���������ϣ�����1����2���������ö���λ���µ���ͨ����֮�У���˼���+1
            }
        }
    }
    
    public void dfs(Graph g, int s) {       // ������������㷨
        marked[s] = true;
        id[s]     = count;                  // id���ڼ�¼�ö���������һ����ͨ����
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
