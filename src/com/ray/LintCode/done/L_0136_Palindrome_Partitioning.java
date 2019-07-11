package com.ray.LintCode.done;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.ray.util.Timer;

/**
 * 描述：
 *      Given a string `s`. Partition `s` such that every substring in the partition is a palindrome.
 *      
 *      Return all possible palindrome partitioning of `s`.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: "a"
 *      Output: [["a"]]
 *      Explanation: Only 1 char in the string, only 1 way to split it (itself).
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: "aab"
 *      Output: [["aa", "b"], ["a", "a", "b"]]
 *      Explanation: There are 2 ways to split "aab".
 *          1. Split "aab" into "aa" and "b", both palindrome.
 *          2. Split "aab" into "a", "a", and "b", all palindrome.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/palindrome-partitioning/description
 * @date   2019-07-11 18:31:01
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
                if (!isPalindrom(subL)) continue;
                String subR = s.substring(i+1);
                
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
        
        String s = "aabbbccccdddddccccbbbaa";
        
        Timer.CLICK();
        new Solution().partition(s);
        Timer.STOP();
        
//        for (List<String> l : new Solution().partition(s)) {
//            Out.p(l);
//        }
        
    }

}
