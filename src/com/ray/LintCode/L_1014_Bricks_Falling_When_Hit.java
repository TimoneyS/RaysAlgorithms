package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   We have a grid of `1` and `0`; the `1` in a cell represent bricks.  A brick will not drop if and only if it is directly connected to the bottom of the grid, or at least one of its (4-way) adjacent bricks will not drop.

We will do some erasures sequentially. Each time we want to do the erasure at the location (i, j), the brick (if it exists) on that location will disappear, and then some other bricks may drop because of that erasure.

Return an array representing the number of bricks that will drop after each erasure in sequence.
 *
 * Example :
 *   **Example 1:**

```
Input: grid = [[1,0,0,0],[1,1,1,0]], hits = [[1,0]]
Output: [2]
Explanation: If we erase the brick at (1, 0), the brick at (1, 1) and (1, 2) will drop. So we should return 2.
```

**Example 2:**

```
Input: grid = [[1,0,0,0],[1,1,0,0]], hits = [[1,1],[1,0]]
Output: [0,0]
Explanation: When we erase the brick at (1, 0), the brick at (1, 1) has already disappeared due to the last move.
```

**Example 3:**

```
Input: grid = [[1],[1],[1]], hits = [[0,0],[0,0]]
Output: [2,0]
Explanation: When we hit (0, 0) the first time, two other bricks will drop. When we hit the second time, there is no any brick.
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/bricks-falling-when-hit/description
 * @date   2019-07-03 17:36:23
 */
public class L_1014_Bricks_Falling_When_Hit {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
