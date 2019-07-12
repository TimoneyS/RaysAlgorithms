package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Start from integer 1, remove any integer that contains 9 such as 9, 19, 29...
 *      
 *      So now, you will have a new integer sequence: 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, ...
 *      
 *      Given a positive integer `n`, you need to return the n-th integer after removing. Note that 1 will be the first integer.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：88
 *      Output：107
 *      Explanation：
 *      remove the number containing 9, and the eighty-eighth number is 107
 *      ```
 *      
 *      
 *      
 *      **Example 2:**
 *      ```
 *      Input：9
 *      Output：10
 *      Explanation：
 *      remove the number containing 9, and the ninth number is 10
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/remove-9/description
 * @date   2019-07-11 18:38:05
 */
public class L_0865_Remove_9 {


    // 10进制-》9进制
    static class Solution {
    
        public long newInteger(int n) {
            long rs = 0;
            int i = 0;
            while (n > 0) {
                rs = (long) (Math.pow(10, i) * (n % 9) + rs);
                n /= 9;
                i++;
            }
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
