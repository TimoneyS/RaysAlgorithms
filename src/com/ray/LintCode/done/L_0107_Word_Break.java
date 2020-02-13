package com.ray.LintCode.done;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.ray.io.In;
import com.ray.io.Out;
import com.ray.util.Timer;

/**
 * 描述：
 *      给定字符串 s 和单词字典 dict，确定 s 是否可以分成一个或多个以空格分隔的子串，并且这些子串都在字典中存在。
 *
 * 用例：
 *      Example 1:
 *      	Input:  "lintcode", ["lint", "code"]
 *      	Output:  true
 *      
 *      Example 2:
 *      	Input: "a", ["a"]
 *      	Output:  true
 * 难度： Medium
 *   
 * @author rays1
 * @link   https://www.lintcode.cn/problem/word-break/description
 * @since  2019-07-11 18:30:38
 */
public class L_0107_Word_Break {

    static class Solution {
        
        boolean[] canBreak;
        
        public boolean wordBreak(String s, Set<String> dict) {
            if (s.length() == 0) return true;
            if (dict.size() == 0) return false;
            canBreak = new boolean[s.length()];
            int m = -1;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = m; j >= -1; j --) {
                    if (j != -1 && !canBreak[j]) continue;
                    if(isInDict(s, j+1, i, dict)){
                        m = i-1;
                        canBreak[m] = true;
                        break;
                    }
                }
            }
            return canBreak[s.length()-1];
        }
        
        public boolean isInDict(String tar, int s, int t, Set<String> dict) {
            for (String src : dict) {
                if (src.length() != t - s)
                    continue;
                int i = 0;
                for (; i < src.length(); i++) {
                    if (tar.charAt(s+i) != src.charAt(i)) {
                        break;
                    }
                }
                if (i == src.length()) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        
//        String s = builderFromFile(dict);
        
        String s = "ab";
        String[] arr = {"a", "b"};
        for (String string : arr) dict.add(string);
        
        Out.p(s.length());
        Out.p(dict);
        
        Timer.CLICK();
        Out.p(new Solution().wordBreak(s, dict));
        Timer.STOP();
    }
}
