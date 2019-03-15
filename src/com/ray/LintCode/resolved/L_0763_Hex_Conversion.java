package com.ray.LintCode.resolved;

import java.util.HashMap;
import java.util.Map;

import com.ray.io.Out;

/**
 * 给定十进制的数字 n 和一个整数 k，将 n 转换为 k 进制的数。
 * k 在 2 到 16 之间
 * @author rays1
 *
 */
public class L_0763_Hex_Conversion {

    static class Solution {
        static Map<Integer, Character> map = new HashMap<>();
        
        static {
            for (int i = 0; i < 7;i++)
                map.put(i+10, (char) ('A' + i));
        }
        
        public String hexConversion(int n, int k) {
            if (n == 0) return n+"";
            String s = "";
            while (n > 0) {
                int mod = n % k;
                n /= k;
                if (mod < 10) {
                    s = mod + s;
                } else {
                    s = map.get(mod) + s;
                }
            }
            return s;
        }
    
    }
    
    public static void main(String[] args) {
        int n = 1;
        int k = 16;
        Out.p(new Solution().hexConversion(n, k));
        
    }

}
