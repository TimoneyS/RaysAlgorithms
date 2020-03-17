package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * Water and Jug Problem
 * -----------------------------------------------------------------------------
 * You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available. You need to determine whether it is possible to measure exactly z litres using these two jugs.
 * If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.
 * Operations allowed:
 * 	Fill any of the jugs completely with water.
 * 	Empty any of the jugs.
 * 	Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.
 *
 * Example:
 *      Example 1
 *       (From the famous Die Hard example)
 *      Input: x = 3, y = 5, z = 4
 *      Output: True
 *      Example 2
 *      Input: x = 2, y = 6, z = 5
 *      Output: False
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/water-and-jug-problem/
 * @since   2020-03-17 22:46:59
 */
public class L0365_Water_and_Jug_Problem {
    /**
     * 两个水壶，和一个水量，可能得到多个水量，将这些水量加入队列
     */
    static class Solution {
        public boolean canMeasureWater(int x, int y, int z) {
            if (x > y) return canMeasureWater(y, x, z);
            Set<Integer> used = new HashSet<>();
            Queue<Integer> q = new ArrayDeque<>();
            q.add(x);
            while (!q.isEmpty()) {
                int k = q.poll();
                if (k == z || k + y == z) return true;
                if (used.contains(k)) continue;
                used.add(k);
                if (y != 0) q.offer((k - x + y) % y);
                if (y != 0) q.offer((x + k) % y);
            }
            return false;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
