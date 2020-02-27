package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.*;

/**
 * Group Anagrams
 *
 * Given an array of strings, group anagrams together.
 * Example:
 * Input: [eat, tea, tan, ate, nat, bat],
 * Output:
 * [
 *   [ate,eat,tea],
 *   [nat,tan],
 *   [bat]
 * ]
 * Note:
 * 	All inputs will be in lowercase.
 * 	The order of your output does not matter.
 *
 * Example:
 *      
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/group-anagrams/
 * @since   2020-02-27 22:17:43
 */
public class L0049_Group_Anagrams {
    static class Solution {

        public List<List<String>> groupAnagrams(String[] strs) {
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
