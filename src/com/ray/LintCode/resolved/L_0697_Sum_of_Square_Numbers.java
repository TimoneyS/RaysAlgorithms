package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给定一个整数 c，寻找是否存在 a，b 使得 a^2 + b^2 = c
 *
 * @author rays1
 *
 */
public class L_0697_Sum_of_Square_Numbers {

    /**
     * 判断是不是平方数，可以表示为
     * 
     * i = Math.sqrt(n)
     * i*i == n
     * 
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public boolean checkSumOfSquareNumbers(int num) {
            for (int i = (int) Math.sqrt(num); i >= 0; i --) {
                int n = num - i*i;
                int t = (int) Math.sqrt(n);
                if (t * t == n) return true;
            }
            return false;
        }
    
    }
    
    public static void main(String[] args) {
        
        int num = 65326266;
        
        Out.p(new Solution().checkSumOfSquareNumbers(num));
        
    }

}
