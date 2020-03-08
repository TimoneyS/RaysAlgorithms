package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Palindrome Partitioning
 * -----------------------------------------------------------------------------
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 *
 * Example:
 *      Example 1
 *      Input: aab
 *      Output:
 *      [
 *        [aa,b],
 *        [a,a,b]
 *      ]
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/palindrome-partitioning/
 * @since   2020-03-07 20:13:36
 */
public class L0131_Palindrome_Partitioning {
    static class Solution {
        Map<String, List<List<String>>> cache = new HashMap<>();
        public List<List<String>> partition(String s) {
            if (cache.containsKey(s)) return cache.get(s);
            List<List<String>> rs = new ArrayList<>();
            if (isPalindrom(s)) {
                List<String> list = new ArrayList<>();
                list.add(s);
                rs.add(list);
            }
            for (int i = 0; i < s.length()-1; i++) {
                String subL = s.substring(0, i+1);
                if (!isPalindrom(subL)) continue;
                String subR = s.substring(i+1);
                List<List<String>> rsR = partition(subR);
                for (List<String> rList: rsR) {
                    List<String> temp = new ArrayList<>();
                    temp.add(subL);
                    temp.addAll(rList);
                    rs.add(temp);
                }
            }
            cache.put(s, rs);
            return rs;
        }

        boolean isPalindrom(String s) {
            int l = 0, r = s.length()-1;
            while(l < r)
                if(s.charAt(l++) != s.charAt(r--))
                    return false;
            return true;
        }

    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
