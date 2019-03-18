package com.ray.LintCode.resolved;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.ray.io.Out;

/**
 * 符号串生成器由两部分组成，一个集合的起始符号和一个集合的生成规则。
 * 
 * 例如：
 *      起始符号：{ S }
 *      生成规则：{ "S → abc", "S → aA", "A → b", "A → c" }
 *      
 *      则
 *          可以生成字符串 abc   S → abc
 *          可以生成 ab         S → aA → ab.
 *          可以生成 ac         S → aA → ac
 *          
 * 现在给定一个符号生成器和一个符号字符串，返回符号生成器是否可以生成目标字符串
 *
 * @author rays1
 *
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
        String[] generator      = {"S -> abc", "S -> aA", "A -> b", "A -> c"};
        char     startSymbol    = 'S';
        String   symbolString   = "ac";
        Out.p(new Solution().canBeGenerated(generator, startSymbol, symbolString));
        
    }

}
