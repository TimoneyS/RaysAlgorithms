package com.ray.LintCode.done;

import com.ray.io.Out;

import java.util.Arrays;

/**
 * 描述：
 *      3 * n + 1 个非负的整数，每个数字出现了3次，只有一个数字只出现一次
 *      寻找只出现一个的数字
 *
 * 挑战：
 *      一次遍历，常量额外空间
 *
 * 难度： Medium
 *   
 * @author rays1
 * @link   https://www.lintcode.cn/problem/single-number-ii/description
 * @since  2019-07-11 18:29:59
 */
public class L_0083_Single_Number_II {
    /**
     * 改造二进制的异或操作
     *  0 ^ 1 = 1
     *  1 ^ 1 = 2
     *  2 ^ 1 = 0
     */
    static class Solution {
        public int singleNumberII(int[] A) {
            int[] nums = new int[32];
            Arrays.stream(A).forEach(i -> xor(nums, i));
            int n = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1)
                    n += Math.pow(2, i);
            }
            return n;
        }

        public void xor(int[] nums, int n) {
            int i = 0;
            while (n != 0) {
                nums [i] += n % 2;
                if (nums[i] == 3 || nums[i] == -3) nums[i] = 0;
                i ++;
                n /= 2;
            }
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
