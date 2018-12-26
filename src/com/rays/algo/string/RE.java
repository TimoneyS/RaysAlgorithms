package com.rays.algo.string;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import com.ray.io.Out;
import com.ray.util.Timer;
import com.rays.algo.graph.Digraph;
import com.rays.algo.graph.g.DirectedDFS;

/**
 * 正则表达式
 * 
 * @author rays1
 *
 */
public class RE {
    
    private Digraph G;
    private int M;
    private char[] re;
    
    public RE(String reg) {
        
        Stack<Integer> ops = new Stack<>();
        re = reg.toCharArray();
        M = re.length;
        G = new Digraph(M+1);
        
        for (int i = 0; i < M; i++) {
            int lp = i;
            if (re[i] == '(' || re[i] == '|')
                ops.push(i);
            else if (re[i] == ')') {
                Stack<Integer> orNext = new Stack<>();
                while (!ops.isEmpty()) {
                    int or = ops.pop();
                    if (re[or] == '|') {
                        G.addEdge(or, i);
                        orNext.push(or+1);
                    } else if (re[or] == '(') {
                        lp = or;
                        while (!orNext.isEmpty()) {
                            G.addEdge(lp, orNext.pop());
                        }
                        break;
                    }
                }
            } else if (re[i] == '\\') {
                i++;
            }

            // 试探下一个字符是否是闭包运算符
            if (i < M - 1 && re[i+1] == '*') {
                G.addEdge(lp, i + 1);
                G.addEdge(i + 1, lp);
            }
            
            // 元字符增加红色指出边
            if (re[i] == '(' || re[i] == '*' || re[i] == ')')
                G.addEdge(i, i + 1);
        }
        
    }
    
    /**
     * 
     * @return
     */
    public boolean match(String txt) {
        
        Set<Integer> pc = new HashSet<>();
        Set<Integer> match = new HashSet<>();
        DirectedDFS dfs = new DirectedDFS(G, 0);
        
        // 计算状态 0 空匹配的抵达的状态
        for (int v = 0; v < G.V(); v ++)
            if (dfs.marked(v)) pc.add(v);
        
        for (int i = 0; i < txt.length(); i ++) {
            
            // 计算 set 中状态 匹配转换 可抵达的状态集合 match
            match.clear();
            for (int v : pc) {
                if (v < M && (re[v] == txt.charAt(i) || re[v] == '.'))
                    match.add(v+1);
                // 处理通配符
                if (v < M-1 && re[v] == '\\') {
                    if (re[v+1] == 'd' || re[v+1] == 'D') {
                        boolean is_d =  txt.charAt(i) > 47 && txt.charAt(i) < 58;
                        if (is_d == (re[v+1] == 'd')) {
                            match.add(v+2);
                        }
                    } else if (re[v+1] == 's' || re[v+1] == 'S') {
                        
                    } else if (re[v+1] == 'w' || re[v+1] == 'W') {
                        boolean is_w = txt.charAt(i) > 64 && txt.charAt(i) < 123;
                        if (is_w == (re[v+1] == 'w')) {
                            match.add(v+2);
                        }
                    } else if (re[v+1] == txt.charAt(i)) {
                        match.add(v+2);
                    }
                }
            
            }
            
            // 计算 match 中状态 通过 空匹配可抵达的状态 (包含了 match 自身集合)
            pc.clear();
            dfs = new DirectedDFS(G, match);
            for (int v = 0; v < G.V(); v++) {
                if (dfs.marked(v)) pc.add(v);
            }
            
        }
        
        if (pc.contains(M)) return true;
        return false;
    }
    
    public static void main(String[] args) {
        RE r = new RE("(\\d*\\w*)");
        Timer.CLICK();
        boolean rs = r.match("123abcd");
        Timer.STOP();
        Out.p(rs);
    }
    
}
