package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给定一个质数 n，输出它是第几个质数。
 *
 * @author rays1
 *
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
        
        int n = 11;
        Out.p(new Solution().kthPrime(n));
        
    }

}
