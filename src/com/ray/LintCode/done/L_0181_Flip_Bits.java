package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Determine the number of bits required to flip if you want to convert integer *n* to integer *m*.
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input: n = 31, m = 14
 *      	Output:  2
 *      	
 *      	Explanation:
 *      	(11111) -> (01110) there are two different bits.
 *      
 *      
 *      Example 2:
 *      	Input: n = 1, m = 7
 *      	Output:  2
 *      	
 *      	Explanation:
 *      	(001) -> (111) will change two bits.
 *      
 *      
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/flip-bits/description
 * @date   2019-07-11 18:31:40
 */
public class L_0181_Flip_Bits {

    static class Solution {
        public int bitSwapRequired(int a, int b) {
            int c = 0;
            String s = Integer.toBinaryString(a^b);
            for (int i = 0; i < s.length(); i++)
                if (s.charAt(i) == '1') c ++;
            return c;
        }
    }

    public static void main(String[] args) {
        
        int a = 31;
        int b = 14;
        
        Out.p(new Solution().bitSwapRequired(a, b));
        
    }

}
