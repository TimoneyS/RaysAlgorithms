package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   You are given an array x of `n` positive numbers. You start at point `(0,0)` and moves `x[0]` metres to the north, then `x[1]` metres to the west, `x[2]` metres to the south, `x[3]` metres to the east and so on. In other words, after each move your direction changes counter-clockwise.

Write a one-pass algorithm with `O(1)` extra space to determine, if your path crosses itself, or not.
 *
 * Example :
 *   **Example 1:**
```
Input：[2, 1, 1, 2]
Output：true
Explanation：
?????
?   ?
???????>
    ?
```
**Example 2:**
```
Input：[1, 2, 3, 4]
Output：false
Explanation：
????????
?      ?
?
?
?????????????>
```
**Example 3:**
```
Input：[1, 1, 1, 1]
Output：true
Explanation：
?????
?   ?
?????>
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/self-crossing/description
 * @date   2019-07-03 17:42:45
 */
public class L_1286_Self_Crossing {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
