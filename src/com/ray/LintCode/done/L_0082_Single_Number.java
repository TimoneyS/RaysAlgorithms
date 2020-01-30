package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      2 * n + 1 个数字，每个数字出现两次，只有一个数字只出现一次
 *      找出只出现一个的数字
 * 挑战：
 *      一次遍历，常量额外空间
 *      One-pass, constant extra space.
 *
 * 难度： Simple
 *   
 * @author rays1
 * @link   https://www.lintcode.cn/problem/single-number/description
 * @since  2019-07-11 18:29:59
 */
public class L_0082_Single_Number {
    /**
     * a ^ a ^ b = b
     */
    static class Solution {
        public int singleNumber(int[] A) {
            int num = 0;
            for (int i : A) num = num ^ i;
            return num;
        }
    }

    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
