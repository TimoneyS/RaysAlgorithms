package com.ray.graph.g;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.ray.utils.In;
import com.ray.utils.Out;

/**
 * ����ͼ
 * @author rays1
 *
 */
public class SymbolGraph {
    
    private Map<String, Integer> st; // ���ű������� -> ����
    private String[] keys;           // ���ű���ӿڣ����� -> ������
    private Graph G;                 // ����ͼ
    
    public SymbolGraph(String res, String delimiter) {
        st = new HashMap<String, Integer>();
        
        Scanner in = In.getProjectScanner(res);
        while (in.hasNextLine()) {                          // ��������
            String[] arr = in.nextLine().split(delimiter);
            Out.p(arr);
            for (int i = 0; i < arr.length; i++) {          
                if (!st.containsKey(arr[i]))                // ��ͬ���ַ�������ͬһ������
                    st.put(arr[i], st.size());
            }
        }

        keys = new String[st.size()];                       // ��������
        for (String name : st.keySet()) {
            keys[st.get(name)] = name;
        }
        
        G = new Graph(st.size());
        in = In.getProjectScanner(res);
        while (in.hasNextLine()) {                          // ����ͼ
            String[] arr = in.nextLine().split(delimiter);  // ÿһ�еĶ���͸��е�������������
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
