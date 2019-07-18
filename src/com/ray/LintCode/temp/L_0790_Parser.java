package com.ray.LintCode.temp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.ray.io.Out;

/**
 * 描述：
 *      Symbol string generator consists of two parts, a set of the start symbol and a set of rules of generation.
 *      For example:
 *      Start symbol: ['S'], Rules of generation: ["S → abc", "S → aA", "A → b", "A → c"]
 *      Then, symbolic string abc can be generated because S → abc. 
 *      Symbolic string ab can be generated because S → aA → ab.
 *      Symbolic string abc can be generated because S → aA → ac.
 *      Now, give you a symbolic string generator and a symbolic string, and you need to return True if the symbolic string can be generated, False otherwise
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input:  generator = ["S → abc", "S → aA", "A → b", "A → c"], startSymbol = S, symbolString = “ac”
 *      	Output:  true
 *      	
 *      	Explanation:
 *      	S -> aA -> ac
 *      
 *      Example 2:
 *      	Input: generator = ["S → abcd", "S → A", "A → abc"], startSymbol = S, symbolString = “abc”
 *      	Output:  true
 *      	
 *      	Explanation:
 *      	S → A → abc
 *      	
 *      Example 3:
 *      	Input: generator = ["S → abc", "S → aA", "A → b", "A → c"], startSymbol = S, symbolString = “a”
 *      	Output:  false
 *      	
 *      	Explanation:
 *      	Cannot get 'a' from S with several steps.
 *      	
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/parser/description
 * @date   2019-07-11 18:36:45
 */
public class L_0790_Parser {


    /**
     * 注意用例中的分隔符是 -> 而不是 →
     * 
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public boolean canBeGenerated(String[] generator, char startSymbol, String symbolString) {
            
            Map<Character, HashSet<String>> map = new HashMap<>();
            for (String s : generator) {
                char c = s.charAt(0);
                map.putIfAbsent(c, new HashSet<>());
                map.get(c).add(s.substring(5));
            }
            return helper(map, startSymbol + "", symbolString);
        }

        private boolean helper(Map<Character, HashSet<String>> map, String base, String symbolString) {
            if (base.equals(symbolString)) return true;
            if (base.length() > symbolString.length()) return false;
            
            for (int i = 0; i < base.length(); i++) {
                char c = base.charAt(i);
                
                if (c >= 'A' && c <= 'Z') {
                    for (String rep : map.get(c)) {
                        if (helper(map, base.substring(0, i)+ rep + base.substring(i+1), symbolString) ) {
                            return true;
                        }
                    }
                } else if (c != symbolString.charAt(i)) {
                    return false;
                }
            }
            return false;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
