package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a list of prime numbers and find the smallest `prime number` that doesn't appear in this list.
 *
 * 用例：
 *      **Example1**
 *      ```
 *      Input: [3,5,7]
 *      Output: 2
 *      ```
 *      **Example2**
 *      ```
 *      Input: [2,3,5,7,11,13,17,23,29]
 *      Output: 19
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/first-missing-prime-number/description
 * @date   2019-07-11 18:35:25
 */
public class L_0681_First_Missing_Prime_Number {

    /**
     * 创建方法求取下一个质数，然后流式的和数组中比较
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int firstMissingPrime(int[] nums) {
            int p = 2;
            for (int n : nums) {
                if (p != n) break;
                p = nextPrime(p+1);
            }
            return p;
        }
        
        public int nextPrime(int n) {
            while (!isPrime(n)) n ++;
            return n;
        }
        
        public boolean isPrime(int n) {
            if (n == 1) return false;
            for (int i = 2; n / i >= i; i++)
                if (n % i == 0)
                    return false;
            return true;
        }
    
    }
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
