package com.ray.LintCode.done;

import java.util.HashMap;
import java.util.Map;

import com.ray.io.Out;

/**
 * 描述：
 *      比较两个字符串 A 和 B，推断 A 是否包含 B 中的所有字符。
 *      A 和 B 中的字符都是大写。
 *
 * 用例：
 *      For `A = "ABCD"`, `B = "ACD"`, return `true`.
 *      
 *      For `A = "ABCD"`, `B = "AABC"`, return `false`.
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/compare-strings/description
 * @date   2019-07-11 18:08:34
 */
public class L_0055_Compare_Strings {

    // 暴力算法
    static class Solution {
        
        public boolean compareStrings(String A, String B) {
            int n = B.length();
            boolean[] marked = new boolean[n];
            
            for (int i = 0; i < A.length(); i++) {
                for (int j = 0; j < B.length(); j++) {
                    if (!marked[j] && B.charAt(j) == A.charAt(i)) {
                        marked[j] = true;
                        n --;
                        break;
                    }
                }
            }
            if (n == 0) return true;
            return false;
        }
    }
    
    // 利用 hash 先统计 B 再统计 A
    static class Solution2 {
        
        public boolean compareStrings(String A, String B) {
            if (B.length() > A.length()) return false;
            
            
            Map<Integer, Integer> hash = new HashMap<>();
            for (int i = 0; i < B.length(); i++) {
                int c = B.charAt(i);
                hash.putIfAbsent( c, 0);
                hash.put(c, hash.get(c) + 1);
            }
            
            for (int i = 0; i < A.length(); i++) {
                int c = A.charAt(i);
                if (hash.containsKey(c)) {
                    if (hash.get(c) == 1) {
                        hash.remove(c);
                    } else {
                        hash.put(c, hash.get(c) - 1);
                    }
                }
                if (hash.size() == 0) return true;
            }
            if (hash.size() == 0) return true;
            return false;
        }
    }
    
    public static void main(String[] args) {
        
        String A = "ABCD";
        String B = "AABC";
        
        
        Out.p(new Solution().compareStrings(A, B));
        
    }

}
