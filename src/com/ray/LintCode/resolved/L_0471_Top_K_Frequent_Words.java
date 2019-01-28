package com.ray.LintCode.resolved;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import com.ray.io.Out;

/**
 *
 * 给定一个单词构成的列表和一个数字 k，返回前 k 个出现频率最高的单词
 *
 * 如：
 *  [
 *      "yes", "lint", "code",
 *      "yes", "code", "baby",
 *      "you", "baby", "chrome",
 *      "safari", "lint", "code",
 *      "body", "lint", "code"
 *  ]
 * 
 * 给定 k = 3 返回  code, lint, baby
 * 给定 k = 4 返回  code, lint, baby, yes
 *
 * 挑战:
 *      时间复杂度：O(nlogk)
 *      空间复杂度：O(n)
 * @author rays1
 *
 */
public class L_0471_Top_K_Frequent_Words {

    
    static class Solution {
    
        public String[] topKFrequentWords(String[] words, int k) {
            String[] rs = new String[k];
            
            Map<String, Integer> map = new HashMap<>();
            for (String word : words) {
                int c = map.containsKey(word) ? map.get(word) : 0;
                map.put(word, c+1);
            }
            
            PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());
            
            for (java.util.Map.Entry<String, Integer> entry : map.entrySet()) {
                pq.offer(new Pair(entry.getKey(), entry.getValue()));
            }
            
            for (int i = 0; i < k; i++)
                rs[i] = pq.poll().word;
            
            return rs;
        }

        class Pair {
            String word;
            int count;
            public Pair(String s, int i) {
                word = s; count = i;
            }
        }
        
        class PairComparator implements Comparator<Pair> {
            public int compare(Pair o1, Pair o2) {
                if (o1.count != o2.count) return Integer.compare(o2.count, o1.count);
                return o1.word.compareTo(o2.word);
            }
        }
        
    }
    
    public static void main(String[] args) {
        
        String[] words = {
                "yes", "lint", "code",
                "yes", "code", "baby",
                "you", "baby", "chrome",
                "safari", "lint", "code",
                "body", "lint", "code"
        };
        
        int k = 3;
        
        Out.p(new Solution().topKFrequentWords(words, k));
        
    }

}
