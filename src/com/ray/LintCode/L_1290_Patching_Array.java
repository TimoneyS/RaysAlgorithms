package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given a sorted positive integer array nums and an integer n, add/patch elements to the array such that any number in range `[1, n]` inclusive can be formed by the sum of some elements in the array. Return the minimum number of patches required.
 *
 * Example :
 *   **Example 1:**
```
Input：[1,3],6
Output：1
Explanation：
Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
So we only need 1 patch.
```

**Example 2:**
```
Input：[1,5,10],20
Output：2
Explanation：The two patches can be [2, 4].
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/patching-array/description
 * @date   2019-07-03 17:43:08
 */
public class L_1290_Patching_Array {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
