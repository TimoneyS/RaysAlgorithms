package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.List;

import com.ray.io.Out;

/**
 * 给定一个字符串 s 和一个非空的字符串 p， 找到在 s 中所有关于 p 的字谜的起始索引。
 * 字符串中均为小写字母，而且长度不超过40000，输出的顺序无所谓。
 * 
 * 例如：
 *      输入：s = "cbaebabacd", p = "abc"
 *      输出：[0, 6]
 *      解释：
 *          子字符串从 0 开始为 "cba"
 *          子字符串从 6 开始为 "bac"
 * @author rays1
 *
 */
public class L_0647_Find_All_Anagrams_in_a_String {

    /**
     * 使用一个长度为 p.length 的窗口在 s 上滑动，然后统计窗口内的字符和 p 的每种字符的个数是否一致。
     * 
     * 算法在判断时同时遍历了 base 和 curr 两个统计数组，应该有方法避免此类操作
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public List<Integer> findAnagrams(String s, String p) {
            s = s + " ";
            
            List<Integer> rs = new ArrayList<Integer>();
            if (s == null || s.length() < p.length()) return rs;
            
            int[] base = new int[127];
            int[] curr = new int[127];
            
            for (int i = 0; i < p.length(); i++) base[p.charAt(i)] ++;
            
            int l = 0, r = 0;
            while (r < p.length()) {
                char c = s.charAt(r);
                curr[c] ++;
                r++;
            }
            
            while (r < s.length()) {
                boolean b = true;
                for (int i = 0; i < base.length; i++)
                    if (base[i] != curr[i]) b = false;
  
                if (b) rs.add(l);
                curr[s.charAt(l++)] --;
                curr[s.charAt(r++)] ++;
            }
            
            return rs;
        }
        
        void pt(int[] ct) {
            for (int i = 0; i < ct.length; i++) {
                if (ct[i]==0) continue;
                Out.pf("%s = %s,", (char)i, ct[i]);
            }
            Out.p();
        }
    
    }
    
    public static void main(String[] args) {
        
        String s = "abab";
        String p = "ab";
        
        Out.p(new Solution().findAnagrams(s, p));
        
    }

}
