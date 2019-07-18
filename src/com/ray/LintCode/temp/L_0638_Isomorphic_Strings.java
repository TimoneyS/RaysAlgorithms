package com.ray.LintCode.temp;

import java.util.HashSet;
import java.util.Set;

import com.ray.io.Out;

/**
 * 描述：
 *      Given two strings **s** and **t**, determine if they are isomorphic.
 *      
 *      Two strings are isomorphic if the characters in s can be replaced to get t.
 *      
 *      All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input : s = "egg", t = "add"
 *      Output : true 
 *      Explanation : 
 *      e -> a, g -> d.
 *      ```
 *      **Example 2:**
 *      ```
 *      Input : s = "foo", t = "bar"
 *      Output : false
 *      Explanation : 
 *      No solution.
 *      ```
 *      **Example 3:**
 *      ```
 *      Input : s = "paper", t = "title"
 *      Output : true 
 *      Explanation : 
 *      p -> t, a -> i, e -> l, r -> e.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/isomorphic-strings/description
 * @date   2019-07-11 18:34:38
 */
public class L_0638_Isomorphic_Strings {

    static class Solution {
        /**
         * @param s a string
         * @param t a string
         * @return true if the characters in s can be replaced to get t or false
         */
        public boolean isIsomorphic(String s, String t) {
            // Write your code here
            Set<Byte> s1 = new HashSet<Byte>();
            Set<Byte> s2 = new HashSet<Byte>();
            int t1 = 0;
            int t2 = 0;
            byte[] arr1 = s.getBytes();
            byte[] arr2 = t.getBytes();
            
            for(int i = 0; i < arr1.length; i++) {
                if ( !s1.contains(arr1[i]) ) {
                    s1.add(arr1[i]);
                    t1 ++;
                }
                
                if ( !s2.contains(arr2[i]) ) {
                    s2.add(arr2[i]);
                    t2 ++;
                }
                
                if(t1 != t2) return false;
            }
            
            return true;
        }
        
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
