package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Arrays;

/**
 * Find the Smallest Divisor Given a Threshold
 * -----------------------------------------------------------------------------
 * Given an array of integers nums and an integer threshold, we will choose a positive integer divisor and divide all the array by it and sum the result of the division. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.
 * Each result of division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
 * It is guaranteed that there will be an answer.
 *
 * Example:
 *      Example 1
 *      Input: nums = [1,2,5,9], threshold = 6
 *      Output: 5
 *      Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
 *      If the divisor is 4 we can get a sum to 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2). 
 *      Example 2
 *      Input: nums = [2,3,5,7,11], threshold = 11
 *      Output: 3
 *      Example 3
 *      Input: nums = [19], threshold = 5
 *      Output: 4
 *      Constraints:
 *      	1 <= nums.length <= 5 * 10^4
 *      	1 <= nums[i] <= 10^6
 *      	nums.length <= threshold <= 10^6
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/find-the-smallest-divisor-given-a-threshold/
 * @since   2020-03-29 09:57:17
 */
public class L1408_Find_the_Smallest_Divisor_Given_a_Threshold {
    /**
     * 二分搜索
     */
    static class Solution {
        public int smallestDivisor(int[] nums, int threshold) {
            int l = 1;
            int r = Arrays.stream(nums).max().getAsInt();
            while (l < r) {
                int m = l + (r - l) / 2;
                int t = threshold(nums, m);
                if (t <= threshold) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            return r;
        }

        private int threshold(int[] nums, int devi) {
            int rs = 0;
            for (int n : nums) {
                if (n % devi == 0) rs += n / devi;
                else rs += n / devi + 1;
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
