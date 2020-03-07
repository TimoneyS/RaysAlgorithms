package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Longest Consecutive Sequence
 * -----------------------------------------------------------------------------
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * Your algorithm should run in O(n) complexity.
 *
 * Example:
 *      Example 1
 *      Input: [100, 4, 200, 1, 3, 2]
 *      Output: 4
 *      Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * @since   2020-03-07 12:40:49
 */
public class L0128_Longest_Consecutive_Sequence {
    /**
     * 用set保存每个数字，然后统计每个数字，向左，向右能够延伸的距离
     *
     * 比如对于数字 5
     *      向右就查看 6 7 8 是否在 set 中
     *      向左就查看 4 3 2 是否在 set 中
     * 直到遇到不在set 中的数字，就找到了这个数字所在的连续子序列的长度
     *
     * 为了避免重复查询，将这个子序列的数字，都从set中清除，再进行下一次的搜索
     */
    static class Solution {
        public int longestConsecutive(int[] num) {
            Set<Integer> set = new HashSet<>();
            Arrays.stream(num).forEach(set::add);
            int max = 0;
            for (int n : num) {
                if (set.contains(n)) {
                    set.remove(n);
                    int cur = 1;
                    for (int r = n + 1; set.contains(r); set.remove(r), r++) cur++;
                    for (int l = n - 1; set.contains(l); set.remove(l), l--) cur++;
                    max = Math.max(max, cur);
                }
            }
            return max;
        }
    }
    
    public static void main(String[] args) {
        int[] num = {100, 4, 200, 1, 3, 2};
        Out.p(new Solution().longestConsecutive(num));
    }
}
