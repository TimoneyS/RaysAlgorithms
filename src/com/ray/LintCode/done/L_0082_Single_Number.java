package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given `2 * n + 1` numbers, every numbers occurs twice except one, find it.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：[1,1,2,2,3,4,4]
 *      Output：3
 *      Explanation:
 *      Only 3 appears once
 *      ```
 *      **Example 2:**
 *      ```
 *      Input：[0,0,1]
 *      Output：1
 *      Explanation:
 *      Only 1 appears once
 *      ```
 *
 * 挑战：
 *      One-pass, constant extra space.
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/single-number/description
 * @date   2019-07-11 18:29:59
 */
public class L_0082_Single_Number {

    static class Solution {
        
        /**
         * @param A: An integer array
         * @return: An integer
         */
        public int singleNumber(int[] A) {
            int num = 0;
            for (int i : A) num = num ^ i;
            return num;
        }
        
    }
    
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
