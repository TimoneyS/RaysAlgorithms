package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given the prime number `n`, output the number of prime numbers
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: n = 3
 *      Output: 2
 *      Explanation:
 *      [2,3,5], 3 is the second prime number.
 *      ```
 *      
 *      
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: n = 11
 *      Output: 5
 *      Explanation:
 *      [2,3,5,7,11], 11 is the fifth prime number.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/kth-prime-number/description
 * @date   2019-07-11 18:36:47
 */
public class L_0792_Kth_Prime_Number {


    /**
     * 将 1 到 n 之间的所有素数的倍数去除，剩下的数字就是合数。
     * 
     * 具体的可见 埃拉托斯特尼筛法和欧拉筛法
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int kthPrime(int n) {
            boolean[] notPrime = new boolean[n+1];
            
            for (int i = 2; i < n; i++) {
                if (notPrime[i] == false) {
                    for (int j= 2*i; j <= n; j += i) {
                        notPrime[j] = true;
                    }
                }
            }
            
            int rs = 1;
            for (int i = 2; i < n; i ++) {
                if (!notPrime[i]) rs ++;
            }
            return rs;
        }
        
    }
    
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
