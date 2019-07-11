package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      There is a room with `n` lights which are turned on initially and `4` buttons on the wall. After performing exactly `m` unknown operations towards buttons, you need to return how many different kinds of status of the `n` lights could be.
 *      
 *      Suppose `n` lights are labeled as number `[1, 2, 3 ..., n]`, function of these `4` buttons are given below:
 *      
 *      1. You can flip all the lights.
 *      2. You can flip lights with even numbers.
 *      3. You can flip lights with odd numbers.
 *      4. You can flip lights with `(3k + 1)` numbers, k = 0, 1, 2, ...
 *
 * 用例：
 *      **Example1**
 *      ```
 *      Input:
 *      1
 *      1
 *      Output: 2
 *      Explanation:
 *      Status can be: [on], [off]
 *      ```
 *      **Example2**
 *      ```
 *      Input:
 *      2
 *      1
 *      Output: 3
 *      Explanation:
 *      Status can be: [on, off], [off, on], [off, off]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/bulb-switcher-ii/description
 * @date   2019-07-11 18:35:42
 */
public class L_0704_Bulb_Switcher_II {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
