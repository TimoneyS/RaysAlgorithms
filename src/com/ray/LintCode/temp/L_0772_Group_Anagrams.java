package com.ray.LintCode.temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array of strings, group anagrams together.
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input:
 *      ["eat","tea","tan","ate","nat","bat"]
 *      Output:
 *      [["ate","eat","tea"],
 *       ["bat"],
 *       ["nat","tan"]]
 *      ```
 *      Example 2:
 *      ```
 *      Input:
 *      ["eat","nowhere"]
 *      Output:
 *      [["eat"],
 *       ["nowhere"]]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/group-anagrams/description
 * @date   2019-07-11 18:36:32
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
        
        Out.p(new Solution());
        
    }

}
