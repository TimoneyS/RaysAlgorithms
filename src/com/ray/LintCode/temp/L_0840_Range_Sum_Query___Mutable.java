package com.ray.LintCode.temp;

/**
 * 描述：
 *      Given an integer array `nums`, and then you need to implement two functions:
 *      
 *      - `update(i, val)` Modify the element whose index is i to val.
 *      - `sumRange(l, r)` Return the sum of elements whose indexes are in range of $[l, r]$.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: 
 *        nums = [1, 3, 5]
 *        sumRange(0, 2)
 *        update(1, 2)
 *        sumRange(0, 2)
 *      Output:
 *        9
 *        8
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input:
 *        nums = [0, 9, 5, 7, 3]
 *        sumRange(4, 4)
 *        sumRange(2, 4)
 *        update(4, 5)
 *        update(1, 7)
 *        update(0, 8)
 *        sumRange(1, 2)
 *      Output:
 *        3
 *        15
 *        12
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/range-sum-query-mutable/description
 * @date   2019-07-11 18:37:21
 */
public class L_0840_Range_Sum_Query___Mutable {

    static class NumArray {

        int[] sumOf;
        
        public NumArray(int[] nums) {
            sumOf = new int[nums.length];
            sumOf[0] = nums[0];
            for (int i = 1; i < nums.length; i++)
                sumOf[i] = sumOf[i-1] + nums[i];
        }
        
        public void update(int i, int val) {
            int diff = val - sumRange(i, i);
            for (int j = i; j < sumOf.length; j++ ) {
                sumOf[j] += diff;
            }
        }
        
        public int sumRange(int i, int j) {
            return sumOf[j] - (i > 0 ? sumOf[i-1] : 0);
        }
    }
    
    public static void main(String[] args) {
        
        
    }

}