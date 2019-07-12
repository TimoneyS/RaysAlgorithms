package com.ray.LintCode.done;

import java.util.Arrays;
import java.util.List;

import com.ray.LintCode.util.Interval;
import com.ray.io.Out;

/**
 * 描述：
 *      Given an list `interval`,  which are taking off and landing time of the flight. How many airplanes are there at most at the same time in the sky?
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: [(1, 10), (2, 3), (5, 8), (4, 7)]
 *      Output: 3
 *      Explanation:
 *      The first airplane takes off at 1 and lands at 10.
 *      The second ariplane takes off at 2 and lands at 3.
 *      The third ariplane takes off at 5 and lands at 8.
 *      The forth ariplane takes off at 4 and lands at 7.
 *      During 5 to 6, there are three airplanes in the sky.
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: [(1, 2), (2, 3), (3, 4)]
 *      Output: 1
 *      Explanation: Landing happen before taking off.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/number-of-airplanes-in-the-sky/description
 * @date   2019-07-11 18:32:27
 */
public class L_0391_Number_of_Airplanes_in_the_Sky {

    /**
     * 维护两个按照时间递增的事件流（也可以用一个事件流，用额外信息判断是起飞还是降落事件）
     * 起飞事件数组和降落事件数组
     * 
     * 每次选择较早的事件让其发生，如果事件事件一致则降落事件先发生。
     * 起飞事件将天空飞机数+1
     * 降落事件将天空飞机数-1
     * 同时使用max记录最大的飞机数量
     * 
     * @author rays1
     *
     */
    static class Solution {
        public int countOfAirplanes(List<Interval> airplanes) {
            
            int[] start = new int[airplanes.size()];
            int[] end = new int[airplanes.size()];
            
            int si = 0, ei = 0;
            for (Interval itv : airplanes) {
                start[si++] = itv.start;
                end[ei++] = itv.end;
            }
            
            Arrays.sort(start);
            Arrays.sort(end);
            
            int curr = 0, max = 0;
            si = ei = 0;
            while (si < start.length) {
                if (start[si] < end[ei]) {
                    si ++;
                    curr ++;
                    max = Math.max(max, curr);
                } else {
                    ei ++;
                    curr --;
                }
            }
            
            return 0;
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
