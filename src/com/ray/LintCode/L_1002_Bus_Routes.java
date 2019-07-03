package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given a list `routes`, and `routes[i]` is the circular route of the i-th bus. For example, if `routes[0] = [1, 5, 7]`, the first bus travels in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 ... forever.
 *   
 *   Given `S` and `T`. Travelling by buses only, what is the least number of buses we need take to reach `T` from `S` ? Return `-1` if it is not possible.
 *
 * Example :
 *   **Example 1:**
 *   
 *   ```
 *   Input: routes = [[1, 2, 7], [3, 6, 7]], S = 1, T = 6
 *   Output: 2
 *   Explanation: Take the first bus to the bus stop 7, and then take the second bus to 6.
 *   ```
 *   
 *   **Example 2:**
 *   
 *   ```
 *   Input: routes = [[1], [15, 16, 18], [3, 4,12,14]], S = 3, T = 15
 *   Output: -1
 *   Explanation: There is no way to get 15 from 3.
 *   ```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/bus-routes/description
 * @date   2019-07-03 17:36:07
 */
public class L_1002_Bus_Routes {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
