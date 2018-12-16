package com.ray.LintCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.ray.io.In;
import com.ray.io.Out;
import com.ray.util.Timer;

/**
 * Given N buildings in a x-axis，each building is a rectangle and can be represented by a triple (start, end, height)，
 * where start is the start position on x-axis, end is the end position on x-axis and height is the height of the building.
 * 
 * Buildings may overlap if you see them from far away，find the outline of them。
 *
 * An outline can be represented by a triple, (start, end, height),
 * where start is the start position on x-axis of the outline,
 * end is the end position on x-axis and height is the height of the outline.
 *
 * 天际线问题
 * 在 x 轴上存在 N 个建筑物，每个建筑由三个参数 start, end, height 表示，分别对应建筑物的开始位置、结束位置和高度
 * 建筑交叠一起会彼此遮挡，寻找建筑的轮廓。轮廓同样由三个参数 start, end, height 表示
 * 
 * <p>
 * Example : 
 * [                                 [
 *   [1, 3, 3],                         [1, 2, 3],
 *   [2, 4, 4],           ===>          [2, 4, 4],
 *   [5, 6, 1]                          [5, 6, 1]
 * ]                                 ]
 * 
 * @author rays1
 *
 */
public class L_0131_The_Skyline_Problem {

    static class Solution {
        /**
         * @param buildings: A list of lists of integers
         * @return: Find the outline of those buildings
         */
        public List<List<Integer>> buildingOutline(int[][] buildings) {
            
            List<List<Integer>> rs = new ArrayList<>();
            
            int start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
            for (int[] building : buildings) {
                start = Math.min(start, building[0]);
                end = Math.max(end, building[1]);
            }
            int height;
            for (int i = start; i <= end; i++) {
                height = 0;
                for (int j = 0; j < buildings.length; j++) {
                    if (buildings[j][0] > i)
                        break;
                    if (buildings[j][0] <= i && buildings[j][1] > i)
                        height = Math.max(height, buildings[j][2]);
                }
//                Out.pf("add (%s,%s) \n", i, height);
                if (height != 0)
                    addOutLine(rs, i, height);
            }
            
            return rs;
        }

        private void addOutLine(List<List<Integer>> rs, int start, int height) {
            if (rs.size() < 1) {
                List<Integer> l = Arrays.asList(new Integer[] {start, start+1, height});
                rs.add(l);
            } else {
                List<Integer> prev = rs.get(rs.size()-1);
                if (prev.get(1) ==  start && prev.get(2) == height) {
                    prev.set(1, prev.get(1) + 1);
                } else {
                    List<Integer> l = Arrays.asList(new Integer[] {start, start+1, height});
                    rs.add(l);
                }
            }
        }
    }

    public static void main(String[] args) {
        
        Scanner sc1 = In.getClassPathScanner(L_0131_The_Skyline_Problem.class, "L_0131_The_Skyline_Problem.in");
        String[] arr = sc1.next().split("\\],\\[");
        
        
        int[][] buildings = new int[arr.length][3];
        
        for (int i = 0; i < arr.length; i++) {
            String[] temp = arr[i].split(",");
            buildings[i][0] = Integer.valueOf(temp[0]);
            buildings[i][1] = Integer.valueOf(temp[1]);
            buildings[i][2] = Integer.valueOf(temp[2]);
        }
        
        Out.p(buildings.length);
        
//        int[][] buildings = {
//                {1,10,3},
//                {2,5,8},
//                {7,9,8},
//        };
        Timer.CLICK();
        List<List<Integer>> rs = new Solution().buildingOutline(buildings);
        Timer.STOP();
//        for (List<Integer> outline : rs) {
//            Out.p(outline);
//        }
        
    }
    
}
