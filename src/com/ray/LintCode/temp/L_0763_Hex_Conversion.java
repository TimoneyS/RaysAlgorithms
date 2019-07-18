package com.ray.LintCode.temp;

import java.util.HashMap;
import java.util.Map;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a decimal number `n` and an integer `k`, Convert `decimal number n` to `base-k`.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input : n = 5, k = 2
 *      Output : 101
 *      ```
 *      **Example 2:**
 *      ```
 *      Input : n = 30, k = 16
 *      Output : "1E"
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/hex-conversion/description
 * @date   2019-07-11 18:36:24
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
        
        Out.p(new Solution());
        
    }

}
