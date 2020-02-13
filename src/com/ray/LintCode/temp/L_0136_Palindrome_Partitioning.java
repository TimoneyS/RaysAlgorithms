package com.ray.LintCode.temp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.ray.io.Out;
import com.ray.util.Timer;

/**
 * 描述：
 *      给定字符串 s, 需要将它分割成一些子串, 使得每个子串都是回文串.
 *      返回所有可能的分割方案.
 *
 * 用例：
 *      **Example 1:**
 *      Input: "aab"
 *      Output: [["aa", "b"], ["a", "a", "b"]]
 *      Explanation: There are 2 ways to split "aab".
 *          1. Split "aab" into "aa" and "b", both palindrome.
 *          2. Split "aab" into "a", "a", and "b", all palindrome.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @link   https://www.lintcode.cn/problem/palindrome-partitioning/description
 * @since  2019-07-11 18:31:01
 */
public class L_0136_Palindrome_Partitioning {

    static class Solution {
        
        Map<String, List<List<String>>> cache = new HashMap<>();
        
        public List<List<String>> partition(String s) {
  
            if (cache.containsKey(s)) return cache.get(s);
            
            List<List<String>> rs = new LinkedList<>();
            
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
                    List<String> temp = new LinkedList<>();
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
        List<List<String>> rs = new Solution().partition(s);
        Timer.STOP();
        for (List<String> l : rs) {
            Out.p(l);
        }
    }
}