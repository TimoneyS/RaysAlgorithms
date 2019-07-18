package com.ray.LintCode.temp;

import java.util.HashSet;

import com.ray.io.Out;

/**
 * 描述：
 *      Implement wildcard pattern matching with support for `'?'` and `'*'`.
 *      
 *      - `'?'` Matches any single character.
 *      - `'*'` Matches any sequence of characters (including the empty sequence).
 *      
 *      The matching should cover the entire input string (not partial).
 *
 * 用例：
 *      **Example 1**
 *      
 *      ```plain
 *      Input:
 *      "aa"
 *      "a"
 *      Output: false
 *      ```
 *      
 *      **Example 2**
 *      
 *      ```plain
 *      Input:
 *      "aa"
 *      "aa"
 *      Output: true
 *      ```
 *      
 *      **Example 3**
 *      
 *      ```plain
 *      Input:
 *      "aaa"
 *      "aa"
 *      Output: false
 *      ```
 *      
 *      **Example 4**
 *      
 *      ```plain
 *      Input:
 *      "aa"
 *      "*"
 *      Output: true
 *      Explanation: '*' can replace any string
 *      ```
 *      
 *      **Example 5**
 *      
 *      ```plain
 *      Input:
 *      "aa"
 *      "a*"
 *      Output: true
 *      ```
 *      
 *      **Example 6**
 *      
 *      ```plain
 *      Input:
 *      "ab"
 *      "?*"
 *      Output: true
 *      Explanation: '?' -> 'a' '*' -> 'b'
 *      ```
 *      
 *      **Example 7**
 *      
 *      ```plain
 *      Input:
 *      "aab"
 *      "c*a*b"
 *      Output: false
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/wildcard-matching/description
 * @date   2019-07-11 18:31:48
 */
public class L_0192_Wildcard_Matching {
    
    /**
     * 利用简化的正则表达式的原理，当出现匹配时，前进到下一个状态。
     * 当出现*时，同时保留当前状态和下一个状态
     * @author rays1
     *
     */
    static class Solution {
        
        public boolean isMatch(String s, String p) {
            char[] ptn = p.toCharArray();
            
            HashSet<Integer> set = new HashSet<Integer>();
            HashSet<Integer> pre = new HashSet<Integer>();
            
            set.add(0);
            for (int i = 0; i < ptn.length; i++) {
                if (ptn[i] != '*') break;
                set.add(i+1);
            }
            
            for (int i = 0; i < s.length(); i++) {
                
                Out.p(set);
                
                for (Integer stat : set) {
                    if (stat >= ptn.length) continue;
                    if (ptn[stat] == s.charAt(i) || ptn[stat] == '?') {
                        pre.add(stat+1);
                    } else if (ptn[stat] == '*') {
                        pre.add(stat);
                        pre.add(stat+1);
                    }
                }
                
                set.clear();
                
                for (Integer stat : pre) {
                    set.add(stat);
                    if (stat >= ptn.length) continue;
                    
                    if (ptn[stat] == '*') {
                        for (int j = stat; j < ptn.length; j++) {
                            if (ptn[j] != '*') break;
                            set.add(j+1);
                        }
                    }
                }
                
                pre.clear();
            }
            
            return set.contains(ptn.length);
        }
    }
    
    public static void main(String[] args) {
        
        String s = "bbbba";
        String p = "?*a*a";
        
        Out.p(new Solution().isMatch(s, p));
        
    }

}
