package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.ray.io.Out;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * 
 * Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"].
 * Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].
 * 
 * @author rays1
 *
 */
public class L_0171_Anagrams {

    static class Solution {
        public List<String> anagrams(String[] strs) {
            HashMap<String, Integer> map = new HashMap<>();
            List<String> rs = new ArrayList<>();
            
            for (String s : strs) {
                String key = toKey(s);
                Integer c = map.get(key);
                if (c == null)
                    map.put(key, 1);
                else
                    map.put(key, c+1);
            }       
            
            for (String s : strs) {
                String key = toKey(s);
                int c = map.get(key);
                if (c  > 1) {
                    rs.add(s);
                }
            }
            
            return rs;
        }
        
        private String toKey(String strs) {
            int[] count = new int[26]; 
            for (int i = 0; i < strs.length(); i++) {
                count[strs.charAt(i)-97]++;
            }
            return Arrays.toString(count);
        }
        
    }
    
    public static void main(String[] args) {
        
        String[] strs = {
                "ab","ba","ac","ca"
        };
        
        Solution sol = new Solution();
        List<String> list = sol.anagrams(strs);
        
        Out.p(list);
        
    }

}
