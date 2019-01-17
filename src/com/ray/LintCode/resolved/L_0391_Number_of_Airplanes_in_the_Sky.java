package com.ray.LintCode.resolved;

import java.util.Arrays;
import java.util.List;

import com.ray.LintCode.util.Interval;

/**
 * 给出一个间隔列表，它是飞行的飞行和着陆时间。
 * 天上最多有多少架飞机？
 *
 * @author rays1
 *
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
    
}
