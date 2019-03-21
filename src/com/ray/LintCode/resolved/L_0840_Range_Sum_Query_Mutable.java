package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * Given an integer array nums, and then you need to implement two functions:
 * update(i, val) Modify the element whose index is i to val.
 * sumRange(l, r) Return the sum of elements whose indexes are in range of [l, r][l,r].
 *
 * @author  rays1
 * @url     https://www.lintcode.com/problem/range-sum-query-mutable/description
 */
public class L_0840_Range_Sum_Query_Mutable {

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
        
        NumArray na = new NumArray(new int[] {1,3,5});
        
        Out.p(na.sumRange(0, 2));
        na.update(1, 2);
        Out.p(na.sumRange(0, 2));        
        
        
    }

}
