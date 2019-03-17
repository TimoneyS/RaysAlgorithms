package com.ray.LintCode.resolved;

import java.util.List;

import com.ray.io.Out;

/**
 * 给定 n 个字符串和一个目标字符串，输出最长的共同前缀的长度。
 * @author rays1
 *
 */
public class L_0784_The_Longest_Common_Prefix_II {

    static class Solution {
    
        public int the_longest_common_prefix(List<String> dic, String target) {
            int rs = 0;
            for (String s : dic) {
                rs = Math.max(rs, common(s, target));
            }
            return rs;
        }

        private int common(String s, String target) {
            int i = 0;
            while (true) {
                if (i >= s.length() || i >= target.length() || s.charAt(i) != target.charAt(i))
                    break;
                i++;
            }
            return i;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
