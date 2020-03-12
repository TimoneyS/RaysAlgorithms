package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Count of Range Sum
 * -----------------------------------------------------------------------------
 * Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
 * Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.
 * Note:
 * A naive algorithm of O(n2) is trivial. You MUST do better than that.
 *
 * Example:
 *      Example 1
 *      Input: nums = [-2,5,-1], lower = -2, upper = 2,
 *      Output: 3 
 *      Explanation: The three ranges are : [0,0], [2,2], [0,2] and their respective sums are: -2, -1, 2.
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/count-of-range-sum/
 * @since   2020-03-12 22:54:09
 */
public class L0327_Count_of_Range_Sum {
    /**
     * 将所有的和列出，然后暴力搜索。
     */
    static class Solution {
        public int countRangeSum(int[] nums, int lower, int upper) {
            if(nums == null || nums.length == 0){
                return 0;
            }
            int count = 0;
            long[] res = new long[nums.length];
            long sum = 0;
            for(int i = 0; i < nums.length; i++){
                if(lower<= nums[i] && nums[i]<=upper){//单个数值在所给区间范围
                    count++;
                }
                sum += nums[i];
                res[i] = sum;
            }
            for(int i = 1; i < nums.length; i++){
                if(lower<= res[i] && res[i]<=upper){//从第0个到第i个元素之和在所给区间范围
                    count++;
                }
                for(int j = 0; j < i-1; j++){
                    long z = res[i] - res[j];
                    if(lower<= z && z<=upper){ //从第i(i>0)个到第j个元素之和在所给区间范围
                        count++;
                    }
                }
            }
            return count;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
