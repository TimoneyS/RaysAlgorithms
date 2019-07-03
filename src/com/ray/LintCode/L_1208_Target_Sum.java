package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols `+` and `-`. For each integer, you should choose one from `+` and `-` as its new symbol.
 *   
 *   Find out how many ways to assign symbols to make sum of integers equal to target S.
 *
 * Example :
 *   Example 1:
```
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
```

Example 2:
```
Input: nums is [], S is 3. 
Output: 0
Explanation: 
There are 0 way to assign symbols to make the sum of nums be target 3.
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/target-sum/description
 * @date   2019-07-03 17:41:09
 */
public class L_1208_Target_Sum {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
