package com.ray.LintCode.temp;

import java.util.ArrayList;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a string `s` and a **non-empty** string `p`, find all the start indices of `p`'s anagrams in `s`.
 *      
 *      Strings consists of lowercase English letters only and the length of both strings **s** and **p** will not be larger than 40,000.
 *      
 *      The order of output does not matter.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input : s =  "cbaebabacd", p = "abc"
 *      Output : [0, 6]
 *      Explanation : 
 *      The substring with start index = 0 is "cba", which is an anagram of "abc".
 *      The substring with start index = 6 is "bac", which is an anagram of "abc".
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/find-all-anagrams-in-a-string/description
 * @date   2019-07-11 18:34:46
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
        
        Out.p(new Solution());
        
    }

}
