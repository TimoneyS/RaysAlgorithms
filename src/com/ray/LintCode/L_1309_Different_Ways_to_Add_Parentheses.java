package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.
 *
 * Example :
 *   **Example1**
 *   
 *   ```
 *   Input: "2-1-1"
 *   Output: [0, 2]
 *   Explanation:
 *   ((2-1)-1) = 0
 *   (2-(1-1)) = 2
 *   ```
 *   
 *   **Example2**
 *   
 *   ```
 *   Input: "2*3-4*5"
 *   Output: [-34, -14, -10, -10, 10]
 *   Explanation:
 *   (2*(3-(4*5))) = -34
 *   ((2*3)-(4*5)) = -14
 *   ((2*(3-4))*5) = -10
 *   (2*((3-4)*5)) = -10
 *   (((2*3)-4)*5) = 10
 *   ```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/different-ways-to-add-parentheses/description
 * @date   2019-07-03 17:44:03
 */
public class L_1309_Different_Ways_to_Add_Parentheses {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
