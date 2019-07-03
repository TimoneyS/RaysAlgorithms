package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   A move consists of taking a point `(x, y)` and transforming it to either `(x, x+y)` or `(x+y, y)`.
 *   
 *   Given a starting point `(sx, sy)` and a target point `(tx, ty)`, return `True` if and only if a sequence of moves exists to transform the point `(sx, sy)` to `(tx, ty)`. Otherwise, return `False`.
 *
 * Example :
 *   **Example 1:**
 *   ```
 *   Input: sx = 1, sy = 1, tx = 3, ty = 5
 *   Output: True
 *   Explanation:
 *   One series of moves that transforms the starting point to the target is:
 *   (1, 1) -> (1, 2)
 *   (1, 2) -> (3, 2)
 *   (3, 2) -> (3, 5)
 *   ```
 *   **Example 2:**
 *   ```
 *   Input: sx = 1, sy = 1, tx = 2, ty = 2
 *   Output: False
 *   ```
 *   **Example 3:**
 *   ```
 *   Input: sx = 1, sy = 1, tx = 1, ty = 1
 *   Output: True
 *   ```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/reaching-points/description
 * @date   2019-07-03 17:37:02
 */
public class L_1036_Reaching_Points {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
