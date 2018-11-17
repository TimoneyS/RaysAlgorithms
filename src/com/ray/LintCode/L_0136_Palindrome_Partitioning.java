package com.ray.LintCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.ray.io.Out;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * <br>
 * 给定一个字符串，返回所有回文的子字符串。
 * <p>
 * <b>Example</b><br>
 * Given s = "aab", return:
 * <li>[
 * <li> ["aa","b"],
 * <li> ["a","a","b"]
 * <li>]
 * @author rays1
 *
 */
public class L_0136_Palindrome_Partitioning {
    
    static class Solution {
        
        Map<String, List<List<String>>> cache = new HashMap<String, List<List<String>>>();
        
        /*
         * @param s: A string
         * @return: A list of lists of string
         */
        public List<List<String>> partition(String s) {
  
            if (cache.containsKey(s)) return cache.get(s);
            
            List<List<String>> rs = new LinkedList<List<String>>();
            
            if (isPalindrom(s)) {
                List<String> list = new LinkedList<>();
                list.add(s);
                rs.add(list);
            }
            
            for (int i = 0; i < s.length()-1; i++) {
                String subL = s.substring(0, i+1);
                String subR = s.substring(i+1);
                if (!isPalindrom(subL)) continue;
                
                List<List<String>> rsR = partition(subR);      
                
                for (List<String> rList: rsR) {
                    List<String> temp = new LinkedList<String>();
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
        
        String s = "aaba";
        
        for (List<String> l : new Solution().partition(s)) {
            Out.p(l);
        }
        
    }
    
}
