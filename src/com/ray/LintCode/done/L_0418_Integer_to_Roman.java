package com.ray.LintCode.done;

import java.util.HashMap;
import java.util.Map;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an integer, convert it to a roman numeral.
 *      
 *      The number is guaranteed to be within the range from `1` to `3999`.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: 1
 *      Output: "I"
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: 99
 *      Output: "XCIX"
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/integer-to-roman/description
 * @date   2019-07-11 18:32:49
 */
public class L_0418_Integer_to_Roman {


    /**
     * 罗马表示法
     *      I       1
     *      V       5
     *      X       10
     *      L       50
     *      C       100
     *      D       500
     *      M       1000
     * 罗马数字重复的次数表示数字的几倍
     * 左加右减：
     *      大数右侧的小数表示大数加小数，右侧小数的个数不超过 3 个
     *      大数左侧的小数表示大数减小数，左侧小数的个数只能有 1 个
     *          左侧的小数只能是 I X C，且不能跨越位制
     *          
     * 罗马数组表示法对于每个位值的表示是独立的 如  1929 的表示是
     *      在千位值 表示 1   M
     *      在百位值 表示 9   CM
     *      在十位值 表示 2   XX
     *      在个位值 表示 9   IX
     *      
     * 拼凑可得  MCMXXIX
     * @author rays1
     *
     */
    static class Solution {
        
        static Map<Integer, String> hash = new HashMap<>(); 
        
        static {
            hash.put(1,    "I");
            hash.put(5,    "V");
            hash.put(10,   "X");
            hash.put(50,   "L");
            hash.put(100,  "C");
            hash.put(500,  "D");
            hash.put(1000, "M");
        }
        
        int[] V = {1, 5, 10, 50, 100, 500, 1000};
        
        public String intToRoman(int n) {
            String rs = "";
            
            int num = n;
            for (int i = 0; i <= 4; i += 2) {
                int t = num % 10;
                num = num /10;
                rs = intToRoman(t, V[i+2], V[i+1], V[i]) + rs;
                
                if (num == 0) break;
            }
            
            if (n >= 1000) {
                
                for (int i = 0; i < n/1000; i ++) {
                    rs = hash.get(1000) + rs;
                }
                
            }
            
            return rs;
        }

        public String intToRoman(int t, int high, int mid, int low) {
            
            String rs = "";
            
            if (t >= 5) {
                rs = hash.get(mid);
                t -= 5;
            } else {
                high = mid;
            }
            
            String s1 = hash.get(high);
            String s2 = hash.get(low);
            if (t == 4) {
                return s2 + s1;
            } else {
                for (int i = 0; i < t; i ++) {
                    rs += s2;
                }
            }
            
            return rs;
        }
        
    }
    
    public static void main(String[] args) {
        int n = 1234;
        Out.p(new Solution().intToRoman(n));
        
    }

}
