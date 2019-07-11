package com.ray.LintCode.done;

import java.util.HashMap;

import com.ray.io.Out;

/**
 * 描述：
 *      <p>Calculate the<b><font color="#e76363"> <i>a<sup>n</sup>&nbsp;% b</i></font></b> where a, b and n are all 32bit non-negative integers.</p>
 *
 * 用例：
 *      <p>For 2<sup>31</sup> % 3 = 2</p><p>For 100<sup>1000</sup> % 1000 = 0</p>
 *
 * 挑战：
 *      <p>O(logn)</p>
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/fast-power/description
 * @date   2019-07-11 18:31:05
 */
public class L_0140_Fast_Power {

    static class Solution {
        
        HashMap<Integer, Integer> cache;
        /**
         * 求 (a ^ n) % b
         */
        public int fastPower(int a, int b, int n) {
            cache = new HashMap<>();
            return power(a, b, n);
        }
        
        private int power(int a, int b, int n) {
            if (n == 0) return 1 % b;
            if (n == 1) return a % b;

            if (!cache.containsKey(n)) {
                long h = fastPower(a, b, n/2);
                h *= h;
                h = h % b;
                if (n % 2 == 1) {
                    h *= (a%b);   
                }
                cache.put(n, (int) (h % b));
            }
            return cache.get(n);
        }
        
    }
    
    public static void main(String[] args) {
        
        int a = 2147483647;
        int b = 1147483647;
        int n = 2147483647;
        
        Out.p(new Solution().fastPower(a, b, n));
        
    }

}
