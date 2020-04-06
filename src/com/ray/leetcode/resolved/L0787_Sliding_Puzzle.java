package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * Sliding Puzzle
 * -----------------------------------------------------------------------------
 * On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and an empty square represented by 0.
 * A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.
 * The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].
 * Given a puzzle board, return the least number of moves required so that the state of the board is solved. If it is impossible for the state of the board to be solved, return -1.
 * Examples:
 * Input: board = [[1,2,3],[4,0,5]]
 * Output: 1
 * Explanation: Swap the 0 and the 5 in one move.
 * Input: board = [[1,2,3],[5,4,0]]
 * Output: -1
 * Explanation: No number of moves will make the board solved.
 * Input: board = [[4,1,2],[5,0,3]]
 * Output: 5
 * Explanation: 5 is the smallest number of moves that solves the board.
 * An example path:
 * After move 0: [[4,1,2],[5,0,3]]
 * After move 1: [[4,1,2],[0,5,3]]
 * After move 2: [[0,1,2],[4,5,3]]
 * After move 3: [[1,0,2],[4,5,3]]
 * After move 4: [[1,2,0],[4,5,3]]
 * After move 5: [[1,2,3],[4,5,0]]
 * Input: board = [[3,2,4],[1,5,0]]
 * Output: 14
 * Note:
 * 	board will be a 2 x 3 array as described above.
 * 	board[i][j] will be a permutation of [0, 1, 2, 3, 4, 5].
 *
 * Example:
 *      
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/sliding-puzzle/
 * @since   2020-04-06 23:17:36
 */
public class L0787_Sliding_Puzzle {
    /**
     * 使用 BFS 搜索，记录board 到每个baord 的变化
     */
    static class Solution {

        static int[][] DIR = {
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };

        public int slidingPuzzle(int[][] board) {

            Queue<Integer> queue = new ArrayDeque<>();
            Map<Integer, Integer> hash = new HashMap<>();

            int start = toI(board);
            queue.add(start);
            hash.put(start, 0);

            while (!queue.isEmpty()) {
                int base = queue.poll();
                if (base == 123450) {
                    break;
                }

                for (Integer num : adj(base)) {
                    if (num != null && !hash.containsKey(num)) {
                        hash.put(num, hash.get(base)+1);
                        queue.add(num);
                    }
                }
            }

            return hash.containsKey(123450) ? hash.get(123450) : -1;
        }

        private Integer[] adj(Integer base) {

            Integer[] rs = new Integer[4];
            int cursor = 0;

            int temp = base;
            int x = 0, y = 0;
            for (int i = 5; i >= 0; i--) {
                if (temp % 10 == 0) {
                    x = i / 3;
                    y = i % 3;
                    break;
                }
                temp /= 10;
            }

            if (x > 0 ) {
                rs[cursor ++] = swap(base, 3 * x + y, 3 * (x-1) + y);
            }

            if (x < 1 ) {
                rs[cursor ++] = swap(base, 3 * x + y, 3 * (x+1) + y);
            }

            if (y > 0 ) {
                rs[cursor ++] = swap(base, 3 * x + y, 3 * x + y - 1);
            }

            if (y < 2 ) {
                rs[cursor ++] = swap(base, 3 * x + y, 3 * x + y + 1);
            }

            return rs;
        }

        // 交换数字的 i 位 和 j 位
        private Integer swap(Integer num, int i, int j) {

            num += 1000000;

            if (i == j) {
                return num;
            }

            i = (int) Math.pow(10, 5-i);
            j = (int) Math.pow(10, 5-j);

            int ni = (num / i) % 10;
            int nj = (num / j) % 10;

            num = num / i / 10 * 10 * i + nj * i + (num % i);
            num = num / j / 10 * 10 * j + ni * j + (num % j);

            return num - 1000000;
        }

        private Integer toI(int[][] board) {
            Integer rs = 0;
            for (int[] row : board) {
                for (int num : row) {
                    rs = rs * 10 + num;
                }
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
