package com.ray.LintCode.done;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.ray.io.Out;

/**
 * 描述：
 *      Given two words (*start* and *end*), and a dictionary, find the shortest transformation sequence from *start* to *end*, output the length of the sequence.
 *      Transformation rule such that:
 *      
 *      1. Only one letter can be changed at a time
 *      2. Each intermediate word must exist in the dictionary. (Start and end words do not need to appear in the dictionary )
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：start = "a"，end = "c"，dict =["a","b","c"]
 *      Output：2
 *      Explanation：
 *      "a"->"c"
 *      ```
 *      
 *      
 *      **Example 2:**
 *      ```
 *      Input：start ="hit"，end = "cog"，dict =["hot","dot","dog","lot","log"]
 *      Output：5
 *      Explanation：
 *      "hit"->"hot"->"dot"->"dog"->"cog"
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/word-ladder/description
 * @date   2019-07-11 18:30:49
 */
public class L_0120_Word_Ladder {

    static class Solution {
        
        public int ladderLength(String start, String end, Set<String> dict) {
            
            dict.add(end);
            
            Map<String, Integer> distTo = new HashMap<>();
            Queue<String> queue = new ArrayDeque<>();
            
            queue.add(start);
            distTo.put(start, 1);
            
            while (!queue.isEmpty()) {
                
                String curr = queue.poll();
                int baseDist = distTo.get(curr);
                if (curr == end) break;
                
                Iterator<String> ite = dict.iterator();
                while (ite.hasNext()) {
                    String s = ite.next();
                    int d = diff(s, curr);
                    if (d <= 1) {
                        queue.add(s);
                        ite.remove();
                        distTo.put(s, baseDist+d);
                    }
                }
                
            }
            return distTo.get(end);
        }
        
        private int diff(String s1, String s2) {
            int c = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) c++;
                if (c >= 2) break;
            }
            return c;
        }
        
    }
    
    public static void main(String[] args) {
        String start = "a";
        String end = "a";
        String[] dictArr = {"b"};
        
        Set<String> dict = new HashSet<>();
        for (String s : dictArr) dict.add(s);
        
        Out.p(new Solution().ladderLength(start, end, dict));
    }

}
