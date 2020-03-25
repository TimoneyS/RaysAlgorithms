package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Perfect Rectangle
 * -----------------------------------------------------------------------------
 * Given N axis-aligned rectangles where N > 0, determine if they all together form an exact cover of a rectangular region.
 * Each rectangle is represented as a bottom-left point and a top-right point. For example, a unit square is represented as [1,1,2,2]. (coordinate of bottom-left point is (1, 1) and top-right point is (2, 2)).
 *
 * Example:
 *      Example 1
 *      rectangles = [
 *        [1,1,3,3],
 *        [3,1,4,2],
 *        [3,2,4,4],
 *        [1,3,2,4],
 *        [2,3,3,4]
 *      ]
 *      Return true. All 5 rectangles together form an exact cover of a rectangular region.
 *      Example 2
 *      rectangles = [
 *        [1,1,2,3],
 *        [1,3,2,4],
 *        [3,1,4,2],
 *        [3,2,4,4]
 *      ]
 *      Return false. Because there is a gap between the two rectangular regions.
 *      Example 3
 *      rectangles = [
 *        [1,1,3,3],
 *        [3,1,4,2],
 *        [1,3,2,4],
 *        [3,2,4,4]
 *      ]
 *      Return false. Because there is a gap in the top center.
 *      Example 4
 *      rectangles = [
 *        [1,1,3,3],
 *        [3,1,4,2],
 *        [1,3,2,4],
 *        [2,2,4,4]
 *      ]
 *      Return false. Because two of the rectangles overlap with each other.
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/perfect-rectangle/
 * @since   2020-03-23 22:09:54
 */
public class L0391_Perfect_Rectangle {
    /**
     * 线扫描算法
     *
     * 用一根虚拟的线，从左到右扫描所有的矩形。
     * 线在扫描到某个位置时，每个矩阵都会在直线上投影为一个线段。
     * 如果在所有的位置，这些矩阵投影的线段不重叠，且恰好填满为一个线段，那么这些线段构成的矩形就是完美矩形。
     * 算法的难点在于高效的判断，任意位置所有的矩阵投影能否构成指定线段。
     *
     *
     * 这里算法使用的是，每个矩形会投影一个上界和下界，那么将所有的上界下界都加入集合的话，除了边界，其他的界限一定都出现两次。
     * 这样，才能保证这些界限能够恰好填充一个线段。
     * 然后集合在运算时，将所有计数为2的界限删除，最后必然只剩下两个边界，也就是线段的上下界。
     */
    static class Solution {
        public boolean isRectangleCover(int[][] rectangles) {
            int[][] events = new int[rectangles.length*2][2];
            int[] bound = {Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
            buildEvent(rectangles, events, bound);
            bound[2] = events[events.length - 1][0];
            int w = 0;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < events.length; i++) {
                int idx = events[i][1];
                if (idx > 0) {
                    w += (rectangles[idx-1][3] - rectangles[idx-1][1]);
                    // 如果能够添加成功，说明这个界限出现了两次，删去
                    if (!set.add(rectangles[idx-1][1])) set.remove(rectangles[idx-1][1]);
                    if (!set.add(rectangles[idx-1][3])) set.remove(rectangles[idx-1][3]);
                } else {
                    w -= (rectangles[-idx-1][3] - rectangles[-idx-1][1]);
                    // 如果删除失败，说明这个界限有2个（不然在遇到删除前已经报错了），因此将界限再次加入集合
                    if (!set.remove(rectangles[-idx-1][1])) set.add(rectangles[-idx-1][1]);
                    if (!set.remove(rectangles[-idx-1][3])) set.add(rectangles[-idx-1][3]);
                }
                if (events[i][0] == bound[2]) break;
                if (i + 1 == events.length || events[i+1][0] != events[i][0]) {
                    if (w != bound[1] - bound[0] || set.size() != 2 || !set.contains(bound[0]) || !set.contains(bound[1]))
                        return false;
                }
            }
            return true;
        }

        private void buildEvent(int[][] rectangles, int[][] events, int[] bound) {
            // 定义开始事件和结束事件
            for (int i = 0; i < rectangles.length; i ++) {
                events[2*i][0] = rectangles[i][0];   // 矩阵开始位置 x 轴索引
                events[2*i][1] = i+1;                // 矩阵开始位置 x 轴索引
                events[2*i+1][0] = rectangles[i][2]; // 矩阵结束位置 x 轴索引
                events[2*i+1][1] = -i-1;             // 矩阵结束位置 x 轴索引
                bound[0] = Math.min(bound[0], rectangles[i][1]); // 下界
                bound[1] = Math.max(bound[1], rectangles[i][3]); // 上界
            }

            Arrays.sort(events, (a, b) -> {
                if (a[0] != b[0]) {
                    // 在 x 轴不同位置按照先后排列
                    return a[0] - b[0];
                } else if (a[1] > 0 && b[1] > 0 ) {
                    // 在 x 轴相同位置，且同为开始，按照 y 轴下限从小到大
                    return rectangles[a[1]-1][1] - rectangles[b[1]-1][1];
                } else if (a[1] < 0 && b[1] < 0) {
                    // 在 x 轴相同位置，且同为结束，按照 y 轴下限从小到大
                    return rectangles[-1 - a[1]][1] - rectangles[-1 - b[1]][1];
                } else {
                    // 在 x 轴相同位置，结束事件靠前
                    return a[1] - b[1];
                }
            });
        }
    }
    
    public static void main(String[] args) {
        int[][] r = {{0,0,1,1}, {0,1,2,2}, {1,1,2,2}};
        Out.p(new Solution().isRectangleCover(r));
    }
}
