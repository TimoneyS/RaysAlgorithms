package com.ray.leetcode.util;

import java.util.*;

public class GraphNode {
    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node () {
            neighbors = new ArrayList<>();
        }

        public Node(int x) {
            this();
            val = x;
        }

        public static Node parse(int[][] arr) {
            Node[] nodes = new Node[arr.length+1];

            for (int v = 1; v <= arr.length; v ++) {
                if (nodes[v] == null) {
                    nodes[v] = new Node(v);
                }
                for (int w : arr[v-1]) {
                    if (nodes[w] == null) {
                        nodes[w] = new Node(w);
                    }
                    nodes[v].neighbors.add(nodes[w]);
                    nodes[w].neighbors.add(nodes[v]);
                }
            }
            return nodes[1];
        }

        public static Node parse(String s) {
            Map<Integer, Node> temp = new HashMap<>();
            Node start = null;
            for (String line : s.substring(1, s.length()-1).split("#")) {
                Scanner sc = new Scanner(line);
                sc.useDelimiter(",");
                Node n = getCacheNode(sc.nextInt(), temp);
                if (start == null) start = n;
                while (sc.hasNextInt()) {
                    Node n2 = getCacheNode(sc.nextInt(), temp);
                    n.neighbors.add(n2);
                }
                sc.close();
            }
            return start;
        }

        private static Node getCacheNode(Integer key, Map<Integer, Node> cache) {
            Node node = cache.get(key);
            if (node == null) {
                node = new Node(key);
                cache.put(key, node);
            }
            return node;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[').append(val);
            for (Node n : neighbors) {
                sb.append(',').append(n.val);
            }
            sb.append(']');
            return sb.toString();
        }

    }
}
