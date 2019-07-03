package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   There are `n` bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the `ith` round, you toggle every `i` bulb. For the `nth` round, you only toggle the last bulb. Find how many bulbs are on after `n` rounds.
 *
 * Example :
 *   **Example1**
```
Input: 3
Output: 1
Explanation:
At first, the three bulbs are [off, off, off].
After first round, the three bulbs are [on, on, on].
After second round, the three bulbs are [on, off, on].
After third round, the three bulbs are [on, off, off]. 

So you should return 1, because there is only one bulb is on.
```
**Example2**
```
Input: 2
Output: 1
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/bulb-switcher/description
 * @date   2019-07-03 17:35:47
 */
public class L_0991_Bulb_Switcher {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
