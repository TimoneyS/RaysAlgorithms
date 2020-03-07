package com.ray.leetcode;

import com.ray.io.Out;

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

            for (int i = 0; i < rs.length; i++) rs[i] = 1;

            int level = 0;
            while (level ++ < 10) {
                boolean flag = true;
                for (int i = 0; i < rs.length; i++) {

                    int rl = Integer.MAX_VALUE, rr = Integer.MAX_VALUE;
                    int cl = 1, cr = 1;
                    if (i > 0)           { rl = ratings[i-1]; cl = rs[i-1];}
                    if (i < rs.length-1) { rr = ratings[i+1]; cr = rs[i+1];}

                    if (ratings[i] > rr && rs[i] <= cr) {
                        rs[i] = cr + 1;
                        flag = false;
                    } else if (ratings[i] > rl && rs[i] <= cl) {
                        rs[i] = cl + 1;
                        flag = false;
                    }

                }
                if (flag) break;
            }

            int count = 0;
            for (int i = 0; i < rs.length; i++) count += rs[i];
            return count;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
