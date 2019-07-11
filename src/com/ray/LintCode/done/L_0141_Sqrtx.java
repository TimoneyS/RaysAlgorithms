package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Implement int `sqrt(int x)`.
 *      
 *      Compute and return the square root of *x*.
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input:  0
 *      	Output: 0
 *      
 *      
 *      Example 2:
 *      	Input:  3
 *      	Output: 1
 *      	
 *      	Explanation:
 *      	return the largest integer y that y*y <= x. 
 *      	
 *      Example 3:
 *      	Input:  4
 *      	Output: 2
 *      	
 *      
 *      ```
 *
 * 挑战：
 *      O(log(x))
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/sqrtx/description
 * @date   2019-07-11 18:31:06
 */
public class L_0141_Sqrtx {

    static class Solution {
        
        public int sqrt(int x) {
            
            long X = (long) x;
            long l = 1, r = X;
            
            while (l + 1 < r) {
                long mid = l + (r - l) / 2;
                if (mid * mid == X) {
                    return (int) mid;
                } else if (mid * mid < X) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
            if (r * r == X) return (int) r;
            return (int) l;
        }
        
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
