package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.ray.io.Out;

/**
 * 移除最少的括号来使得字符串合法，返回所有可能的结果。
 * 
 * "()())()" -> ["()()()", "(())()"]
 * "(a)())()" -> ["(a)()()", "(a())()"]
 * ")(" -> [""]
 * 
 * @author rays1
 *
 */
public class L_0780_Remove_Invalid_Parentheses {
    
    /**
     * 合法的括号字符串
     *      从左向右遍历字符串，遇到左括号入栈，遇到右括号出栈。
     *      若遇到右括号栈空，或者字符串遍历完毕栈不为空，则字符串不合法。
     * 
     * 从左向右遍历字符串，利用stack 保存括号信息，同时跳过需要删除的字符串。到抵达字符串结尾时，如果括号能够对应则时合法结果。
     * 返回最长的搜索结果。
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public List<String> removeInvalidParentheses(String s) {
            
            List<Set<String>> dp = new ArrayList<>();
            
            dp.add(new HashSet<String>());
            dp.get(0).add("");
            
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    dp.add(new HashSet<>());
                    for (int j = dp.size()-2; j >= 0; j--) {
                        for (String ss : dp.get(j)) {
                            add(dp.get(j+1), ss+'(');
                        }
                    }
                } else if (s.charAt(i) == ')') {
                    for (int j = 0; j < dp.size()-1; j++) {
                        for (String ss : dp.get(j+1)) {
                            add(dp.get(j), ss+')');
                        }
                    }
                } else {
                    for (int j = 0; j < dp.size(); j++) {
                        Set<String> set = dp.get(j);
                        dp.set(j, new HashSet<String>());
                        for (String ss : set) {
                            dp.get(j).add(ss+s.charAt(i));
                        }
                    }
                }
                
            }
            
            return new ArrayList<String>(dp.get(0));
        }

        private void add(Set<String> set, String string) {
            for (Iterator<String> it = set.iterator(); it.hasNext();) {
                if (it.next().length() < string.length())
                    it.remove();
            }
            set.add(string);
        }
        
    }
    
    public static void main(String[] args) {
        
        String s = "x(";
        
        Out.p(new Solution().removeInvalidParentheses(s));
        
    }

}
