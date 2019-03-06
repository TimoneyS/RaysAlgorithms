package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给定一个列表的素数，寻找缺失的最小素数。
 *
 * 示例
 *      输入 2,3,5,7,11,13,17,23,29
 *      输出 19
 *      
 *      输入 3, 5, 7
 *      输入 2
 *      
 * @author rays1
 *
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
                p = nextPrime(p+1);
                if (p != n) break;
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
