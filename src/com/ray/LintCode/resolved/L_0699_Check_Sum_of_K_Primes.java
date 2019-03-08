package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给定两个数字 n 和 k，检查 n 是否可以表示为 k 个素数的和。
 * 
 * @author rays1
 *
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
        int n = 7;
        int k = 3;
        
        Out.p(new Solution().isSumOfKPrimes(n, k));
    }

}
