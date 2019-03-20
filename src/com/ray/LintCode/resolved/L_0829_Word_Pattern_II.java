package com.ray.LintCode.resolved;

import java.util.HashMap;
import java.util.Map;

import com.ray.io.Out;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.
(i.e if a corresponds to s, then b cannot correspond to s. For example, given pattern = "ab", str = "ss", return false.)
 *
 *
 * @author rays1
 *
 */
public class L_0829_Word_Pattern_II {

    /**
     * 分别从 i,j 开始遍历模式字符串和单词字符串
     *      如果模式字符串已经有对应的字符串，则从 j 开始在单词中寻找模式对应的单词
     *      
     *      如果模式字符串误对应的字符串，则从 j 开始寻找每个可能的字符串和模式匹配
     *          如果单词已经有匹配的模式，则寻找下一个单词
     *          如果单词无匹配的模式，从开始新一轮的递归
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public boolean wordPatternMatch(String pattern, String str) {
            return helper(pattern, str, 0, 0, new HashMap<Character, String>(), new HashMap<String, Character>());
        }
        
        private boolean helper(String pattern, String str, int i, int j, Map<Character, String> s2w, Map<String, Character> w2s) {
            if (i >= pattern.length() && j >= str.length()) return true;
            else if (i >= pattern.length() || j >= str.length()) return false;
            
            char ptn = pattern.charAt(i);
            
            if (s2w.containsKey(ptn)) {
                String s = s2w.get(ptn);
                for (int k = 0; k < s.length(); k++) {
                    if (k+j >= str.length() || s.charAt(k) != str.charAt(k+j))
                        return false;
                }
                return helper(pattern, str, i+1, j+s.length(), s2w, w2s);
            } else {
                for (int k = j; k < str.length(); k++) {
                    String s = str.substring(j, k+1);
                    
                    if (w2s.containsKey(s)) continue;
                    
                    s2w.put(ptn, s);
                    w2s.put(s, ptn);
                    
                    if(helper(pattern, str, i+1, k+1, s2w, w2s)) {
                        return true;
                    }
                    s2w.remove(ptn);
                    w2s.remove(s);
                }
                return false;
            }
            
        }
    
    }
    
    public static void main(String[] args) {
        
        String pattern = "bdpbibletwuwbvh";
        String     str = "aaaaaaaaaaaaaaa"; 
        
        Out.p(new Solution().wordPatternMatch(pattern, str));
        
    }

}
