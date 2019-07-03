package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Define `S = [s,n]` as the string S which consists of n connected strings s. For example, `["abc", 3]` ="abcabcabc".
 *   
 *   On the other hand, we define that string s1 can be obtained from string s2 if we can remove some characters from s2 such that it becomes s1. For example, "abc" can be obtained from "abdbec" based on our definition, but it can not be obtained from "acbbe".
 *   
 *   You are given two non-empty strings s1 and s2 (each at most 100 characters long) and two integers n1 and n2($0 \leq n1 \leq 10^6 , 1 \leq n2 \leq 10^6$). Now consider the strings S1 and S2, where `S1=[s1,n1]` and `S2=[s2,n2]`. Find the maximum integer M such that `[S2,M]` can be obtained from `S1`.
 *
 * Example :
 *   **Example 1:**
 *   ```
 *   Input：s1="acb", n1=4, s2="ab", n2=2
 *   Output：2
 *   Explanation：get "abababab"  form "acbacbacbacb".
 *   ```
 *   
 *   **Example 2:**
 *   ```
 *   Input：s1="aaa", n1=3, s2="aa", n2=1
 *   Output：4
 *   Explanation：get "aaaaaaaa" from "aaaaaaaaa".
 *   ```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/count-the-repetitions/description
 * @date   2019-07-03 17:41:34
 */
public class L_1224_Count_The_Repetitions {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
