package com.rays.algo.search;

/**
 * 
 * @author rays1
 *
 */
public class UnionFind {
    
    private int[] parent;  // parent[i] = parent of i
    private int count;     // number of components

    public UnionFind(int n) {
        if (n < 0) throw new IllegalArgumentException();
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];    // path compression by halving
            p = parent[p];
        }
        return p;
    }


    public int count() {
        return count;
    }
  
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
  
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        // make root of smaller rank point to root of larger rank
        parent[rootQ] = rootP;
        count--;
    }
    
}
