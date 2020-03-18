package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Wiggle Subsequence
 * -----------------------------------------------------------------------------
 * A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.
 * For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.
 * Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.
 *
 * Example:
 *      Example 1
 *      Input: [1,7,4,9,2,5]
 *      Output: 6
 *      Explanation: The entire sequence is a wiggle sequence.
 *      Example 2
 *      Input: [1,17,5,10,13,15,10,5,16,8]
 *      Output: 7
 *      Explanation: There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].
 *      Example 3
 *      Input: [1,2,3,4,5,6,7,8,9]
 *      Output: 2
 *      Follow up:
 *      Can you do it in O(n) time?
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/wiggle-subsequence/
 * @since   2020-03-18 22:56:54
 */
public class L0376_Wiggle_Subsequence {
    /**
     * 贪心算法：
     *      考虑到数字 i 时，长度为 size
     *
     *      下一个数字 j 有多种情况
     *      1. i == j， size 不变
     *      2. i < j，且 j 能够成为摆动序列，那么 size + 1
     *      3. i > j，且 j 能够成为摆动序列，那么 size + 1
     *      4. i > j，且 j 不能成为摆动序列，那么 size 不变
     *          既然不能成为摆动序列，那么必然是因为当前的序列需要找一个比 i 大的元素
     *          那么如果我们用 j 替换 i，当前的序列一定还是一个摆动序列
     *          同时这个序列能够更容易的找到下一个大于 i 的数字
     *          因此只要简单的令 i = j 即可
     *      5. i < j，且 j 不能成为摆动序列，那么 size + 1
     *          同上
     */
    static class Solution {
        public int wiggleMaxLength(int[] nums) {
            int c = 0, size = 0, end = 0;
            for (int num : nums) {
                if (size == 0) {
                    size++;
                } else if ((c == 0 && size > 0 || c > 0) && num > end) {
                    c = -1;
                    size++;
                } else if ((c == 0 && size > 0 || c < 0) && num < end) {
                    c = 1;
                    size++;
                }
                end = num;
            }
            return size;
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1,17,5,10,13,15,10,5,16,8};
        Out.p(new Solution().wiggleMaxLength(nums));
    }
}
