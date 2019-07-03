package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   In a forest, each rabbit has a color. Some of rabbits (possibly all of them) will tell you how many other rabbits have the same color as them. Those answers are placed in an array.

Return the minimum number of rabbits that could be in the forest.
 *
 * Example :
 *   **Example 1:**

```
Input: [1, 1, 2]
Output: 5
Explanation:
  The two rabbits that answered "1" could both be the same color, say red.
  The rabbit than answered "2" can't be red or the answers would be inconsistent.
  Say the rabbit that answered "2" was blue.
  Then there should be 2 other blue rabbits in the forest that didn't answer into the array.
  The smallest possible number of rabbits in the forest is therefore 5: 3 that answered plus 2 that didn't.
```

**Example 2:**

```
Input: [10, 10, 10]
Output: 11
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/rabbits-in-forest/description
 * @date   2019-07-03 17:37:00
 */
public class L_1035_Rabbits_in_Forest {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
