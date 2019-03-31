package com.ray.LintCode.resolved;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import com.ray.io.Out;

/**
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. 
 * You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language.
 * Derive the order of letters in this language.
 *     1. You may assume all letters are in lowercase.
 *     2. You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
 *     3. If the order is invalid, return an empty string.
 *     4. There may be multiple valid order of letters, return the smallest in lexicographical order
 *
 * @author rays1
 * @url    https://www.lintcode.com/problem/alien-dictionary/description
 * @date   2019-03-30 18:42:10
 */
public class L_0892_Alien_Dictionary {

    /**
     * 本题的难点在于想到，只有前缀相同的相邻单词才能够确定字母顺序
     * 因此在构造图的时候，只需要构建前缀相同的字符的边即可（首字母默认前缀相同）。
     * 
     * @author rays1
     *
     */
    static class Solution {
        public String alienOrder(String[] words) {
            Map<Character, Set<Character>> graph = constructGraph(words);
            
            Out.p(graph);
            
            return topologicalSorting(graph);
        }
        
            
        private Map<Character, Set<Character>> constructGraph(String[] words) {
            Map<Character, Set<Character>> graph = new HashMap<>();
            
            // create nodes
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words[i].length(); j++) {
                    char c = words[i].charAt(j);
                    if (!graph.containsKey(c)) {
                        graph.put(c, new HashSet<Character>());
                    }
                }
            }
            
            // create edges
            for (int i = 0; i <  words.length - 1; i++) {
                int index = 0;
                while (index < words[i].length() && index < words[i + 1].length()) {
                    if (words[i].charAt(index) != words[i + 1].charAt(index)) {
                        graph.get(words[i].charAt(index)).add(words[i + 1].charAt(index));
                        break;
                    }
                    index++;
                }
            }

            return graph;
        }
        
        private Map<Character, Integer> getIndegree(Map<Character, Set<Character>> graph) {
            Map<Character, Integer> indegree = new HashMap<>();
            for (Character u : graph.keySet()) {
                indegree.put(u, 0);
            }
            
            for (Character u : graph.keySet()) {
                for (Character v : graph.get(u)) {
                    indegree.put(v, indegree.get(v) + 1);
                }
            }     
            
            return indegree;
        }

        private String topologicalSorting(Map<Character, Set<Character>> graph) {
            Map<Character, Integer> indegree = getIndegree(graph);
            // as we should return the topo order with lexicographical order
            // we should use PriorityQueue instead of a FIFO Queue
            Queue<Character> queue = new PriorityQueue<>();
            
            for (Character u : indegree.keySet()) {
                if (indegree.get(u) == 0) {
                    queue.offer(u);
                }
            }
            
            StringBuilder sb = new StringBuilder();
            while (!queue.isEmpty()) {
                Character head = queue.poll();
                sb.append(head);
                for (Character neighbor : graph.get(head)) {
                    indegree.put(neighbor, indegree.get(neighbor) - 1);
                    if (indegree.get(neighbor) == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
            
            if (sb.length() != indegree.size()) {
                return "";
            }
            return sb.toString();
        }
    }
    
    public static void main(String[] args) {
        
        String[] words = {
                "cba"
        };
        
        Out.p(new Solution().alienOrder(words));
        
    }

}
