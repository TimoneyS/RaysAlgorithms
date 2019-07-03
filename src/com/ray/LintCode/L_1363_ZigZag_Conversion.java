package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given a string `s` and an integer `numRows`. You need to place `s` like zigzag. Then read the 'zigzag' line by line. Return the string you read.

Notice that zigzag extends according to the directions of down->up-right->down->up-right...

```
|   /|   /|
|  / |  / | ...
| /  | /  | ...
|/   |/   |/
```
 *
 * Example :
 *   **Example 1:**

```
Input: "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Explanation: 
    After conversion, we get
    P   A   H   N
    A P L S I I G
    Y   I   R
    Read line by line, the answer is "PAHNAPLSIIGYIR".
```

**Example 2:**

```
Input: "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation: 
    After conversion, we get
    P     I     N
    A   L S   I G
    Y A   H R
    P     I
    Read line by line, the answer is "PINALSIGYAHRPI".
```

**Example 3:**

```
Input: "PAYPALISHIRING", numRows = 1
Output: "PAYPALISHIRING"
Explanation: 
    After conversion, we get
    PAYPALISHIRING
    Read line by line, the answer is "PAYPALISHIRING".
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/zigzag-conversion/description
 * @date   2019-07-03 17:45:14
 */
public class L_1363_ZigZag_Conversion {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
