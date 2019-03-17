package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给定 n 个非负的整数，寻找最大的 或 和 最小的或之和，最大与之和，和最小的与之和
 * 
 *      输入:
 *          n = 3
 *          nums = [1, 2, 3]
 *      输出: 
 *          7
 *      解释:
 *           1
 *          10
 *          11
 *          最大或和：3，最小或和：1，最大与和：3，最小与和：0。
 *          答案：3 + 1 + 3 + 0 = 7。
 *
 * 最大或和为在 n 个数中，任取若干个数（不能不取），进行或运算后最大的数。
 * 最小或和为在 n 个数中，任取若干个数（不能不取），进行或运算后最小的数。
 * 最大与和为在 n 个数中，任取若干个数（不能不取），进行与运算后最大的数。
 * 最小与和为在 n 个数中，任取若干个数（不能不取），进行与运算后最小的数。
 * 
 * 数字为32位，n 为 1, 000,000
 * 
 * @author rays1
 *
 */
public class L_0782_AND_and_OR {

    /**
     * 
     * 一个数 AND 另一个数结果都不会变更大，
     *      最大与和 = max { nums }
     *      最小与和 = 所有数与，因为假设某几个数字与的结果最小，那么这个最小数和剩下的数字与也不会变的更大，最终还是数字本身
     * 
     * 一个数 OR  另一个数结果都不会变的更小
     *      最大或和 = 所有数字或，因为假设某几个数字或的结果最大，那么这个最大数和其他的数字或也不会变的更小，最终还是数字本身
     *      最小或和 = min { nums }
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public long getSum(int n, int[] nums) {
                long t1,t2,t3,t4;
                t1 = t2 = t3 = t4 = nums[0];
                for (int i = 1; i < nums.length; i++) {
                    t1 = Math.max(t1, nums[i]);
                    t2 = Math.min(t2, nums[i]);
                    t3 &= nums[i];
                    t4 |= nums[i];
                }
                return t1+t2+t3+t4;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
