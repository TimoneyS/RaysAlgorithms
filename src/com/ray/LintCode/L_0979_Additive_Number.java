package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Additive number is a string whose digits can form additive sequence.
 *   
 *   A valid additive sequence should contain **at least** three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
 *
 * Example :
 *   Example 1:
```
Input:
"112358"
Output:
true
Explanation:
"112358"is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
```

Example 2:
```
Input:
"1"
Output:
false
```
 *
 * Challenge :
 *   How would you handle overflow for very large input integers?
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/additive-number/description
 * @date   2019-07-03 17:35:29
 */
public class L_0979_Additive_Number {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
