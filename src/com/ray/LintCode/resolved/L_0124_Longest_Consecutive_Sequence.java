package com.ray.LintCode.resolved;

import java.util.Arrays;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * 无序数组，寻找最长的连续数字段。
 * 
 * @author rays1
 *
 */
public class L_0124_Longest_Consecutive_Sequence {

    static class Solution {
        
        public int longestConsecutive(int[] num) {
            Arrays.sort(num);
            int max = 1;
            int t = 1;
            int prev = Integer.MIN_VALUE;
            for (int i : num) {
                if (prev + 1 == i) {
                    t ++;
                } else if (prev == i) {
                    continue;
                }else {
                    t = 1;
                }
                max = Math.max(t, max);
                prev = i;
            }
            return max;
        }
        
    }

}
