package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   In the "100 game", two players take turns adding to a running total, using any integer from 1..10. The player who first causes the running total to reach or exceed 100 wins.

What if we change the game so that players cannot re-use integers?

For example, two players might take turns drawing from a common pool of numbers of 1..15 without replacement until they reach a total >= 100.

Given an integer `maxChoosableInteger` and another integer `desiredTotal`, representing there are `1, 2, 3, ..., maxChoosableInteger` in the pool in the begining and the target sum to win is `desiredTotal`.

Determine if the first player has a winning strategy, assuming both players play optimally.
 *
 * Example :
 *   **Example 1:**

```
Input:  maxChoosableInteger = 10, desiredTotal = 11
Output: false
Explanation: 
    No matter which integer the first player choose, the first player will lose.
    The first player can choose an integer from 1 up to 10.
    If the first player choose 1, the second player can only choose integers from 2 up to 10.
    The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
    Same with other integers chosen by the first player, the second player will always win.
```

**Example 2:**

```
Input: maxChoosableInteger = 10, desiredTotal = 10
Output: true
Explanation: The first player chooses 10 and wins the game.
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/can-i-win/description
 * @date   2019-07-03 17:35:38
 */
public class L_0985_Can_I_Win {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
