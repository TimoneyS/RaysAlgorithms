package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given several boxes with different colors represented by different positive numbers. 
 *   You may experience several rounds to remove boxes until there is no box left. Each time you can choose some continuous boxes with the same color (composed of k boxes, k >= 1), remove them and get k*k points.
 *   Find the maximum points you can get.
 *
 * Example :
 *   **Example 1:**
 *   ```
 *   Input：[1, 3, 2, 2, 2, 3, 4, 3, 1]
 *   Output：23
 *   Explanation:
 *   [1, 3, 2, 2, 2, 3, 4, 3, 1] 
 *   ----> [1, 3, 3, 4, 3, 1] (3*3=9 points) 
 *   ----> [1, 3, 3, 3, 1] (1*1=1 points) 
 *   ----> [1, 1] (3*3=9 points) 
 *   ----> [] (2*2=4 points)
 *   ```
 *   
 *   
 *   **Example 2:**
 *   ```
 *   Input：[1,2,3,4,5,6,7,8,9,10]
 *   Output：10
 *   Explanation:
 *   1*1 point per round, a total of 10 rounds.
 *   ```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/remove-boxes/description
 * @date   2019-07-03 17:40:29
 */
public class L_1180_Remove_Boxes {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
