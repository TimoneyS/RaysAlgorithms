package com.ray.LintCode.done;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a list of words and an integer k, return the top k frequent words in the list.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input:
 *        [
 *          "yes", "lint", "code",
 *          "yes", "code", "baby",
 *          "you", "baby", "chrome",
 *          "safari", "lint", "code",
 *          "body", "lint", "code"
 *        ]
 *        k = 3
 *      Output: ["code", "lint", "baby"]
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input:
 *        [
 *          "yes", "lint", "code",
 *          "yes", "code", "baby",
 *          "you", "baby", "chrome",
 *          "safari", "lint", "code",
 *          "body", "lint", "code"
 *        ]
 *        k = 4
 *      Output: ["code", "lint", "baby", "yes"]
 *      ```
 *
 * 挑战：
 *      Do it in O(nlogk) time and O(n) extra space.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/top-k-frequent-words/description
 * @date   2019-07-11 18:33:23
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
        
        Out.p(new Solution());
        
    }

}
