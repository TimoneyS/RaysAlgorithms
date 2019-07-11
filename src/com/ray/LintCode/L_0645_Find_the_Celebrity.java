package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Suppose you are at a party with `n` people (labeled from `0` to `n - 1`) and among them, there may exist one celebrity. The definition of a celebrity is that all the other `n - 1` people know him/her but he/she does not know any of them.
 *      
 *      Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
 *      
 *      You are given a helper function `bool knows(a, b)` which tells you whether A knows B. Implement a function `int findCelebrity(n)`, your function should minimize the number of calls to `knows`.
 *
 * 用例：
 *      **Example1**
 *      ```
 *      Input:
 *      2 // next n * (n - 1) lines 
 *      0 knows 1
 *      1 does not know 0
 *      Output: 1
 *      Explanation:
 *      Everyone knows 1,and 1 knows no one.
 *      ```
 *      **Example2**
 *      ```
 *      Input:
 *      3 // next n * (n - 1) lines 
 *      0 does not know 1
 *      0 does not know 2
 *      1 knows 0
 *      1 does not know 2
 *      2 knows 0
 *      2 knows 1
 *      Output: 0
 *      Explanation:
 *      Everyone knows 0,and 0 knows no one.
 *      0 does not know 1,and 1 knows 0.
 *      2 knows everyone,but 1 does not know 2.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/find-the-celebrity/description
 * @date   2019-07-11 18:34:44
 */
public class L_0645_Find_the_Celebrity {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
