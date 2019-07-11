package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      In material plane "reality", there are `n + 1` planets, namely planet 0, planet 1, ..., planet n.
 *      Each planet has a portal through which we can reach the target planet directly without passing through other planets.
 *      But portal has two shortcomings.
 *      First, planet `i` can only reach the planet whose number is **greater than** `i`, and the difference between `i` can not exceed the limit.
 *      Second,  it takes `cost[j]` gold coins to reach the planet `j` through the portal.
 *      Now, Rogue Knight Sven arrives at the planet `0` with `m` gold coins, how many ways does he reach the planet `n` through the portal?
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input:
 *      n = 1
 *      m = 1
 *      limit = 1
 *      cost = [0, 1]
 *      Output:
 *      1
 *      Explanation:
 *      Plan 1: planet 0 → planet 1
 *      ```
 *      
 *      Example 2:
 *      ```
 *      Input:
 *      n = 1
 *      m = 1
 *      limit = 1
 *      cost = [0,2]
 *      Output:
 *      0
 *      Explanation:
 *      He can not reach the target planet.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/rogue-knight-sven/description
 * @date   2019-07-11 18:36:04
 */
public class L_0752_Rogue_Knight_Sven {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
