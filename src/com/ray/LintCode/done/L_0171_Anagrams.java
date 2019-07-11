package com.ray.LintCode.done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array of strings, return all groups of strings that are anagrams.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:["lint", "intl", "inlt", "code"]
 *      Output:["lint", "inlt", "intl"]
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input:["ab", "ba", "cd", "dc", "e"]
 *      Output: ["ab", "ba", "cd", "dc"]
 *      ```
 *
 * 挑战：
 *      What is Anagram?
 *      - Two strings are anagram if they can be the same after change the order of characters.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/anagrams/description
 * @date   2019-07-11 18:31:32
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
