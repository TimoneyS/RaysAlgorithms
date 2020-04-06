package com.ray.LintCode.tostudy;

import com.ray.io.Out;

/**
 * 描述：
 *      Given two _32_-bit numbers, _N_ and _M_, and two bit positions, _i_ and _j_. Write a method to set all bits between _i_ and _j_ in _N_ equal to _M_ (e g , _M_ becomes a substring of _N_ start from _i_ to  _j_)
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input: N=(10000000000)2 M=(10101)2 i=2 j=6
 *      Output: N=(10001010100)2
 *      ```
 *      
 *      
 *      **Example 2:**
 *      ```
 *      Input: N=(10000000000)2 M=(11111)2 i=2 j=6
 *      Output: N=(10001111100)2
 *      ```
 *
 * 挑战：
 *      Minimum number of operations?
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/update bits/description
 * @date   2019-07-11 18:31:39
 */
public class L_0179_Update_Bits {

    static class Solution {
        public int updateBits(int n, int m, int i, int j) {
            
            int cover = -1;
            cover &= (-1 << j+1);
            cover |= ((1 << i) - 1);
            
            m = m << i;
            n = ((n & cover) | m);
            
            return n;
        }
    }
    
    public static void printBinary(int m) {
        Out.p(Integer.toBinaryString(m));
    }
    
    public static void main(String[] args) {
        
        int n = 1024, m = 21, i = 2, j = 6;
        
        printBinary(n);
        printBinary(m);
        
        int rs = new Solution().updateBits(n, m, i, j);
        
        printBinary(rs);
    }

}
