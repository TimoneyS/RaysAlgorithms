package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ray.io.Out;

/**
 * 给一字符串数组, 将 错位词(指相同字符不同排列的字符串) 分组
 *
 * @author rays1
 *
 */
public class L_0772_Group_Anagrams {

    static class Solution {
    
        public List<List<String>> groupAnagrams(String[] strs) {
            
            for (String s : strs)
                Out.pf("hash(%s) = %s\n", hash(s), s);
            
            
            Map<Integer, List<String>> map = new HashMap<>();
            for (String s : strs) {
                int h = hash(s);
                map.putIfAbsent(h, new ArrayList<>());
                map.get(h).add(s);
            }
            
            List<List<String>> rs = new ArrayList<>();
            for (List<String> l : map.values())
                rs.add(l);
            return rs;
        }

        private int hash(String s) {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i)-'a'] ++;
            }
            return Arrays.toString(count).hashCode();
        }
    
    }
    
    public static void main(String[] args) {
        
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        
        Out.p(new Solution().groupAnagrams(strs));
        
    }

}
