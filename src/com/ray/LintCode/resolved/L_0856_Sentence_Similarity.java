package com.ray.LintCode.resolved;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.ray.io.Out;

/**
 *
 *
 *
 * @author rays1
 *
 */
public class L_0856_Sentence_Similarity {

    static class Solution {
    
        public boolean isSentenceSimilarity(String[] words1, String[] words2, List<List<String>> pairs) {
            if (words1.length != words2.length) return false;
            
            Map<String, HashSet<String>> map = new HashMap<>();
            
            for (List<String> list : pairs) {
                String s1 = list.get(0);
                String s2 = list.get(1);
                map.putIfAbsent(s1, new HashSet<>());
                map.putIfAbsent(s2, new HashSet<>());
                map.get(s1).add(s2);
                map.get(s2).add(s1);
            }
            
            for (int i = 0; i < words1.length; i++) {
                if (!map.get(words1[i]).contains(words2[i])) return false;
            }
            
            return true;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
