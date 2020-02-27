package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayList;
import java.util.List;

/**
 * Insert Interval
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example:
 *      Example 1
 *      Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 *      Output: [[1,5],[6,9]]
 *      Example 2
 *      Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 *      Output: [[1,2],[3,10],[12,16]]
 *      Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *      NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/insert-interval/
 * @since   2020-02-27 22:30:49
 */
public class L0057_Insert_Interval {
    /**
     * 遍历区间，如果新区间比旧区间大，则旧区间不动，如果新区间和旧区间相交，则吃掉旧区间
     * 如果新区间比旧区间小，则插入完毕
     */
    static class Solution {
        public int[][] insert(int[][] intervals, int[] b) {
            int index = 0;
            List<int[]> rs = new ArrayList<>();
            for (int[] a : intervals) {
                if (b[1] < a[0]) {
                    rs.add(index, b);
                    b = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
                    rs.add(a);
                } else if (b[0] <= a[1] ) {
                    index--;
                    b[0] = Math.min(a[0], b[0]);
                    b[1] = Math.max(a[1], b[1]);
                } else {
                    rs.add(a);
                }
                index++;
            }

            if (b[0] != Integer.MAX_VALUE) {
                rs.add(b);
            }

            return rs.toArray(new int[0][0]);
        }

    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
