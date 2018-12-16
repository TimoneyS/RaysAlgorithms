package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.ray.io.Out;

public class DirectedGraphNode {
    public int                          label;
    public ArrayList<DirectedGraphNode> neighbors;

    public DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<DirectedGraphNode>();
    }
    
    @Override
    public String toString() {
        return String.valueOf(label);
    }
    
    public static ArrayList<DirectedGraphNode> parse(String s) {
        
        ArrayList<DirectedGraphNode> graph = new ArrayList<>();
        Map<Integer, DirectedGraphNode> temp = new HashMap<>();
        
        for (String line : s.substring(1, s.length()-1).split("#")) {
            Scanner sc = new Scanner(line);
            sc.useDelimiter(",");
            DirectedGraphNode n = getNodeFormTemp(sc.nextInt(), temp, graph);
            while (sc.hasNextInt()) {
                DirectedGraphNode n2 = getNodeFormTemp(sc.nextInt(), temp, graph);
                n.neighbors.add(n2);
            }
            sc.close();
        }
        
        return graph;
    }
    
    private static DirectedGraphNode getNodeFormTemp(Integer key, Map<Integer, DirectedGraphNode> temp, ArrayList<DirectedGraphNode> graph) {
        DirectedGraphNode node = temp.get(key);
        if (node == null) {
            node = new DirectedGraphNode(key);
            graph.add(node);
            temp.put(key, node);
        }
        return node;        
    }
    
    public static String serialize(ArrayList<DirectedGraphNode> graph) {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (DirectedGraphNode n1 : graph) {
            if (n1.neighbors.size() == 0) continue;
            sb.append(n1.label);
            for (DirectedGraphNode n2 : n1.neighbors) {
                sb.append(',');
                sb.append(n2.label);
            }
            sb.append('#');
        }
        sb.deleteCharAt(sb.lastIndexOf("#"));
        sb.append('}');
        return sb.toString();
    }
    
    public static void main(String[] args) {
        ArrayList<DirectedGraphNode> graph = parse("{0,1,2,3#1,4#2,4,5#3,4,5}");
        
        Out.p(serialize(graph));
        
    }
    
}