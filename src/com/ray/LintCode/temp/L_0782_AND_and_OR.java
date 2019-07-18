package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Give n non-negative integers, find the sum of maximum **OR** sum, minimum **OR** sum, maximum **AND** sum, minimum **AND** sum.
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input:
 *      n = 3
 *      nums = [1, 2, 3]
 *      Output: 
 *      7
 *      Explanation:
 *      maximum OR sum: 3, minimum OR sum: 1, maximum AND sum: 3, minimum AND sum: 0.
 *      result: 3 + 1 + 3 + 0 = 7.
 *      ```
 *      Example 2:
 *      ```
 *      Input:
 *      n = 3
 *      nums = [0, 0, 1]
 *      Output: 
 *      2
 *      Explanation:
 *      maximum OR sum: 1, minimum OR sum: 0, maximum AND sum: 1, minimum AND sum: 0.
 *      result: 1 + 0 + 1 + 0 = 2.
 *      ```
 *      Example 3:
 *      ```
 *      Input:
 *      n = 5
 *      nums = [12313, 156, 4564, 212, 12]
 *      Output: 
 *      25090
 *      Explanation:
 *      maximum OR sum: 12765, minimum OR sum: 12, maximum AND sum: 12313, minimum AND sum: 0.
 *      result: 12765 + 12 + 12313 = 25090
 *      ```
 *      Example 4:
 *      ```
 *      Input:
 *      n = 3
 *      nums = [111111, 333333, 555555]
 *      Output: 
 *      1588322
 *      Explanation:
 *      maximum OR sum: 917047, minimum OR sum: 111111, maximum AND sum: 555555, minimum AND sum: 4609.
 *      result: 917047+ 111111+ 555555+ 4609 = 1588322.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/and-and-or/description
 * @date   2019-07-11 18:36:39
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
