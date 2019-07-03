package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given an array of `n` integers nums and a `target`, find the number of index triplets `i, j, k` with `0 <= i < j < k < n` that satisfy the condition `nums[i] + nums[j] + nums[k] < target`.
 *
 * Example :
 *   **Example1**

```
Input:  nums = [-2,0,1,3], target = 2
Output: 2
Explanation:
Because there are two triplets which sums are less than 2:
[-2, 0, 1]
[-2, 0, 3]
```

**Example2**

```
Input: nums = [-2,0,-1,3], target = 2
Output: 3
Explanation:
Because there are three triplets which sums are less than 2:
[-2, 0, 1]
[-2, 0, 3]
[-2, -1, 3]
```
 *
 * Challenge :
 *   Could you solve it in O(n2) runtime?
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/3sum-smaller/description
 * @date   2019-07-03 17:34:26
 */
public class L_0918_3Sum_Smaller {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
