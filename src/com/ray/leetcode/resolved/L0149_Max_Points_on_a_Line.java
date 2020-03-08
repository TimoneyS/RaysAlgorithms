package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.*;

/**
 * Max Points on a Line
 * -----------------------------------------------------------------------------
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 *
 * Example:
 *      Example 1
 *      Input: [[1,1],[2,2],[3,3]]
 *      Output: 3
 *      Explanation:
 *      ^
 *      |
 *      |        o
 *      |     o
 *      |  o  
 *      +------------->
 *      0  1  2  3  4
 *      Example 2
 *      Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 *      Output: 4
 *      Explanation:
 *      ^
 *      |
 *      |  o
 *      |     o        o
 *      |        o
 *      |  o        o
 *      +------------------->
 *      0  1  2  3  4  5  6
 *      NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/max-points-on-a-line/
 * @since   2020-03-07 21:11:49
 */
public class L0149_Max_Points_on_a_Line {
    static class Solution {
        public int maxPoints(int[][] points) {
            if (points == null) return 0;
            int n = points.length;
            if (n < 3) return n;

            Arrays.sort(points, (o1, o2) -> {
                if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
                return Integer.compare(o1[0], o2[0]);
            });

            HashSet<Integer> firstLine = new HashSet<>();
            firstLine.add(0);
            firstLine.add(1);

            ArrayList<HashSet<Integer>> lines = new ArrayList<>();
            lines.add(firstLine);

            for (int i = 2; i < n; i++) {
                HashSet<Integer> contains = new HashSet<>();
                for (HashSet<Integer> line : lines) {
                    if (isInLine(line, points[i], points)) {
                        contains.addAll(line);
                        line.add(i);
                    }
                }
                for (int j = 0; j < i; j++) {
                    if (contains.contains(j)) continue;
                    HashSet<Integer> line = new HashSet<>();
                    line.add(i);
                    line.add(j);
                    lines.add(line);
                }
            }
            int max = 0;
            for (HashSet<Integer> line : lines) max = Math.max(max, line.size());
            return max;
        }

        public static boolean isInLine(HashSet<Integer> line, int[] p, int[][] points) {
            Iterator<Integer> ite = line.iterator();
            int[] a = points[ite.next()];
            int[] b = points[ite.next()];
            while (b[0] == a[0] && b[1] == a[1] && ite.hasNext())
                b = points[ite.next()];
            return isSameLine(a,b,p);
        }

        public static boolean isSameLine(int[] a, int[] b, int[] c) {
            return (c[1] - a[1]) * (b[0] - a[0]) == (c[0] - a[0]) * (b[1] - a[1]);
        }
    }

    static class Solution1 {
        public int maxPoints(int[][] points) {
            if (points == null) {
                return 0;
            }
            int rs = 0;
            for (int i = 0; i < points.length; i++) {
                Map<String, Integer> map = new HashMap<>();
                int maxPoints = 0, overlap = 0, vertical = 0;
                for (int j = i + 1; j < points.length; j++) {
                    if (points[i][0] == points[j][0]) {
                        if (points[i][1] == points[j][1]) {
                            overlap++;
                        } else {
                            vertical++;
                        }
                    } else {
                        String k = slope(points[i], points[j]);
                        if (!map.containsKey(k)) map.put(k, 0);
                        map.put(k, map.get(k) + 1);
                        maxPoints = Math.max(maxPoints, map.get(k));
                    }
                }
                maxPoints = Math.max(maxPoints, vertical) + overlap + 1;
                rs = Math.max(rs, maxPoints);
            }
            return rs;
        }

        String slope(int[] a, int[] b) {
            int dx = a[0] - b[0];
            int dy = a[1] - b[1];
            int tmp = gcd(dx, dy);
            dx /= tmp;
            dy /= tmp;
            return dy + "/" + dx;
        }

        int gcd(int a, int b) {
            if (b == 0) {
                return a;
            } else {
                return gcd(b, a % b);
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] points = {
                {0,0},
                {1,65536},
                {65536,0}
        };
        Out.p(new Solution1().maxPoints(points));
    }
}
