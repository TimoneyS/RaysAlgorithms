package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      You have 4 cards each containing a number from `1` to `9`. You need to compute whether they could operated through `*`, `/`, `+`, `-`, `(`, `)` to get the value of `24`.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：[1, 4, 8, 7]
 *      Output：true
 *      Explanation：8 * （7 - 4） * 1 = 24
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input：[1, 1, 1, 2]
 *      Output：true
 *      Explanation：no way to get 24
 *      ```
 *      
 *      
 *      **Example 3:**
 *      ```
 *      Input：[3, 3, 8, 8]
 *      Output：true
 *      Explanation：8 / ( 3 - 8 / 3) = 24
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/24-game/description
 * @date   2019-07-11 18:35:57
 */
public class L_0739_24_Game {

    /**
     * 首先定义一个表示分数的类，用分子分母方式存储，并定义加减乘除方法
     * 
     * 然后任意从 4 个数中选取两个数 f1 f2
     * 计算  f1 加减乘除 f2 f2 加减乘除 f1 等 8 个结果
     * 然后用这个结果从 剩下的数中任意挑选一个执行以上操作，直到所有的数字都已经计算
     * 
     * 等于是暴力算法，没有技巧性，复杂度是阶乘级别，可优化空间较大
     * @author rays1
     *
     */
    static class Solution {
    
        class Frac {
            int numerator, denominator;
            public Frac(int i, int j) {
                numerator = i; denominator = j;
                simplify();
            }

            // 加
            void add(int n, int d) {
                numerator = numerator * d + n * denominator;
                denominator = denominator * d;
            }
            
            // 减法
            void minusabs(int n, int d) {
                numerator = numerator * d - n * denominator;
                denominator = denominator * d;
                if (numerator < 0) numerator = -numerator;
            }
            
            // 乘法
            void product(int n, int d) {
                numerator = numerator * n;
                denominator = denominator * d;
            }
            
            void divide(int n, int d) {
                numerator = numerator * d;
                denominator = denominator * n;
            }
            
            Frac oper(int n, int d, int op) {
                if (op == 0) add(n, d); 
                if (op == 1) minusabs(n, d);
                if (op == 2) product(n, d);
                if (op == 3) divide(n, d);
                simplify();
                return this;
            }
            
            boolean isValue(int v) {
                return denominator != 0 && v*denominator == numerator;
            }
            
            void simplify() {
                int gcd = gcd(numerator, denominator);
                if (gcd == 0) return;
                numerator /= gcd;
                denominator /= gcd;
            }
            
            int gcd(int m, int n) {
                if (n == 0) return m;
                if (m < n) return gcd(n, m);
                return gcd(n, m%n);
            }
            
            public Frac copy() {
                return new Frac(numerator, denominator);
            }
            
        }
        
        public boolean compute24(double[] nums) {
            
            boolean[] marked = new boolean[4];
            for (int i = 0; i < 4; i++) {
                marked[i] = true;
                if(helper(nums, 1, marked, new Frac((int)nums[i], 1)))
                    return true;
                marked[i] = false;
            }
            return false;
        }

        private boolean helper(double[] nums, int level, boolean[] marked, Frac base) {
            
            if (level > 3) {
                return base.isValue(24);
            }
            for (int i = 0; i < 4; i++) {
                if (marked[i]) continue;
                marked[i] = true;
                for (int op = 0; op < 4; op ++) {
                    if (helper(nums, level+1, marked, base.copy().oper((int)nums[i], 1, op)))
                        return true;
                    if (helper(nums, level+1, marked, new Frac((int)nums[i], 1).oper(base.numerator, base.denominator, op)))
                        return true;
                }
                marked[i] = false;
            }
            return false;
        }
        
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
