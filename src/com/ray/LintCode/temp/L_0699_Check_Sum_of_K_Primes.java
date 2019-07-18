package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given two numbers `n` and `k`. We need to find out if `n` can be written as sum of `k` prime numbers.
 *
 * 用例：
 *      **Example 1**
 *      
 *      ```plain
 *      Input:
 *      n = 10
 *      k = 2
 *      Output: true
 *      Explanation: 10 = 5 + 5
 *      ```
 *      
 *      **Example 2**
 *      
 *      ```plain
 *      Input:
 *      n = 2
 *      k = 2
 *      Output: false
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/check-sum-of-k-primes/description
 * @date   2019-07-11 18:35:37
 */
public class L_0699_Check_Sum_of_K_Primes {

    /**
     * 哥德巴赫猜想
     *      任一大于2的偶数都可写成两个质数之和。
     *      2 只能表示为 一个质数之和
     * 则
     *      需要考虑 n 和 k 的奇偶性
     * 
     * 如果 n 和 k 都是 偶数。则返回 2*k <= k
     * 若果 n 是偶数 k 是奇数。则可以用 n-2 k-1 比较
     * 主要要考虑到一个 偶数可以表示为两个质数和，那么问题的核心是讲将 n 和 k 都变为偶数来考虑。
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public boolean isSumOfKPrimes(int n, int k) {
            
            if (k*2 > n) return false;
            if (k == 1) return isPrime(n);
            
            if (n % 2 == 1) {
                if (k % 2 == 1) return isSumOfKPrimes(n-3, k-1);
                else            return isSumOfKPrimes(n-2, k-1);
            } else {
                if (k % 2 == 1) return isSumOfKPrimes(n-2, k-1);
                else            return true;
            }
            
        }
        
        private boolean isPrime(int n) {
            if (n < 2) return false;
            for (int i = 2; i <= n/2; i++) {
                if (n % i == 0) return false;
            }
            return true;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
