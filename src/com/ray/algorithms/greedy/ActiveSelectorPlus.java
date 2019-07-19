package com.ray.algorithms.greedy;

import java.util.Arrays;

import com.ray.io.Out;

/**
 * 活动选择问题
 * 
 * 假定n个活动的集合 S = { a1, a2, ... , an }，每个活动 ai 都有一个开始时间 si 和结束时间 fi
 * 如果使用尽可能少的教室安排所有活动，每个教室内的活动必须是兼容的（活动兼容：两个活动在时间轴上没有交叉）。
 * 
 * 算法：
 *      将所有的活动的开始事件和结束时间放到一条时间线上，相同的时间开始时间比结束时间靠后。
 *      依次遍历时间，每个时间点作为一个事件。
 *      
 * 当前事件如果是某个活动的开始时间：
 *      1.则检查是否有教室空闲，然后将活动分配到该教室。（如果教室忙，则说明该教室已经被分配了活动且当前事件点未结束）
 *      2.如果没有教室空闲，则新分配一个教室
 *      
 * 当前时间如果是某个活动的结束时间：
 *      1.寻找活动所在的教室，将教室设置为空闲 
 * 
 * @author rays1
 *
 */
public class ActiveSelectorPlus {
    
    int[][] events;
    
    int       roomNum = 0;
    boolean[] isHallBusy;
    int[]     a2Room;        // 活动所在的教室
    
    public ActiveSelectorPlus(int[] s, int[] f) {
        
        int n = s.length;
        
        events = new int[n * 2][2];
        isHallBusy = new boolean[n];
        a2Room = new int[n];
        
        for (int i = 0; i < s.length; i++) {
            events[2 * i][0] = s[i];
            events[2 * i + 1][0] = -f[i];
            events[2 * i][1] = i;
            events[2 * i + 1][1] = i;
        }
        
        Arrays.sort(events, (o1, o2) -> Integer.compare(Math.abs(o1[0]), Math.abs(o2[0])));
        Out.p(events, "%3s ");
        
        
        for (int i = 0; i < events.length; i++) {
            handleEvent(i);
        }
        
    }
    
    /**
     * 处理事件
     * @param event
     */
    private void handleEvent(int eventIndex) {
        
        int activeIndex = events[eventIndex][1]; // 事件对应的活动
        
        if (events[eventIndex][0] > 0) {
            // 是开始索引需要为活动找一个可用教室
            int hallIndex = 0;
            while (hallIndex < roomNum) {
                if (!isHallBusy[hallIndex]) break;
                hallIndex ++;
            }
            
            // 没有空闲的教室，本例里只要将计数+1，如果活动较多，不能简单的使用 n 作为教室的数组的大小，就可能需要调整数组等操作
            if (hallIndex == roomNum) roomNum ++;
            a2Room[activeIndex] = hallIndex;
            isHallBusy[hallIndex] = true;
            
        } else {
            // 是结束索引，需要设置教室可用
            int hallIndex = a2Room[activeIndex];
            isHallBusy[hallIndex] = false;
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] s = {1, 3, 0, 5, 3, 5,  6,  8,  8,  2, 12};
        int[] f = {4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16};
        ActiveSelectorPlus asp = new ActiveSelectorPlus(s, f);
        
        Out.p(asp.a2Room);
        Out.p(asp.roomNum);
        
    }
    
}
