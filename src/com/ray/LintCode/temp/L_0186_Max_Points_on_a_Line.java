package com.ray.LintCode.temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import com.ray.LintCode.util.Point;
import com.ray.io.Out;

/**
 * 描述：
 *      Given *n* points on a 2D plane, find the maximum number of points that lie on the same straight line.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:(1,2),(3,6),(0,0),(1,3).
 *      Output:3
 *      ```
 *      **Example 2:**
 *      ```
 *      Input:(1,2),(2,3),(3,2).
 *      Output:2
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/max-points-on-a-line/description
 * @date   2019-07-11 18:31:44
 */
public class L_0186_Max_Points_on_a_Line {

    static class Solution {
        public int maxPoints(Point[] points) {
            if (points == null) return 0;
            int n = points.length;
            if (n < 3) return n; 
            
            Arrays.sort(points, new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    if (o1.x == o2.x) return Integer.compare(o1.y, o2.y);
                    return Integer.compare(o1.x, o2.x);
                }
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
            
            Out.p(lines);
            
            int max = 0;
            for (HashSet<Integer> line : lines) max = Math.max(max, line.size());
            return max;
        }
        
        public static boolean isInLine(HashSet<Integer> line, Point p, Point[] points) {
            Iterator<Integer> ite = line.iterator();
            Point a = points[ite.next()];
            
            Point b = points[ite.next()];
            while (b.x == a.x && b.y == a.y && ite.hasNext())
                b = points[ite.next()];
            
            return isSameLine(a,b,p);
        }
        
        public static boolean isSameLine(Point a, Point b, Point c) {
            return (c.y - a.y) * (b.x - a.x) == (c.x - a.x) * (b.y - a.y);
        }
        
    }
    
    static class Solution1 {
        /**
         * @param points an array of point
         * @return an integer
         */
        public int maxPoints(Point[] points) {
            // Write your code here
            if (points == null) {
                return 0;
            }
            int rs = 0;
            for (int i = 0; i < points.length; i++) {
                Map<String, Integer> map = new HashMap<>();
                int maxPoints = 0, overlap = 0, vertical = 0;

                for (int j = i + 1; j < points.length; j++) {
                    if (points[i].x == points[j].x) {
                        if (points[i].y == points[j].y) {
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
        
        String slope(Point a, Point b) {
            int dx = a.x - b.x;
            int dy = a.y - b.y;
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
        
        int[][] arr = {
                {1,1},
                {1,1},
                {1,1},
                {2,1},
                {2,2},
                {3,3}
              
        };
        
        Point[] points = new Point[arr.length];
        
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(arr[i][0], arr[i][1]);
        }
        
//        Point[] points = {
//            new Point(2, 6),
//            new Point(0, 0),
//            new Point(1, 3)
//        };
        Out.p(new Solution1().maxPoints(points));
        
    }

}
