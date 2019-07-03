package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   You have **n** super washing machines on a line. Initially, each washing machine has some dresses or is empty.
 *   
 *   For each **move**, you could choose **any m** (1 ≤ m ≤ n) washing machines, and pass **one dress** of each washing machine to one of its adjacent washing machines **at the same time** .
 *   
 *   Given an integer array representing the number of dresses in each washing machine from left to right on the line, you should find the **minimum number of moves** to make all the washing machines have the same number of dresses. If it is not possible to do it, return -1.
 *
 * Example :
 *   **Example1**
 *   ```
 *   Input: [1,0,5]
 *   Output: 3
 *   Explanation: 
 *   1st move:    1     0 <-- 5    =>    1     1     4
 *   2nd move:    1 <-- 1 <-- 4    =>    2     1     3    
 *   3rd move:    2     1 <-- 3    =>    2     2     2   
 *   ```
 *   **Example2**
 *   ```
 *   Input: [0,3,0]
 *   Output: 2
 *   Explanation: 
 *   1st move:    0 <-- 3     0    =>    1     2     0    
 *   2nd move:    1     2 --> 0    =>    1     1     1     
 *   ```
 *   **Example3**
 *   ```
 *   Input: [0,2,0]
 *   Output: -1
 *   Explanation: 
 *   It's impossible to make all the three washing machines have the same number of dresses. 
 *   ```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/super-washing-machines/description
 * @date   2019-07-03 17:40:47
 */
public class L_1194_Super_Washing_Machines {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
