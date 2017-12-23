package com.ray.graph.g;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.ray.utils.In;
import com.ray.utils.Out;

/**
 * 符号图
 * @author rays1
 *
 */
public class SymbolGraph {
    
    private Map<String, Integer> st; // 符号表，符号名 -> 索引
    private String[] keys;           // 符号表反向接口，索引 -> 符号名
    private Graph G;                 // 无向图
    
    public SymbolGraph(String res, String delimiter) {
        st = new HashMap<String, Integer>();
        
        Scanner in = In.getProjectScanner(res);
        while (in.hasNextLine()) {                          // 构造索引
            String[] arr = in.nextLine().split(delimiter);
            Out.p(arr);
            for (int i = 0; i < arr.length; i++) {          
                if (!st.containsKey(arr[i]))                // 不同的字符串关联同一个索引
                    st.put(arr[i], st.size());
            }
        }

        keys = new String[st.size()];                       // 反向索引
        for (String name : st.keySet()) {
            keys[st.get(name)] = name;
        }
        
        G = new Graph(st.size());
        in = In.getProjectScanner(res);
        while (in.hasNextLine()) {                          // 构造图
            String[] arr = in.nextLine().split(delimiter);  // 每一行的顶点和该行的其他顶点相连
            int v = index(arr[0]);
            for (int i = 1; i < arr.length; i++)
                G.addEdge(v, index(arr[i]));
        }
        
    }
    
    public boolean contains(String key) { return st.containsKey(key); }
    public int index(String key) { return st.get(key); }
    public String name(int v) { return keys[v]; }
    public Graph G() { return G;}
    
}
