package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.*;

/**
 * Cut Off Trees for Golf Event
 * -----------------------------------------------------------------------------
 * You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D map, in this map:
 * 	0 represents the obstacle can't be reached.
 * 	1 represents the ground can be walked through.
 * 	The place with number bigger than 1 represents a tree can be walked through, and this positive number represents the tree's height.
 * In one step you can walk in any of the four directions top, bottom, left and right also when standing in a point which is a tree you can decide whether or not to cut off the tree.
 * You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with lowest height first. And after cutting, the original place has the tree will become a grass (value 1).
 * You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees. If you can't cut off all the trees, output -1 in that situation.
 * You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.
 *
 * Example:
 *      Example 1
 *      Input: 
 *      [
 *       [1,2,3],
 *       [0,0,4],
 *       [7,6,5]
 *      ]
 *      Output: 6
 *      Example 2
 *      Input: 
 *      [
 *       [1,2,3],
 *       [0,0,0],
 *       [7,6,5]
 *      ]
 *      Output: -1
 *      Example 3
 *      Input: 
 *      [
 *       [2,3,4],
 *       [0,0,5],
 *       [8,7,6]
 *      ]
 *      Output: 6
 *      Explanation: You started from the point (0,0) and you can cut off the tree in (0,0) directly without walking.
 *      Constraints:
 *      	1 <= forest.length <= 50
 *      	1 <= forest[i].length <= 50
 *      	0 <= forest[i][j] <= 10^9
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/cut-off-trees-for-golf-event/
 * @since   2020-04-07 22:08:27
 */
public class L0675_Cut_Off_Trees_for_Golf_Event {
    static class Solution {
        static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        public int cutOffTree(List<List<Integer>> forest) {
            if (get(forest, 0, 0) < 1) return -1;

            PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a / 10000));

            // 将所有的树加入队列
            for (int i = 0; i < forest.size(); i ++) {
                for (int j = 0; j < forest.get(i).size(); j ++) {
                    long height;
                    if ((height = get(forest, i, j)) > 1) {
                        pq.offer(height * 10000 + i * 100 + j);
                    }
                }
            }

            long prev = 0L;
            int rs = 0;
            while (!pq.isEmpty()) {
                // 每次选择最小的树砍去
                long curr = pq.poll();
                int x = (int) ((curr / 100) % 100);
                int y = (int) (curr % 100);

                // 计算上一次砍树的位置和当前位置的最短距离
                int dist = dist(forest, x, y, (int) ((prev / 100) % 100), (int) (prev % 100));
                if (dist < 0) {
                    rs = -1;
                    break;
                }
                rs += dist;
                prev = curr;
            }
            return rs;
        }

        private int dist(List<List<Integer>> forest, int x, int y, int i, int j) {
            if (x == i && y == j) return 0;
            boolean[][] marked = new boolean[forest.size()][forest.get(0).size()];
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(x * 100 + y);
            marked[x][y] = true;
            int dist = 1;
            int size = q.size();

            boolean find = false;
            LOOP1:
            while (!q.isEmpty()) {
                int curr = q.poll();
                x = curr / 100;
                y = curr % 100;
                for (int[] dir : DIRS) {
                    int x1 = x + dir[0];
                    int y1 = y + dir[1];
                    if (get(forest, x1, y1) > 0 && !marked[x1][y1]) {
                        if (x1 == i && y1 == j) {
                            find = true;
                            break LOOP1;
                        }
                        marked[x1][y1] = true;
                        q.offer(x1 * 100 + y1);
                    }
                }
                size --;
                if (size == 0) {
                    dist ++;
                    size = q.size();
                }
            }

            return find ? dist : -1;
        }

        private int get(List<List<Integer>> forest, int i, int j) {
            return i >= 0 && j >= 0 && i < forest.size() && j < forest.get(0).size() ? forest.get(i).get(j) : -1;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
