package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given an array of integers, find out whether there are two distinct indices `i` and `j` in the array such that the absolute difference between `nums[i]` and `nums[j]` is at most `t` and the absolute difference between `i` and `j` is at most `k`.
 *
 * Example :
 *   **Example1**

```
Input: nums = [1,3,1], k = 1, t = 1
Output: false
Explanation: 
nums[2] = 1, nums[1] = 3, nums[1] - nums[2] = 2 > t
nums[0] = 1, nums[2] = 1, nums[1] - nums[2] = 0 < t,
2 - 0 = 2 > k
```

**Example2**

```
Input: nums = [1,3,1], k = 1, t = 2
Output: true
Explanation: 
nums[2] = 1, nums[1] = 3, nums[1] - nums[2] = 2 = t,
2 - 1 = 1 = k
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/contains-duplicate-iii/description
 * @date   2019-07-03 17:44:25
 */
public class L_1318_Contains_Duplicate_III {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
