package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D map, in this map:
1. `0` represents the obstacle can't be reached.
2. `1` represents the ground can be walked through.
3. The place with number bigger than 1 represents a tree can be walked through, and this positive number represents the tree's height.
You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with lowest height first. And after cutting, the original place has the tree will become a grass (value 1).

You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees. If you can't cut off all the trees, output -1 in that situation.

Data assurance that no two trees have the same height and there is at least one tree needs to be cut off.
 *
 * Example :
 *   **Example 1:**
```
Input：[[1,2,3],[0,0,4],[7,6,5]]
Output：6
Explanation：(0,0)->(0,1)->(0,2)->(1,2)->(2,2)->(2,1)->(2,0)，and return 6.
``` 

**Example 2:**
```
Input：[[1,2,3],[0,0,0],[7,6,5]]
Output：-1
Explanation：unable to achieve.
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/cut-off-trees-for-golf-event/description
 * @date   2019-07-03 17:38:34
 */
public class L_1092_Cut_Off_Trees_for_Golf_Event {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
