package com.ray.LintCode.done;

import java.util.Arrays;

import com.ray.io.Out;

/**
 * 描述：
 *      Given `n` points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: [[1,1],[-1,1]]
 *      Output: true
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: [[1,1],[-1,-1]]
 *      Output: false
 *      ```
 *
 * 挑战：
 *      Could you do better than O(n2)?
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/line-reflection/description
 * @date   2019-07-11 18:38:32
 */
public class L_0908_Line_Reflection {


    /**
     * 如果所有点对称，则所有纵坐标相同的点，的横坐标之和的平均数一定是相同的。
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        public boolean isReflected(int[][] points) {
            
            // 先对所有点按照 y轴，x轴排序，排序后纵坐标相同的点一定相邻，重复的点也相邻。
            Arrays.sort(points, (o1, o2) -> o1[1] == o2[1] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]));
            
            Integer base = null;
            int size = 0, sum = 0;
            for (int i = 0; i < points.length; i++ ) {
                
                // 如果是最后一个点，或者和右侧点不重复，则总和加上此点，数量加1。
                if (i >= points.length - 1 || points[i+1][1] != points[i][1] || points[i+1][0] != points[i][0]) {
                    sum += points[i][0];
                    size ++;
                }
                
                // 如果是最后一个点，或者右侧点的纵坐标和该点不一致，则统计本次平均和
                if (i >= points.length-1 || points[i+1][1] != points[i][1]) {
                    if (size > 1 && size % 2 != 0) return false;
                    if (base == null) {
                        base = sum * 2 / size;
                    }
                    if (base != sum * 2 / size) return false;
                    size = 0;
                    sum = 0;
                }
                
            }
            return true;
        }

    }
    
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
