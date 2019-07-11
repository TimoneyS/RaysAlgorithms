package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      We are given two arrays num[0..k-1] and rem[0..k-1]. **In num[0..k-1], every pair is coprime (gcd for every pair is 1.** We need to find `minimum positive` number `x` such that:
 *      ```
 *           x % num[0]    =  rem[0], 
 *           x % num[1]    =  rem[1], 
 *           .......................
 *           x % num[k-1]  =  rem[k-1] 
 *      ```
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：[3,4,5]，[2,3,1]
 *      Output：11
 *      Explanation：
 *      11 is the smallest number such that:
 *      - When we divide it by 3, we get remainder 2. 
 *      - When we divide it by 4, we get remainder 3.
 *      - When we divide it by 5, we get remainder 1. 
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input：[3,4,5,11]，[2,3,1,7]
 *      Output：491
 *      Explanation：
 *      491 is the smallest number such that:
 *      - When we divide it by 3, we get remainder 2. 
 *      - When we divide it by 4, we get remainder 3.
 *      - When we divide it by 5, we get remainder 1. 
 *      - When we divide it by 11, we get remainder 7. 
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/chinese-remainder-theorem/description
 * @date   2019-07-11 18:35:51
 */
public class L_0727_Chinese_Remainder_Theorem {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
