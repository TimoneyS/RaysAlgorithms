package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   We are given non-negative integers nums[i] which are written on a chalkboard.  Alice and Bob take turns erasing exactly one number from the chalkboard, with Alice starting first.  If erasing a number causes the bitwise XOR of all the elements of the chalkboard to become 0, then that player loses.  (Also, we'll say the bitwise XOR of one element is that element itself, and the bitwise XOR of no elements is 0.)
 *   
 *   Also, if any player starts their turn with the bitwise XOR of all the elements of the chalkboard equal to 0, then that player wins.
 *   
 *   Determine if Alice has a winning stargety, assuming both players play optimally.
 *
 * Example :
 *   **Example 1:**
 *   
 *   ```
 *   Input: [1, 1, 2]
 *   Output: false
 *   Explanation: 
 *       Alice has two choices: erase 1 or erase 2. 
 *       If she erases 1, the nums array becomes [1, 2]. The bitwise XOR of all the elements of the chalkboard is 1 XOR 2 = 3. Now Bob can remove any element he wants, because Alice will be the one to erase the last element and she will lose. 
 *       If Alice erases 2 first, now nums becomes [1, 1]. The bitwise XOR of all the elements of the chalkboard is 1 XOR 1 = 0. Alice will lose.
 *   ```
 *   
 *   **Example 2:**
 *   
 *   ```
 *   Input: [1, 1, 1, 2]
 *   Output: true
 *   Explanation: Alice can erase 2 and the array becomes [1, 1, 1]. After Bob's erasure, the array becomes [1, 1] and 1 XOR 1 = 0.
 *   ```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/chalkboard-xor-game/description
 * @date   2019-07-03 17:36:14
 */
public class L_1007_Chalkboard_XOR_Game {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
