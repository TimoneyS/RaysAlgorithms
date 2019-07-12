package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      We are given two numbers `A` and `B` such that `B >= A`. We need to compute the last digit of this resulting F such that F = `B! / A!` where 1 <= A, B <= `10^18` (A and B are very large)
 *
 * 用例：
 *      ```
 *      Given A = 2, B = 4, return 2
 *      A! = 2 and B! = 24, F = 24 / 2 = 12 --> last digit = 2
 *      
 *      Given A = 107, B = 109, return 2
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/last-digit-by-factorial-divide/description
 * @date   2019-07-11 18:35:53
 */
public class L_0729_Last_Digit_By_Factorial_Divide {


    /**
     * 
     * F = (A+1) * (A + 2) * ... * B
     * 
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int computeLastDigit(long A, long B) {
            if (B-A>4) return 0;
            int rs = 1;
            while (++A<=B) {
                rs *= (int) (A % 10);
            }
            return rs % 10;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
