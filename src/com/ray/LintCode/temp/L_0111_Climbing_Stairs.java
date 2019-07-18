package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      <p style="line-height: 30px;">You are climbing a stair case. It takes&nbsp;<i><b>n</b></i>&nbsp;steps to reach to the top.</p><p style="line-height: 30px;">Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?</p>
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input:  n = 3
 *      	Output: 3
 *      	
 *      	Explanation:
 *      	1) 1, 1, 1
 *      	2) 1, 2
 *      	3) 2, 1
 *      	total 3.
 *      
 *      
 *      Example 2:
 *      	Input:  n = 1
 *      	Output: 1
 *      	
 *      	Explanation:  
 *      	only 1 way.
 *      
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/climbing-stairs/description
 * @date   2019-07-11 18:30:41
 */
public class L_0111_Climbing_Stairs {

    static class Solution {
        
        int[] mem;
        
        /**
         * @param n: An integer
         * @return: An integer
         */
        public int climbStairs(int n) {
            if (mem == null) mem = new int[n+1];
            if (n==1 || n==2 || n == 0) return n;
            if (mem[n] == 0)
                mem[n] = climbStairs(n-2) + climbStairs(n-1);
            return mem[n];
        }
        
    }
    
    public static void main(String[] args) {
        Out.p(new Solution().climbStairs(3));
    }

}
