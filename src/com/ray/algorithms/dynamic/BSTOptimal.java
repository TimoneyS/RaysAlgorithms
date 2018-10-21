package com.ray.algorithms.dynamic;

import com.ray.io.Out;
import com.ray.util.RString;

/**
 * 最优二叉搜索树问题
 * @author rays1
 *
 */
public class BSTOptimal {
    
    private double[] p;
    private double[] q;
    
    public double w(int i, int j) {
        double w = 0;
    
        for (int l = i; l <= j; l ++) {
            w += p[l];
        }
        
        for (int l = i-1; l <= j; l ++) {
            w += q[l];
        }
        
        return w;
    }
    
    public class BSTMemorized {
        
        int[][] root;
        
        public BSTMemorized(double[] p, double[] q) {
            
            int n = p.length - 1;
            root = new int[n+1][n+1];
            
            for (int i = 1; i <= n; i++ ) {
                
                for (int j = i; j <= n; j ++) {
                    root[i][j] = -1;
                }
                
            }
            
            BSTOptimal.this.p = p;
            BSTOptimal.this.q = q;
            
            double e = e(1, n);
            
            Out.p(e); 
            Node rootNode = buildTree(1, n);
            showTree(rootNode, 1);
        }
        
        public double e(int i, int j) {
            if (j < i) return q[i-1];
            double e = Double.POSITIVE_INFINITY;
            double w = w(i, j);
            for (int r = i; r <= j; r ++) {
                double temp = e(i, r-1) + e(r+1, j) + w;
                if (e > temp) {
                    e = temp;
                    root[i][j] = r;
                }
            }
            return e;
        }
        
        public Node buildTree(int i, int j) {
            
            if (i > j) {
                Node n = new Node();
                n.key = "D" + (i-1);
                return n;
            }
            
            int r = root[i][j];
            
            Node rootNode = new Node();
            
            rootNode.key = "K" + r;
            
            rootNode.left = buildTree(i, r-1);
            rootNode.right = buildTree(r+1, j);
            
            return rootNode;
            
        }
        
        public void showTree(Node rootNode, int deepth) {
            
            if (rootNode == null)
                return;
            
            String suffix = RString.multiString("  ", deepth);
            
            showTree(rootNode.right, deepth+1);
            Out.p(suffix + rootNode.key);
            showTree(rootNode.left, deepth+1);            
            
            
        }
        
    }
    
    private class Node {
        String key;
        Node left;
        Node right;
    }
    
    public static void main(String[] args) {
        
        double[] p = { 0.00, 0.15, 0.10, 0.05, 0.10, 0.20};
        double[] q = { 0.05, 0.10, 0.05, 0.05, 0.05, 0.10};
        
        new BSTOptimal().new BSTMemorized(p, q);
        
    }
    
}
