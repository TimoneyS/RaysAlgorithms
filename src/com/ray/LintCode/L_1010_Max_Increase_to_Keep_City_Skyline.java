package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   In a 2D array `grid`, each value `grid[i][j]` represents the height of a building located there. We are allowed to increase the height of any number of buildings, by any amount (the amounts can be different for different buildings). Height 0 is considered to be a building as well. 

At the end, the "skyline" when viewed from all four directions of the grid, i.e. west, east, north, and south, must be the same as the skyline of the original grid. A city's skyline is the outer contour of the rectangles formed by all the buildings when viewed from a distance. See the following example.

What is the maximum total sum that the height of the buildings can be increased?
 *
 * Example :
 *   **Example 1:**

```
Input: 
  [ [3,0,8,4],
    [2,4,5,7],
    [9,2,6,3],
    [0,3,1,0] ]
Output: 35
Explanation: 
  The skyline viewed from north or south is: [9, 4, 8, 7]
  The skyline viewed from west or right is: [8, 7, 9, 3]
  The grid after increasing the height of buildings without affecting skylines is:
  [ [8,4,8,7],
    [7,4,7,7],
    [9,4,8,7],
    [3,3,3,3] ]
```

**Example 2:**

```
Input: [[0,0,0],[0,0,0],[0,0,0]]
Output: 0
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/max-increase-to-keep-city-skyline/description
 * @date   2019-07-03 17:36:17
 */
public class L_1010_Max_Increase_to_Keep_City_Skyline {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
