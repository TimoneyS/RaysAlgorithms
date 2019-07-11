package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Count how many `1` in binary representation of a 32-bit integer.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input: 32
 *      Output: 1
 *      Explanation:
 *      32(100000), return 1.
 *      ```
 *      **Example 2:**
 *      ```
 *      Input: 5
 *      Output: 2
 *      Explanation:
 *      5(101), return 2.
 *      ```
 *
 * 挑战：
 *      If the integer is *n* bits with *m* 1 bits. Can you do it in O(m) time?
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/count-1-in-binary/description
 * @date   2019-07-11 18:32:10
 */
public class L_0365_Count_1_in_Binary {

    static class Solution {
    
        public int countOnes(int num) {
            byte[] arr = Integer.toBinaryString(num).getBytes();
            int count = 0;
            for (byte b : arr) if (b == 49) count ++;
            return count;            
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
