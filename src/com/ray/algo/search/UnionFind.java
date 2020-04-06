package com.ray.algo.search;

import com.ray.io.Out;

public class UnionFind {
    
    private int[] parent;  // parent[i] = parent of i
    private int count;     // number of components
    
    public int count() { return count; }
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];    // 压缩路径
            p = parent[p];
        }
        return p;
    }
  
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        // 合并两个分支
        parent[rootQ] = rootP;
        count--;
    }
    
    public static void main(String[] args) {
        
        UnionFind uf = new UnionFind(5);
        
        uf.union(1, 2);
        Out.p(uf.parent);
        uf.union(3, 4);
        Out.p(uf.parent);
        uf.union(1, 4);
        Out.p(uf.parent);
        
        uf.find(4);
        Out.p(uf.parent);
        
    }
    
}
