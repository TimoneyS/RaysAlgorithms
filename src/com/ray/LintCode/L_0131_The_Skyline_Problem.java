package com.ray.LintCode;

import static com.ray.util.ArrayUtil.less;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.ray.io.In;
import com.ray.io.Out;
import com.ray.util.Timer;
import com.rays.algo.sort.Sort;

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
        
        public List<List<Integer>> buildingOutline(int[][] buildings) {
            
            int start = Integer.MAX_VALUE;
            int end = Integer.MIN_VALUE;
            
            for (int[] b : buildings) {
                start = Math.min(start, b[0]);
                end   = Math.max(end,   b[1]);
            }
            int[] heights = new int[end-start+1];
             
            sort(buildings, 0, buildings.length-1);
            
            Timer.CLICK();
            List<List<Integer>> rs = new ArrayList<>();
            for (int[] b : buildings) {
                for (int i = b[0]; i < b[1]; i++) {
                    heights[i-start] = b[2];
                }
            }
            Timer.STOP();
            int t = 0;
            for (int i = 0; i < heights.length; i++) {
//                if (i == heights.length-1 || heights[i] != heights[i+1]) {
//                    if (heights[i] != 0)
//                        addOutLine(rs, start+t, start+i+1, heights[i]);
//                    t = i+1;
//                }
            }
            
            
            return rs;
        }
   
        public void sort(int[][] arr, int lo, int hi) {
            int[][] temp = new int[hi-lo+1][3];
            int N = hi - lo + 1;
            for (int size = 1; size < N; size *= 2) {                            // 幂次递增的归并尺寸
                for (int l = lo; l < N-size; l += size*2 ) {                     // 循环处理每一对待归并的子数组
                    merge(arr, l, (l+size-1), Math.min( l+size*2-1, hi), temp);  // 归并起点为l长度为size的两个相邻的子数组
                }
            }
        }
        
        private static void merge(int[][] arr, int lo, int mid, int hi, int[][] temp){
            for(int i = lo; i <= hi; i++) temp[i] = arr[i];    // 缓存
            int i = lo,     // 大数组索引
                l = lo,     // 左侧子数组索引
                r = mid+1;  // 右侧子数组索引
            while(l <= mid || r <= hi) {
                if(l > mid)                 arr[i++] = temp[r++];    // 左侧子数组已经全部添加
                else if(r > hi)             arr[i++] = temp[l++];    // 右侧子数组已经全部添加
                else if(temp[l][2] < temp[r][2])   arr[i++] = temp[l++];    // 左侧的子数组当前元素更小
                else                        arr[i++] = temp[r++];    // 右侧的子数组当前元素更小
            }
        }

        private void addOutLine(List<List<Integer>> rs, int start, int end, int height) {
            List<Integer> l = new ArrayList<>();
            l.add(start);
            l.add(end);
            l.add(height);
            rs.add(l);
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
//                {1,8,3},
//                {2,4,6},
//                {3,5,8},
//                {4,7,5},
//                {9,14,4},
//                {12,15,6},
//        };
        Solution sol = new Solution();
        
//        sol.sort(buildings, 0, buildings.length-1);
        List<List<Integer>> rs = new Solution().buildingOutline(buildings);
        
        Out.p(rs.size());
//        for (List<Integer> outline : rs) {
//            Out.p(outline);
//        }
//        
    }
    
}
