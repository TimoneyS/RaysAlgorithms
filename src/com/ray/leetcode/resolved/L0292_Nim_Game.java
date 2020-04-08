package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Nim Game
 * -----------------------------------------------------------------------------
 * You are playing the following Nim Game with your friend:
 *      There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones.
 *      The one who removes the last stone will be the winner.
 *      You will take the first turn to remove the stones.
 * Both of you are very clever and have optimal strategies for the game.
 * Write a function to determine whether you can win the game given the number of stones in the heap.
 *
 * Example:
 *      Example 1
 *      Input: 4
 *      Output: false 
 *      Explanation: If there are 4 stones in the heap, then you will never win the game;
 *                   No matter 1, 2, or 3 stones you remove, the last stone will always be 
 *                   removed by your friend.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/nim-game/
 * @since   2020-03-11 00:14:08
 */
public class L0292_Nim_Game {
    /**
     * f[i] 表示玩家从 i 开始拿，是否一定能够胜利
     *
     * 那么如果从 i 开始， A 拿 k 个，那么 B 就从 i+k开始拿，如果 f[i+k] = true 那么 A 拿 k 个一定输
     *      因此 f[i] = !f[i+k]
     *      因为 A有 1-3种拿法，所以
     *          f[i] = !(f[i+1] && f[i+2] && f[i+3])
     *      可以发现，如果连续三个数量会赢的话，下一个数量的游戏 A 一定会输。
     *      所以如果 n % 4 == 0，则 A 一定输
     */
    static class Solution {
        public boolean canWinNim(int n) {
//        if (n <= 3) return true;
//        boolean[] f = {true, true, true};
//        for (int i = 1; i < n - 3; i ++) {
//            f[i%3] = !f[0] || !f[1] || !f[2];
//        }
//        return !f[0] || !f[1] || !f[2];
            return n % 4 != 0;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
