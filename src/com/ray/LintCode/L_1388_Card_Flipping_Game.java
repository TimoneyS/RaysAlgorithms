package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   On a table are N cards, with a positive integer printed on the front and back of each card (possibly different).
 *   
 *   We flip any number of cards, and after we choose one card. 
 *   
 *   If the number X on the back of the chosen card is not on the front of any card, then this number X is good.
 *   
 *   What is the smallest number that is good?  If no number is good, output 0.
 *   
 *   Here, fronts[i] and backs[i] represent the number on the front and back of card i. 
 *   
 *   A flip swaps the front and back numbers, so the value on the front is now on the back and vice versa.
 *
 * Example :
 *   **Example 1:**
 *   ```
 *   Input: fronts = [1,2,4,4,7], backs = [1,3,4,1,3]
 *   Output: 2
 *   Explanation: If we flip the second card, the fronts are [1,3,4,4,7] and the backs are [1,2,4,1,3].
 *   We choose the second card, which has number 2 on the back, and it isn't on the front of any card, so 2 is good.
 *   ```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/card-flipping-game/description
 * @date   2019-07-03 17:45:28
 */
public class L_1388_Card_Flipping_Game {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
