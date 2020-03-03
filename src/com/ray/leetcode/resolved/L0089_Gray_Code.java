package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayList;
import java.util.List;

/**
 * Gray Code
 *
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.
 * A gray code sequence must begin with 0.
 *
 * Example:
 *      Example 1
 *      Input: 2
 *      Output: [0,1,3,2]
 *      Explanation:
 *      00 - 0
 *      01 - 1
 *      11 - 3
 *      10 - 2
 *      For a given n, a gray code sequence may not be uniquely defined.
 *      For example, [0,2,3,1] is also a valid gray code sequence.
 *      00 - 0
 *      10 - 2
 *      11 - 3
 *      01 - 1
 *      Example 2
 *      Input: 0
 *      Output: [0]
 *      Explanation: We define the gray code sequence to begin with 0.
 *                   A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
 *                   Therefore, for n = 0 the gray code sequence is [0].
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/gray-code/
 * @since   2020-03-03 22:17:15
 */
public class L0089_Gray_Code {
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
        Out.p(new Solution());
    }
}
