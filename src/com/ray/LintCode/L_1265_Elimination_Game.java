package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   There is a list of sorted integers from 1 to n. Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.
 *   
 *   Repeat the previous step again, but this time from right to left, remove the right most number and every other number from the remaining numbers.
 *   
 *   We keep repeating the steps again, alternating left to right and right to left, until a single number remains.
 *   
 *   Find the last number that remains starting with a list of length n.
 *
 * Example :
 *   **Example1**
 *   ```
 *   Input:
 *   n = 9
 *   Output:
 *   6
 *   Explanation:
 *   the delete order:
 *   1 2 3 4 5 6 7 8 9
 *   2 4 6 8
 *   2 6
 *   6
 *   ```
 *   **Example2**
 *   ```
 *   Input:
 *   10
 *   Output:
 *   8
 *   ```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/elimination-game/description
 * @date   2019-07-03 17:42:27
 */
public class L_1265_Elimination_Game {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
