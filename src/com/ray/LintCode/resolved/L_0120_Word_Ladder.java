package com.ray.LintCode.resolved;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.ray.io.Out;

/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end,
 * such that:
 *      Only one letter can be changed at a time
 *      Each intermediate word must exist in the dictionary
 *      
 * 给定两个单词 起点和终点，和一个字典，找到起点到终点的最短转换序列
 *      每次只能转换一个字母
 *      每次的中继单词必须在字典中
 *      
 * dict = ["hot","dot","dog","lot","log"]
 * start = "hit"
 * end = "cog"
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return 5
 * @author rays1
 *
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
