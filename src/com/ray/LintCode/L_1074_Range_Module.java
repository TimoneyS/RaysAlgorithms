package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   A Range Module is a module that tracks ranges of numbers. Your task is to design and implement the following interfaces in an efficient manner.
 *   
 *   - `addRange(int left, int right)` Adds the half-open interval `[left, right)`, tracking every real number in that interval. Adding an interval that partially overlaps with currently tracked numbers should add any numbers in the interval `[left, right)` that are not already tracked.
 *   - `queryRange(int left, int right)` Returns true if and only if every real number in the interval `[left, right)` is currently being tracked.
 *   - `removeRange(int left, int right)` Stops tracking every real number currently being tracked in the interval `[left, right)`.
 *
 * Example :
 *   **Example 1**

```plain
Input:
addRange(10,20)
removeRange(14,16)
queryRange(10,14)
queryRange(13,15)
queryRange(16,17)

Output: [true,false,true]
Explanation:
Every number in [10, 14) is being tracked
Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked
The number 16 in [16, 17) is still being tracked, despite the remove operation
```

**Example 2**

```plain
Input:
addRange(1,2)
queryRange(2,3)
addRange(11,20)
queryRange(15,20)

Output: [false,true]
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/range-module/description
 * @date   2019-07-03 17:37:53
 */
public class L_1074_Range_Module {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
