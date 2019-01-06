package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 
 * 字符串 s，寻找最长的回文子串
 * 
 * 如 "abcdzdcab" 返回 "cdzdc".
 *
 * 时间复杂度 O(n2) -> O(n)
 *
 * @author rays1
 *
 */
public class L_0200_Longest_Palindromic_Substring {

    static class Solution {
        
        public String longestPalindrome(String s) {
            
            int[] p = new int[s.length()*2+1];
            char[] chs = new char[s.length()*2 + 1];
            for (int i = 0; i < chs.length; i++)
                chs[i] = i % 2 == 0 ? '#' : s.charAt(i/2); 
            
            int mx = 0, id = 0, resLen = 0, resCenter = 0;
            for (int i = 0; i < chs.length; i++) {
                
                p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 1;
                
                while (i + p[i] < chs.length && i - p[i] >= 0 && chs[i + p[i]] == chs[i - p[i]]) {
                    p[i]++;
                }
                // 中心移动
                if (mx < i + p[i]) {
                    mx = i + p[i];
                    id = i;
                }
                // 最大值判断
                if (resLen < p[i]) {
                    resLen = p[i];
                    resCenter = i;
                }
                
            }
            
            int idx = resCenter/2;
            int rad = resLen/2;

            if (chs[resCenter] != '#') {
                return s.substring(idx - rad+1, idx+rad);
            } else {
                return s.substring(idx - rad, idx+rad);
            }
        }
        
    }
    
    public static void main(String[] args) {
        
        String s = "bgbgi";
        
        Out.p(new Solution().longestPalindrome(s));
    }

}
