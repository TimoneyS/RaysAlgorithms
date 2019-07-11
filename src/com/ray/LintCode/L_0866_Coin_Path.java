package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array `A` (index starts at 1) consisting of N integers: A1, A2, ..., AN and an integer `B`. The integer B denotes that from any place (suppose the index is `i`) in the array `A`, you can jump to any one of the place in the array `A` indexed `i+1`, `i+2`, …, `i+B` if this place can be jumped to. Also, if you step on the index `i`, you have to pay Ai coins. If Ai is -1, it means you can’t jump to the place indexed `i` in the array.
 *      
 *      Now, you start from the place indexed `1` in the array `A`, and your aim is to reach the place indexed `N` using the minimum coins. You need to return the path of indexes (starting from 1 to N) in the array you should take to get to the place indexed `N` using minimum coins.
 *      
 *      If there are multiple paths with the same cost, return the lexicographically smallest such path.
 *      
 *      If it's not possible to reach the place indexed N then you need to return an empty array.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：[1,2,3,4,5]，B=2
 *      Output：[1,3,5]
 *      Explanation：9 is the smallest cost
 *      ```
 *      
 *      
 *      **Example 2:**
 *      ```
 *      Input：[1,2,4,-1,2]，B=1
 *      Output：[]
 *      Explanation：There is no path from 1 to n
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/coin-path/description
 * @date   2019-07-11 18:38:06
 */
public class L_0866_Coin_Path {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
