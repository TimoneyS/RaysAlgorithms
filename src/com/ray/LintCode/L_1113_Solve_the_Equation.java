package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Solve a given equation and return the value of x in the form of string "x=#value". The equation contains only '+', '-' operation, the variable x and its coefficient.
 *   
 *   If there is no solution for the equation, return "No solution".
 *   If there are infinite solutions for the equation, return "Infinite solutions".
 *   If there is exactly one solution for the equation, we ensure that the value of x is an integer.
 *
 * Example :
 *   **Example1**
 *   ```
 *   Input: "x+5-3+x=6+x-2"
 *   Output: "x=2"
 *   ```
 *   
 *   **Example2**
 *   ```
 *   Input: "x=x"
 *   Output: "Infinite solutions"
 *   ```
 *   
 *   **Example3**
 *   ```
 *   Input: "2x=x"
 *   Output: "x=0"
 *   ```
 *   
 *   **Example4**
 *   ```
 *   Input: "2x+3x-6x=x+2"
 *   Output: "x=-1"
 *   ```
 *   
 *   **Example5**
 *   ```
 *   Input: "x=x+2"
 *   Output: "No solution"
 *   ```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/solve-the-equation/description
 * @date   2019-07-03 17:38:57
 */
public class L_1113_Solve_the_Equation {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
