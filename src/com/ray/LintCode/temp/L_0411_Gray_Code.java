package com.ray.LintCode.temp;

import java.util.ArrayList;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      The gray code is a binary numeral system where two successive values differ in only one bit.
 *      
 *      Given a non-negative integer `n` representing the total number of bits in the code, find the sequence of gray code. A gray code sequence must begin with `0` and with cover all 2<sup>n</sup> integers.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: 1
 *      Output: [0, 1]
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: 2
 *      Output: [0, 1, 3, 2]
 *      Explanation:
 *        0 - 00
 *        1 - 01
 *        3 - 11
 *        2 - 10
 *      ```
 *
 * 挑战：
 *      O(2<sup>n</sup>) time.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/gray-code/description
 * @date   2019-07-11 18:32:40
 */
public class L_0411_Gray_Code {

    /**
     * n 位的格雷码可以从 n-1 位的格雷码以上下镜射后加上新位元的方式快速的得到
     *  如  2 位的格雷码为
     *      00
     *      01
     *      11
     *      10
     *      
     *  镜面反射之后              ->       加上新位元
     *      00                      000
     *      01                      001
     *      11                      011
     *      10                      010
     * ----------------------------------------
     *      10                      110
     *      11                      111
     *      01                      101
     *      00                      100
     *      
     * @author rays1
     *
     */
    static class Solution {
    
        public List<Integer> grayCode(int n) {
            List<Integer> rs = null;
            if (n == 0) {
                rs = new ArrayList<>();
                rs.add(0);
            } else {
                rs = grayCode(n-1);
                int prefix = 1 << (n-1);
                int size = rs.size();
                for (int i = 0; i < size; i++) {
                    rs.add(rs.get(size-i-1) | prefix);
                }
            }
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        int n = 1;
        
        Out.p(new Solution().grayCode(n));
        
    }

}
