package com.ray.LintCode.done;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import com.ray.io.Out;

/**
 * 描述：
 *      在一块大小为 2x3 的板上，有 5 块瓦片，分别用整数 1 到 5 表示，还有一块空地用 0 表示。
 *      一次移动表示 0 与其相邻的四个方向之一的数字交换位置。
 *      当且仅当 这块板 上的瓦片摆放状态为 
 *              [
 *                  [1,2,3],
 *                  [4,5,0]
 *              ]
 *       时，才能说这块板存在的问题被解决了。
 * 
 *
 * 用例：
 *      **用例 1:**
 *      Given board = `[[1,2,3],[4,0,5]]`, return `1`.
 *      解释: 
 *      Swap the 0 and the 5 in one move.
 *      
 *      **用例 2：**
 *      Given board = `[[1,2,3],[5,4,0]]`, return `-1`.
 *      解释: 
 *      No number of moves will make the board solved.
 *      
 *      **用例 3:**
 *      Given board = `[[4,1,2],[5,0,3]]`, return `5`.
 *      解释: 
 *      5 is the smallest number of moves that solves the board.
 *      An example path:
 *      After move 0: [[4,1,2],[5,0,3]]
 *      After move 1: [[4,1,2],[0,5,3]]
 *      After move 2: [[0,1,2],[4,5,3]]
 *      After move 3: [[1,0,2],[4,5,3]]
 *      After move 4: [[1,2,0],[4,5,3]]
 *      After move 5: [[1,2,3],[4,5,0]]
 *      
 *      **用例 4:**
 *      Given board = `[[3,2,4],[1,5,0]]`, return `14`.
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/sliding-puzzle/description
 * @date   2019-07-19 18:28:25
 */
public class L_0941_Sliding_Puzzle {

    /**
     * 使用 BFS 搜索，记录board 到每个baord 的变化
     * 
     * @author rays1
     *
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
        
        int[][] board = {
                {4,1,2},
                {5,0,3}
        };
        
        Out.p(new Solution().slidingPuzzle(board));
        
    }
 
}
