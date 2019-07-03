package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given an integer array nums, find the sum of the elements between indices `i` and `j` `(i ≤ j)`, inclusive.
 *
 * Example :
 *   **Example1**

```
Input: nums = [-2, 0, 3, -5, 2, -1]
sumRange(0, 2)
sumRange(2, 5)
sumRange(0, 5)
Output:
1
-1
-3
Explanation: 
sumRange(0, 2) -> (-2) + 0 + 3 = 1
sumRange(2, 5) -> 3 + (-5) + 2 + (-1) = -1
sumRange(0, 5) -> (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
```

**Example2**

```
Input: 
nums = [-4, -5]
sumRange(0, 0)
sumRange(1, 1)
sumRange(0, 1)
sumRange(1, 1)
sumRange(0, 0)
Output: 
-4
-5
-9
-5
-4
Explanation: 
sumRange(0, 0) -> -4
sumRange(1, 1) -> -5
sumRange(0, 1) -> (-4) + (-5) = -9
sumRange(1, 1) -> -5
sumRange(0, 0) -> -4
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/range-sum-query-immutable/description
 * @date   2019-07-03 17:34:57
 */
public class L_0943_Range_Sum_Query_Immutable {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
