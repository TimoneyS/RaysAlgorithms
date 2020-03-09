package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.*;

/**
 * The Skyline Problem
 * -----------------------------------------------------------------------------
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).
 * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
 * For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
 * The output is a list of key points (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.
 * For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
 * Notes:
 * 	The number of buildings in any input list is guaranteed to be in the range [0, 10000].
 * 	The input list is already sorted in ascending order by the left x position Li.
 * 	The output list must be sorted by the x position.
 * 	There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
 *
 * Example:
 *      
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/the-skyline-problem/
 * @since   2020-03-09 21:22:15
 */
public class L0218_The_Skyline_Problem {
    static class Solution {
        public List<List<Integer>> getSkyline(int[][] buildings) {

            List<List<Integer>> rs = new ArrayList<>();
            List<int[]> events = new ArrayList<>();

            for (int[] is : buildings) {
                events.add(new int[] {is[0],  is[2]});
                events.add(new int[] {is[1], -is[2]});
            }
            events.sort((o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
            buildResult(rs, events);
            if (rs.size() != 0)
                rs.get(rs.size() - 1).set(1, 0);
            return rs;
        }

        private void buildResult(List<List<Integer>> rs, List<int[]> events) {
            Queue<Integer> pq = new PriorityQueue<>(10, (o1, o2) -> o2-o1);
            pq.add(0);

            int prev = 0;
            for (int[]  event : events) {
                int height = event[1];
                int pos    = event[0];

                if (height > 0) {
                    if (height > pq.peek()) {
                        // 添加轮廓
                        addOutLine(rs, prev, pos, pq.peek());
                        prev = pos;
                    }
                    // 建筑物 入栈
                    pq.add(height);
                } else {
                    // 建筑出栈
                    pq.remove(-height);
                    if (-height > pq.peek()) {
                        addOutLine(rs, prev, pos, -height);
                        prev = pos;
                    }
                }

            }

        }

        private void addOutLine(List<List<Integer>> rs, int start, int pos, int height) {
            if (height != 0 && start < pos) {
                if (rs.size() != 0 && rs.get(rs.size() - 1).get(0) == start) {
                    rs.get(rs.size() - 1).set(1, height);
                } else {
                    if (rs.size() != 0)
                        rs.get(rs.size() - 1).set(1, 0);
                    rs.add(Arrays.asList(start, height));
                }
                rs.add(Arrays.asList(pos, height));
            }
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
