package com.ray.LintCode.temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

import com.ray.io.In;
import com.ray.io.Out;
import com.ray.util.Timer;

/**
 * 描述：
 *      Given *N* buildings in a x-axis，each building is a rectangle and can be represented by a triple (start, end, height)，where start is the start position on x-axis, end is the end position on x-axis and height is the height of the building. Buildings may overlap if you see them from far away，find the outline of them。
 *      
 *      An outline can be represented by a triple, (start, end, height), where start is the start position on x-axis of the outline, end is the end position on x-axis and height is the height of the outline.
 *      
 *      ![Building Outline](https://lintcode-media.s3.amazonaws.com/problem/jiuzhang3.jpg "Building Outline")
 *
 * 用例：
 *      **Example 1**
 *      
 *      ```plain
 *      Input:
 *      [
 *          [1, 3, 3],
 *          [2, 4, 4],
 *          [5, 6, 1]
 *      ]
 *      Output:
 *      [
 *          [1, 2, 3],
 *          [2, 4, 4],
 *          [5, 6, 1]
 *      ]
 *      Explanation:
 *      The buildings are look like this in the picture. The yellow part is buildings.
 *      ```
 *      
 *      ![图片](https://media-cdn.jiuzhang.com/markdown/images/6/20/18bd686e-934d-11e9-a170-0242ac110002.jpg)
 *      
 *      **Example 2**
 *      
 *      ```plain
 *      Input:
 *      [
 *          [1, 4, 3],
 *          [6, 9, 5]
 *      ]
 *      Output:
 *      [
 *          [1, 4, 3],
 *          [6, 9, 5]
 *      ]
 *      Explanation:
 *      The buildings are look like this in the picture. The yellow part is buildings.
 *      ```
 *      
 *      ![图片](https://media-cdn.jiuzhang.com/markdown/images/6/20/58c5f08e-934d-11e9-a170-0242ac110002.jpg)
 *
 * 挑战：
 *      
 *
 * 难度： Super
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/the-skyline-problem/description
 * @date   2019-07-11 18:30:57
 */
public class L_0131_The_Skyline_Problem {

    static class Solution {
        public List<List<Integer>> buildingOutline(int[][] buildings) {
            
            List<List<Integer>> rs = new ArrayList<>();
            List<int[]> events = new ArrayList<>();
            
            for (int[] is : buildings) {
                events.add(new int[] {is[0],  is[2]});
                events.add(new int[] {is[1], -is[2]});
            }
            events.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
                }
            });
            buildResult(rs, events);
            return rs;
        }
        
        private void buildResult(List<List<Integer>> rs, List<int[]> events) {
            
            Queue<Integer> pq = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
            
            pq.add(0);
            
            int prev = 0;
            for (int[]  event : events) {
                int height = event[1];
                int pos    = event[0];
                
                if (height > 0) {
                    if (height > pq.peek()) {
                        // 添加轮廓
                        addOutLine(rs, prev, pos, pq.peek());
                        prev = pos;
                    }
                    // 建筑物 入栈
                    pq.add(height);
                } else {
                    // 建筑出栈
                    pq.remove(-height);
                    if (-height > pq.peek()) {
                        addOutLine(rs, prev, pos, -height);
                        prev = pos;
                    }
                }
                
            }
            
        }

        private void addOutLine(List<List<Integer>> rs, int start, int pos, int height) {
            
            if (rs.size() == 0 && height != 0 && start < pos) {
                rs.add(Arrays.asList(new Integer[] {start, pos, height}));
                return;
            }
            if(height != 0 && start < pos) {
                rs.add(Arrays.asList(new Integer[] {start, pos, height}));
                
//                List<Integer> prev = rs.get(rs.size()-1);
//                if (prev.get(2) == height && prev.get(1) == start) {
//                    prev.set(1, pos);
//                } else {
//                    rs.add(Arrays.asList(new Integer[] {start, pos, height}));
//                }
            }
        }

    }
    
    static class Solution1 {
        private static final int UP = 0;
        private static final int DOWN = 1;
        private class Pair implements Comparable<Pair> {
            int index, height, status;
            public Pair(int index, int height, int status) {
                this.index = index;
                this.height = height;
                this.status = status;
            }
            public int compareTo(Pair p) {
                if (this.index == p.index) {
                    if (this.status == p.status) {
                        return this.height - p.height;
                    } else {
                        return this.status - p.status;
                    }
                }
                return this.index - p.index;
            }
        }

        public List<List<Integer>> buildingOutline(int[][] buildings) {
            // write your code here
            Pair[] pairs = new Pair[buildings.length * 2];
            for (int i = 0; i < buildings.length; ++i) {
                int[] building = buildings[i];
                pairs[i * 2] = new Pair(building[0], building[2], UP);
                pairs[i * 2 + 1] = new Pair(building[1], building[2], DOWN);
            }
            Arrays.sort(pairs);
            TreeMap<Integer, Integer> heightMap = new TreeMap<>();
            int preHeight = 0;
            int preIndex = 0;
            List<List<Integer>> result = new ArrayList<>();
            for (Pair pair : pairs) {
                if (pair.status == UP) {
                    if (!heightMap.containsKey(pair.height)) {
                        heightMap.put(pair.height, 0);
                    }
                    heightMap.put(pair.height, heightMap.get(pair.height) + 1);
                } else {
                    heightMap.put(pair.height, heightMap.get(pair.height) - 1);
                    if (heightMap.get(pair.height) == 0) {
                        heightMap.remove(pair.height);
                    }
                }

                int currentHeight = heightMap.size() == 0 ? 0 : heightMap.lastKey();
                if (preHeight != currentHeight) {
                    if ((pair.index - preIndex) * preHeight != 0) {
                        result.add(getList(preIndex, pair.index, preHeight));
                    }
                    preIndex = pair.index;
                    preHeight = currentHeight;
                }
            }

            return result;
        }

        private List<Integer> getList(int start, int end, int height) {
            List<Integer> list = new ArrayList<>();
            list.add(start);
            list.add(end);
            list.add(height);
            return list;
        }
    }
    
    private static int[][] genFromFile() {
        Scanner sc1 = In.getClassPathScanner(L_0131_The_Skyline_Problem.class, "L_0131_The_Skyline_Problem_3.in");
        String[] arr = sc1.next().split("\\],\\[");
        
        int[][] buildings = new int[arr.length][3];
        
        for (int i = 0; i < arr.length; i++) {
            String[] temp = arr[i].split(",");
            buildings[i][0] = Integer.valueOf(temp[0]);
            buildings[i][1] = Integer.valueOf(temp[1]);
            buildings[i][2] = Integer.valueOf(temp[2]);
        }

        return buildings;
    }
    
    public static void main(String[] args) {
        
        int[][] buildings = genFromFile();
//        Out.p(buildings.length);
        
//        int[][] buildings = {
//                {2,3,2},
//                {1,2,3},
//                {8,9,2},
//                {3,4,2}
//            };
        
        Timer.CLICK();
        List<List<Integer>> rs1 = new Solution().buildingOutline(buildings);
        Out.p(rs1.size());
        Timer.STOP();
        
//        Out.p(rs1);
        
    }

}
