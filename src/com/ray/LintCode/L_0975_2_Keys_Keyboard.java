package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:

1. `Copy All:` You can copy all the characters present on the notepad (partial copy is not allowed).
2. `Paste:` You can paste the characters which are copied **last time**.
Given a number `n`. You have to get **exactly** `n` 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum number of steps to get `n` 'A'.
 *
 * Example :
 *   Example 1:
```
Input: 3
Output: 3
Explanation:
Intitally, we have one character 'A'.
In step 1, we use Copy All operation.
In step 2, we use Paste operation to get 'AA'.
In step 3, we use Paste operation to get 'AAA'.
```
Example 2:
```
Input: 1
Output: 0
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/2-keys-keyboard/description
 * @date   2019-07-03 17:35:22
 */
public class L_0975_2_Keys_Keyboard {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
