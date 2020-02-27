package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Merge Intervals
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example:
 *      Example 1
 *      Input: [[1,3],[2,6],[8,10],[15,18]]
 *      Output: [[1,6],[8,10],[15,18]]
 *      Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *      Example 2
 *      Input: [[1,4],[4,5]]
 *      Output: [[1,5]]
 *      Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *      NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/merge-intervals/
 * @since   2020-02-27 22:29:48
 */
public class L0056_Merge_Intervals {
    static class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
            List<int[]> rs = new ArrayList<>();

            int[] old = null;
            for (int[] i : intervals) {
                if (old == null) {
                    old = i;
                } else {
                    if (isIntersect(old, i)) {
                        old = merge(old, i);
                    } else {
                        rs.add(old);
                        old = i;
                    }
                }
            }
            if (old != null) rs.add(old);

            return rs.toArray(new int[][]{});
        }

        boolean isIntersect(int[] i1, int[] i2) {
            return !(i1[0] > i2[1] || i2[0] > i1[1]);
        }

        int[] merge(int[] i1, int[] i2) {
            return new int[]{Math.min(i1[0], i2[0]), Math.max(i1[1], i2[1])};
        }

    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
