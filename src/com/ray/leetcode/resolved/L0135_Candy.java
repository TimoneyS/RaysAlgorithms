package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Candy
 * -----------------------------------------------------------------------------
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * 	Each child must have at least one candy.
 * 	Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 *
 * Example:
 *      Example 1
 *      Input: [1,0,2]
 *      Output: 5
 *      Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 *      Example 2
 *      Input: [1,2,2]
 *      Output: 4
 *      Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
 *                   The third child gets 1 candy because it satisfies the above two conditions.
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/candy/
 * @since   2020-03-07 13:15:17
 */
public class L0135_Candy {
    /**
     * 遍历解决，首先每个孩子分发一块糖
     *  然后有孩子分配的糖果不符合条件就将其糖果数调整为旁边孩子的糖果数+1
     *
     *  直到所有孩子分配的糖果符合条件。
     */
    static class Solution {

        public int candy(int[] ratings) {
            int[] rs = new int[ratings.length];
            Queue<Integer> queue = new ArrayDeque<>();

            for (int i = 0; i < ratings.length; i++) {
                if (value(ratings, i) <= value(ratings, i-1) && value(ratings, i) <= value(ratings, i+1)) {
                    if (i > 0) queue.add(i - 1);
                    if (i < ratings.length - 1) queue.add(i + 1);
                    rs[i] = 1;
                }
            }

            while (!queue.isEmpty()) {
                int i = queue.poll();
                if (rs[i] != 0) continue;
                if (value(ratings, i) > value(ratings, i-1) && value(ratings, i) > value(ratings, i+1)) {
                    if (value(rs, i-1) == 0 || value(rs, i+1) == 0) {
                        queue.offer(i);
                        continue;
                    } else {
                        rs[i] = Math.max(value(rs, i+1),  value(rs, i-1)) + 1;
                    }
                } else {
                    if (i == ratings.length - 1 || value(rs, i-1) != 0 && value(ratings, i) > value(ratings, i-1)) {
                        rs[i] = value(rs, i-1) + 1;
                    }
                    if (i == 0 || value(rs, i+1) != 0 && value(ratings, i) > value(ratings, i+1)) {
                        rs[i] = value(rs, i+1) + 1;
                    }
                }
                if (value(rs, i-1) == 0) {
                    queue.offer(i-1);
                }
                if (value(rs, i+1) == 0) {
                    queue.offer(i+1);
                }
            }
            return Arrays.stream(rs).sum();
        }

        int value(int[] ratings, int i) {
            return i >= 0 && i < ratings.length ? ratings[i] : Integer.MAX_VALUE;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
