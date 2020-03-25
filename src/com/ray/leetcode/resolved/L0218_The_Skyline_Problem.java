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
    /**
     * 线性的扫描所有建筑物，维护最高值
     * 如果最高值出现下降或上升，则表示出现了关键点。
     */
    static class Solution {
        public List<List<Integer>> getSkyline(int[][] buildings) {
            List<List<Integer>> rs = new ArrayList<>();

            int[][] events = new int[buildings.length * 2][2];
            for (int i = 0; i < buildings.length; i++) {
                events[i*2][0] = buildings[i][0];
                events[i*2+1][0] = buildings[i][1];
                events[i*2][1] = buildings[i][2];
                events[i*2+1][1] = -buildings[i][2];
            }
            Arrays.sort(events, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

            TreeMap<Integer, Integer> map = new TreeMap<>();
            map.put(0, 0);
            int height = 0;
            for (int[]  event : events) {
                if (event[1] < 0) {
                    if (map.get(-event[1]) == 1) {
                        map.remove(-event[1]);
                    } else {
                        map.put(-event[1], map.get(-event[1]) - 1);
                    }
                } else {
                    map.put(event[1], map.getOrDefault(event[1], 0) + 1);
                }
                if (map.lastKey() != height) {
                    height = map.lastKey();
                    rs.add(Arrays.asList(event[0], height));
                }
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
