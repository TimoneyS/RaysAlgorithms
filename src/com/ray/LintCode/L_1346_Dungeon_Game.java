package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

 

Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

 

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

```plain
| -2(K)   | -3     | 3        |
| -5      | -10    | 1        |
| 10      | 30     | -5(P)    |
```
 *
 * Example :
 *   **Example 1**

```plain
Input: [[-2,-3,3],[-5,-10,1],[10,30,-5]]
Output: 7
Explanation:
The path right-> right -> down-> down is the best.
```

**Example 2**

```plain
Input: [[-2,0,3],[-5,100,-999],[10,30,-5]]
Output: 3
Explanation:
The path right -> down -> down -> right is the best.
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/dungeon-game/description
 * @date   2019-07-03 17:44:40
 */
public class L_1346_Dungeon_Game {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
