package com.ray.LintCode.resolved;

import java.util.HashSet;

import com.ray.io.Out;

/**
 * 实现通配符模式匹配并支持 '?' 和 '*'。
 *      '?' 匹配任何单个字符。
 *      '*'匹配任何字符序列（包括空序列）。
 * 匹配应覆盖整个输入字符串（非部分）。
 *
 * @author rays1
 *
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
