package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * count-and-say 序列是这样的一种序列：
 *      1, 11, 21, 1211, 111221, ...
 *      1 读作 一个 1 或者 11
 *      11 对作 两个一 或者 21
 *      21 读作 一个二一个一 或者 1211
 * 给定一个整数 n，生成第n个序列
 *
 * 如 5
 * 
 * 1, 11, 21, 1211, 111221,
 *
 * @author rays1
 *
 */
public class L_0420_Count_and_Say {

    /**
     * 提供 next 方法
     * next方法统计字符串中每段连续字符的长度和字符本身，加入新的字符串中
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public String countAndSay(int n) {
            String s = "1";
            for (int i = 1; i < n; i ++) {
                s = next(s);
            }
            return s;
        }
        
        public String next(String s) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int i = 0; i < s.length(); i ++) {
                if (i < s.length() -1 && s.charAt(i) == s.charAt(i+1)) {
                    count ++;
                } else {
                    sb.append(count).append(s.charAt(i));
                    count = 1;
                }
            }
            return sb.toString();
            
        }
    
    }
    
    public static void main(String[] args) {
        
        int n = 5;
        
        Out.p(new Solution().countAndSay(n));
        
    }

}
