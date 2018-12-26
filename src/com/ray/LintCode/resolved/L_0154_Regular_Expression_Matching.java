package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.ray.io.Out;

/**
 * Implement regular expression matching with support for '.' and '*'.
 *
 * @author rays1
 *
 */
public class L_0154_Regular_Expression_Matching {
    static class Solution {
        
        class DFS {
            
            boolean[] marked;
            
            public DFS(Reg G, int s) {
                marked = new boolean[G.V];
                dfs(G, s);
            }
            
            public DFS(Reg G, Iterable<Integer> sources) {
                marked = new boolean[G.V];
                for (int v : sources)
                    if (!marked[v]) dfs(G, v);
            }

            private void dfs(Reg G, int v) {
                marked[v] = true;
                for (int w : G.adj[v])
                    if (!marked[w]) dfs(G, w);
            }
            
            boolean marked(int V) {
                return marked[V];
            }
            
        }
        
        class Reg {
            
            ArrayList<Integer>[] adj;
            int V;
            char[] re;
            int M;
            
            @SuppressWarnings("unchecked")
            public Reg(String pat) {
                M = pat.length();
                re = pat.toCharArray();
                V = M+1;
                
                adj = new ArrayList[V];
                for (int i = 0; i < adj.length; i++) {
                    adj[i] = new ArrayList<>();
                }
                
                for (int i = 0; i < M; i ++) {
                    if (re[i] == '*' && i != 0) {
                        adj[i].add(i+1);
                        adj[i-1].add(i);
                        adj[i].add(i-1);
                    }
                }
            }
            
            boolean match(String txt) {
                Set<Integer> pc = new HashSet<>();
                Set<Integer> match = new HashSet<>();
                
                DFS dfs = new DFS(this, 0);
                for (int i = 0; i < V; i++) {
                    if (dfs.marked(i)) {
                        pc.add(i);
                    }
                }
                
                Out.p(pc);
                
                for (int i = 0; i < txt.length(); i++) {
                    Out.sep();
                    match.clear();
                    for (int v : pc) {
                        if ( v < M && (txt.charAt(i) == re[v] || re[v] == '.')) {
                            match.add(v+1);
                        }
                    }
                    Out.p(match);
                    
                    pc.clear();
                    dfs = new DFS(this, match);
                    for (int v = 0; v < V; v++) {
                        if (dfs.marked(v)) pc.add(v);
                    }
                    
                    Out.p(pc);
                }
                
                return pc.contains(M);
            }
            
        }
        
        public boolean isMatch(String txt, String pat) {
            return new Reg(pat).match(txt);
        }
        
    }
    
    public static void main(String[] args) {
        
        String txt = "bbabacccbcbbcaaab";
        String pat = "*a*b..b*b";
        
        boolean rs = new Solution().isMatch(txt, pat);
        
        Out.p(rs);
        
    }
    
}
