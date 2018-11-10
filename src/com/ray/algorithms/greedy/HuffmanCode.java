package com.ray.algorithms.greedy;

import java.util.Random;

import com.ray.io.Out;
import com.ray.util.collections.RaysMinPQ;

/**
 * ºÕ·òÂü±àÂë
 * @author rays1
 *
 */
public class HuffmanCode {

    static class Node implements Comparable<Node> {
        char c;
        int freq;
        Node left;
        Node right;
        
        public static Node node(char c, int f) {
            Node n = new Node();
            n.c = c;
            n.freq = f;
            return n;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(freq, o.freq);
        }
    }
    
    public HuffmanCode(String s) {
        
        Node[] nodes = buildNodes(s);
        
        RaysMinPQ<Node> pq = new RaysMinPQ<Node>();
        for (int i = 0; i < nodes.length; i++) {
            pq.insert(nodes[i]);
        }
        
        for (int i = 0; i < nodes.length - 1; i ++) {
            Node node = new Node();
            
            node.left = pq.delMin();
            node.right = pq.delMin();
            node.freq = node.left.freq + node.right.freq;
            
            pq.insert(node);
        }
        
        Node root = pq.delMin();
        
        showCode(root, 0);
        
        Out.p("Huffman  Code Cost : " + cost(root, 1));
        Out.p("Fixlenth Code Cost : " + s.length()*8);
    }
    
    private int cost(Node root, int deepth) {
        if (root.left == null && root.right == null)
            return root.freq * deepth;
        return cost(root.left, deepth + 1) + cost(root.right, deepth + 1);
    }
    
    private Node[] buildNodes(String s) {
        
        int[] freq = new int[256];
        
        for (char c : s.toCharArray()) {
            freq[c] ++;
        }
        
        Node[] node = new Node[256];
        int cursor = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == -1 || freq[i] == 0) continue;
            node[cursor++] = Node.node((char) i, freq[i]);
        }
        
        Node[] temp = new Node[cursor];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = node[i];
        }
        
        return temp;
    }
    
    public void showCode(Node root, int baseCode) {
        
        if (root.left == null && root.right == null) {
            Out.p(root.c + " : " + Integer.toBinaryString(baseCode));
        } else {
            showCode(root.left, (baseCode << 1) + 0);
            showCode(root.right, (baseCode << 1) + 1);            
        }
        
    }
    
    public static void main(String[] args) throws Exception {
        
//        String s = "abccdddeeeeeffffffffggggggggggggghhhhhhhhhhhhhhhhhhhhh";
        
        int length = 10000;
        Random r = new Random(47);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append((char)(r.nextInt(255)));
        }
        
        new HuffmanCode(sb.toString());
        
    }
    
}
