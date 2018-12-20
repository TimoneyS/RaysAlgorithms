package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UndirectedGraphNode {
    public int                     label;
    public ArrayList<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
    
    public static UndirectedGraphNode parse(String s) {
        
        Map<Integer, UndirectedGraphNode> temp = new HashMap<>();
        UndirectedGraphNode start = null;
        
        for (String line : s.substring(1, s.length()-1).split("#")) {
            Scanner sc = new Scanner(line);
            sc.useDelimiter(",");
            UndirectedGraphNode n = getCacheNode(sc.nextInt(), temp);
            if (start == null) start = n;
            while (sc.hasNextInt()) {
                UndirectedGraphNode n2 = getCacheNode(sc.nextInt(), temp);
                n.neighbors.add(n2);
            }
            sc.close();
        }
        
        return start;
    }
    
    private static UndirectedGraphNode getCacheNode(Integer key, Map<Integer, UndirectedGraphNode> cache) {
        UndirectedGraphNode node = cache.get(key);
        if (node == null) {
            node = new UndirectedGraphNode(key);
            cache.put(key, node);
        }
        return node;        
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append('[').append(label);
        for (UndirectedGraphNode n : neighbors) {
            sb.append(',').append(n.label);
        }
        sb.append(']');
        return sb.toString();
    }
    
}