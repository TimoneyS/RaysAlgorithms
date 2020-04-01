package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * 圆圈中最后剩下的数字 LCOF
 * -----------------------------------------------------------------------------
 * English description is not available for the problem. Please switch to Chinese.
 *
 * Example:
 *      
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * @since   2020-03-31 22:18:44
 */
public class L100343_圆圈中最后剩下的数字_LCOF {
    /**
     * 先讨论特殊情况，8 个数字中，每次淘汰第 3 个
     *      0 1 2 3 4 5 6 7
     * =======================================================
     * 淘汰第 3 个数字 2，下一轮游戏从 3 开始
     *      3 4 5 6 7 0 1 [2]
     * 这个时候，为了方便下一轮的计算，可以对数字做一个映射
     *      3 4 5 6 7 0 1 [2]
     *      ↓ ↓ ↓ ↓ ↓ ↓ ↓  ↓
     *      0 1 2 3 4 5 6  7
     * 对于每个映射的数字和原数字之间都有关系
     *      num -> (num + m) % n -> xx
     *      4   -> (4   + 3) % 8 -> 7
     * =======================================================
     * 然后淘汰第二个数字，下一轮又从 3 开始
     *      3 4 5 6 0 1 [2]
     * 继续映射
     *      3 4 5 6 0 1 [2]
     *      ↓ ↓ ↓ ↓ ↓ ↓  ↓
     *      0 1 2 3 4 5  6
     * 对于每个映射的数字和原数字之间都有关系
     *      num -> (num + m) % (n-1) -> xx
     *      5   -> (5   + 3) % 7     -> 1
     * =======================================================
     * 循环进行，则最后只剩下一个数字的时候，删除的一定是映射后的 0
     *      f(1) = 0
     * 之前的映射，其实就是 f(n) 和 f(n-1) 的关系
     * 然后根据这个 0，一次循环 0 在上一层应该是哪个数字
     *      f(2) = (f(1) + m) % 2
     *      f(3) = (f(2) + m) % 3
     *      ...
     *      f(n) = (f(n-1) + m) % n
     */
    static class Solution {
        public int lastRemaining(int n, int m) {
            int p = 0;
            for (int i = 2; i <= n; i ++) {
                p = (p + m) % i;
            }
            return p;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
