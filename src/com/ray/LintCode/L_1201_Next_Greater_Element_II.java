package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.
 *
 * Example :
 *   Example 1:
```
Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number; 
The second 1's next greater number needs to search circularly, which is also 2.
```

Example 2:
```
Input: [1]
Output: [-1]
Explanation: 
The number 1 can't find next greater number.
```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/next-greater-element-ii/description
 * @date   2019-07-03 17:40:56
 */
public class L_1201_Next_Greater_Element_II {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
