package com.ray.LintCode.done;

/**
 * 描述：
 *      Given an integer array nums, find the sum of the elements between indices `i` and `j` `(i ≤ j)`, inclusive.
 *
 * 用例：
 *      **用例1**
 *      
 *      ```
 *      输入: nums = [-2, 0, 3, -5, 2, -1]
 *      sumRange(0, 2)
 *      sumRange(2, 5)
 *      sumRange(0, 5)
 *      输出:
 *      1
 *      -1
 *      -3
 *      解释: 
 *      sumRange(0, 2) -> (-2) + 0 + 3 = 1
 *      sumRange(2, 5) -> 3 + (-5) + 2 + (-1) = -1
 *      sumRange(0, 5) -> (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
 *      ```
 *      
 *      **用例2**
 *      
 *      ```
 *      输入: 
 *      nums = [-4, -5]
 *      sumRange(0, 0)
 *      sumRange(1, 1)
 *      sumRange(0, 1)
 *      sumRange(1, 1)
 *      sumRange(0, 0)
 *      输出: 
 *      -4
 *      -5
 *      -9
 *      -5
 *      -4
 *      解释: 
 *      sumRange(0, 0) -> -4
 *      sumRange(1, 1) -> -5
 *      sumRange(0, 1) -> (-4) + (-5) = -9
 *      sumRange(1, 1) -> -5
 *      sumRange(0, 0) -> -4
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/range-sum-query-immutable/description
 * @date   2019-07-20 12:00:36
 */
public class L_0943_Range_Sum_Query_Immutable {

    /**
     * 数组区间和等于数组阶段和相减。
     * 
     * @author rays1
     *
     */
    static class NumArray {

        int[] S ;
        
        public NumArray(int[] nums) {
            S = new int[nums.length+1];
            for (int i = 1; i < S.length; i++) {
                S[i] = S[i-1] + nums[i-1];
            }
        }
        
        public int sumRange(int i, int j) {
            return S[j+1] - S[i];
        }
    }
    
    public static void main(String[] args) {
        
    }

}
