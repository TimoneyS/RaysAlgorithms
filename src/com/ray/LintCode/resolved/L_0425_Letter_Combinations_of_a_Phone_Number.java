package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ray.io.Out;

/**
 * 拨号盘的字母组合
 * 
 * 给定数字字符串排除 01 ，返回该数字可能代表的所有可能的字母组合。
 * 拨号盘上的数字和字母的映射如下
 * 
 * --------------------------
 * [1 ⚯      ] [2 abc ] [3 def ]
 * [4 ghi ] [5 jkl ] [6 mno ]
 * [7 pqrs] [8 tuv ] [9 wxyz]
 * [* +   ] [0 ︺    ] [⇧   #   ]
 *----------------------------
 * @author rays1
 *
 */
public class L_0425_Letter_Combinations_of_a_Phone_Number {

    static class Solution {
        
        static Map<Character, char[]> hash = new HashMap<>();
    
        static {
            hash.put('2', new char[]{'a', 'b', 'c'});
            hash.put('3', new char[]{'d', 'e', 'f'});
            hash.put('4', new char[]{'g', 'h', 'i'});
            hash.put('5', new char[]{'j', 'k', 'l'});
            hash.put('6', new char[]{'m', 'n', 'o'});
            hash.put('7', new char[]{'p', 'q', 'r', 's'});
            hash.put('8', new char[]{'t', 'u', 'v'});
            hash.put('9', new char[]{'w', 'x', 'y', 'z'});
        }
        
        public List<String> letterCombinations(String digits) {
            ArrayList<String> rs = new ArrayList<>();
            List<Character> base = new ArrayList<>();
            helper(rs, base, digits, digits.length()-1);
            return rs;
        }
        
        public void helper(List<String> rs, List<Character> base, String digits, int level) {
            
            if (level < 0) {
                StringBuilder sb = new StringBuilder();
                for (char c : base) {
                    sb.append(c);
                }
                if (sb.length() != 0)
                    rs.add(sb.toString());
            } else {
                for (char c : hash.get(digits.charAt(level))) {
                    base.add(0, c);
                    helper(rs, base, digits, level-1);
                    base.remove(0);
                }
                
            }
            
        }
    
    }
    
    public static void main(String[] args) {
        
        String digits = "";
        
        Out.p(new Solution().letterCombinations(digits));
        
    }

}
