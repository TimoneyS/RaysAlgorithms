package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Patching Array
 * -----------------------------------------------------------------------------
 * 给定一个已排序的正整数数组 nums，和一个正整数 n 。从 [1, n] 区间内选取任意个数字补充到 nums 中，
 * 使得 [1, n] 区间内的任何数字都可以用 nums 中某几个数字的和来表示。
 * 请输出满足上述要求的最少需要补充的数字个数。
 *
 * Example:
 *      Example 1
 *      Input: nums = [1,3], n = 6
 *      Output: 1 
 *      Explanation:
 *      Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
 *      Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
 *      Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
 *      So we only need 1 patch.
 *      Example 2
 *      Input: nums = [1,5,10], n = 20
 *      Output: 2
 *      Explanation: The two patches can be [2, 4].
 *      Example 3
 *      Input: nums = [1,2,2], n = 5
 *      Output: 0
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/patching-array/
 * @since   2020-03-12 23:58:07
 */
public class L0330_Patching_Array {
    static public class Solution {
        public int minPatches(int[] nums, int n) {
            int patches = 0, i = 0;
            long miss = 1; // use long to avoid integer overflow error
            while (miss <= n) {
                if (i < nums.length && nums[i] <= miss) // miss is covered
                    miss += nums[i++];
                else { // patch miss to the array
                    miss += miss;
                    patches++; // increase the answer
                }
            }
            return patches;
        }
    }
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
