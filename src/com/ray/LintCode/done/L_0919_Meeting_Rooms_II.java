package com.ray.LintCode.done;

import java.util.ArrayList;
import java.util.List;

import com.ray.LintCode.util.Interval;
import com.ray.io.Out;

/**
 * 描述：
 *      给定一系列的会议时间间隔intervals，包括起始和结束时间[[s1,e1],[s2,e2],...] (si < ei)，找到所需的最小的会议室数量。
 *
 * 用例：
 *      **用例1**
 *      输入: intervals = [(0,30),(5,10),(15,20)]
 *      输出: 2
 *      解释:
 *      We need two meeting rooms
 *      room1: (0,30)
 *      room2: (5,10),(15,20)
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/meeting-rooms-ii/description
 * @date   2019-07-19 11:18:34
 */
public class L_0919_Meeting_Rooms_II {

    /**
     * 已经存在的会议室也会有时间轴，为了尽可能少的使用会议室，那么每个会议室的时间轴应该尽可能的密布会议
     * 因此每次贪心选择开始时间最早的会议，若有会议室空闲，否则放入新的会议室
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int minMeetingRooms(List<Interval> intervals) {
            
//            intervals.sort((o1, o2) -> o1.start == o2.start ? Integer.compare(o1.end, o2.end) : Integer.compare(o1.start, o2.start));
            
            intervals.sort((o1, o2) -> o1.end != o2.end ? Integer.compare(o1.end, o2.end) : Integer.compare(o1.start, o2.start));
            
            List<Integer> rooms = new ArrayList<Integer>();
            for (Interval interval : intervals) {
                
                int index = -1;
                for (int i = 0; i < rooms.size(); i++) {
                    if (rooms.get(i) <= interval.start) {
                        index = i;
                        break;
                    }
                }
                if (index == -1) {
                    rooms.add(interval.end);
                } else {
                    rooms.set(index, interval.end);
                }
            }
            
            return rooms.size();
        }
    
    }
    
    public static List<Interval> randomCase(int n, int seed) {
        List<Interval> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = 0,b = 0;
            while (b <= a ) {
                a = (int) (Math.random() * seed);
                b = (int) (Math.random() * seed);
            }
            list.add(new Interval(a, b));
        }
        return list;
    }
    
    public static void main(String[] args) {

        
        List<Interval> list = new ArrayList<>();
        
        list.add(new Interval(4, 9));
        list.add(new Interval(5, 6));
        list.add(new Interval(0, 5));
        list.add(new Interval(2, 4));
        
        
        Out.p(new Solution().minMeetingRooms(list));
        
    }

}
