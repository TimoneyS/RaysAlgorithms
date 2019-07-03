package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Suppose you have **N** integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these **N** numbers successfully if one of the following is true for the `ith` position (1 <= i <= N) in this array:

1. The number at the `ith` position is divisible by i.
2. **i** is divisible by the number at the ith position.
Now given N, how many beautiful arrangements can you construct?
 *
 * Example :
 *   **Example1**
```
Input: 2
Output: 2
Explanation: 

The first beautiful arrangement is [1, 2]:

Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).

Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).

The second beautiful arrangement is [2, 1]:

Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).

Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
```
**Example2**
```
Input: 3
Output: 3
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/beautiful-arrangement/description
 * @date   2019-07-03 17:35:46
 */
public class L_0990_Beautiful_Arrangement {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
