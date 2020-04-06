package com.ray.LintCode.locked;

import java.util.List;

import com.ray.LintCode.util.Interval;
import com.ray.io.Out;

/**
 * 描述：
 *      给定一系列的会议时间间隔，包括起始和结束时间[[s1,e1]，[s2,e2]，…(si < ei)，确定一个人是否可以参加所有会议。
 *
 * 用例：
 *      **用例1**
 *      输入: intervals = [(0,30),(5,10),(15,20)]
 *      输出: false
 *      解释: 
 *      (0,30), (5,10) and (0,30),(15,20) will conflict
 *      
 *      **用例2**
 *      输入: intervals = [(5,8),(9,15)]
 *      输出: true
 *      解释: 
 *      Two times will not conflict 
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/meeting-rooms/description
 * @date   2019-07-19 11:22:59
 */
public class L_0920_Meeting_Rooms {

    /**
     * 问题可以转换为寻找是否有交叉的区间。
     * 
     * 将区间按照开始顶点排序，如果有交叉，则交叉的两个区间一定相邻。
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public boolean canAttendMeetings(List<Interval> intervals) {
            intervals.sort((o1, o2) -> o1.start == o2.start ? Integer.compare(o1.end, o2.end) : Integer.compare(o1.start, o2.start));
            
            Interval prev = null;
            for (Interval itv : intervals) {
                if (prev != null && prev.end > itv.start) {
                    return false;
                }
                prev = itv;
            }
            
            return true;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
