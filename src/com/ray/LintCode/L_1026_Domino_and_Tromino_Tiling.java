package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   We have two types of tiles: a 2x1 domino shape, and an "L" tromino shape. These shapes may be rotated.

```
XX  <- domino

XX  <- "L" tromino
X

```

Given `N`, how many ways are there to tile a 2 x N board? Return your answer modulo `10^9 + 7`.

(In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.)
 *
 * Example :
 *   **Example 1:**

```
Input: 3
Output: 5
Explanation: The five different ways are listed below, different letters indicates different tiles:
  1. XYZ  2. XXZ  3. XYY  4. XXY  5. XYY
     XYZ     YYZ     XZZ     XYY     XXY
```

**Example 2:**

```
Input: 1
Output: 1
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/domino-and-tromino-tiling/description
 * @date   2019-07-03 17:36:46
 */
public class L_1026_Domino_and_Tromino_Tiling {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
