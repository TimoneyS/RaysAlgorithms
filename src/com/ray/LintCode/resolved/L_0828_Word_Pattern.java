package com.ray.LintCode.resolved;

import java.util.HashMap;
import java.util.Map;

import com.ray.io.Out;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * 
 * @author rays1
 *
 */
public class L_0828_Word_Pattern {

    static class Solution {
    
        public boolean wordPattern(String pattern, String teststr) {
            
            String[] arr = teststr.split(" ");
            Map<String, Character> map1 = new HashMap<>();
            Map<Character, String> map2 = new HashMap<>();
            
            int cursor = 0;
            for (String word : arr) {
                
                char c =  pattern.charAt(cursor++);
                
                if (map1.containsKey(word) && map2.containsKey(c)) {
                    if (map1.get(word) != c || !map2.get(c).equals(word)) return false;
                } else if (!map1.containsKey(word) && !map2.containsKey(c)) {
                    map1.put(word, c);
                    map2.put(c, word);
                } else {
                    return false;
                }
                
            }
            
            return true;
        }
    
    }
    
    public static void main(String[] args) {
        String pattern = "abba" , teststr = "dog cat cat dog";
        Out.p(new Solution().wordPattern(pattern, teststr));
        
    }

}
