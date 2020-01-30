package com.ray.LintCode.done;

import java.util.Arrays;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      2 * n + 2 个数字，每个数字出现两次，除了两个
 *      找到这两个数字
 *
 * 挑战：
 *      O(n) time, O(1) extra space.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @link   https://www.lintcode.cn/problem/single-number-iii/description
 * @since  2019-07-11 18:30:00
 */
public class L_0084_Single_Number_III {
    /**
     * 从 a ^ b 中分离 a 和 b
     * a 和 b 一定在某个二进制位上不同，那么按照这个不同
     * 进行两个异或的算法
     */
    static class Solution {
        public List<Integer> singleNumberIII(int[] A) {
            int xor = 0;
            for (int n : A) xor ^= n;
            int lastBit = xor - (xor & (xor-1));
            int n1 = 0, n2 = 0;
            for (int n : A) {
                if ((lastBit & n) == 0) {
                    n1 ^= n;
                } else {
                    n2 ^= n;
                }
            }
            return Arrays.asList(n1, n2);
        }
    }
    
    public static void main(String[] args) {
        int[] A = new int[] {0b1011, 0b1111};
        Out.p(new Solution().singleNumberIII(A));
    }
}