package com.ray.algorithms.greedy;

import com.ray.io.Out;
import com.ray.util.ArrayUtil;

/**
 * 活动选择问题
 * <p>
 * 假定n个活动的集合 S = { a1, a2, ... , an }，每个活动 ai 都有一个开始时间 si 和结束时间 fi <br>
 * 活动兼容：活动 ai 和 aj 如果 si ≥ fj 或者  sj ≥ fi,，则称活动 ai 和 aj 兼容
 * <p>
 * 任意活动可以安排到任意教室，只要保证每个教室的活动互相兼容。要求使用尽可能少的教室安排所有活动。
 * <p>
 * 求最优安排
 * 
 * <p>
 * 算法：<br>
 * 将所有的活动的开始事件和结束时间放到一条时间线上，相同的时间开始时间比结束时间靠后。<br>
 * 依次遍历时间，每个时间点作为一个事件。
 * <p>
 * 当前事件如果是某个活动的开始时间：<br>
 *  1.则检查是否有教室空闲，然后将活动分配到该教室。（如果教室忙，则说明该教室已经被分配了活动且当前事件点未结束）<br>
 *  2.如果没有教室空闲，则新分配一个教室<br>
 * <p>
 * 当前时间如果是某个活动的结束时间：<br>
 *  1.寻找活动所在的教室，将教室设置为空闲 
 * 
 * @author rays1
 *
 */
public class ActiveSelectorPlus {
    
    int[]     eventArray;        // 事件
    boolean[] isActiveStart;      // 事件是开始还是结束
    int[]     eventActive;       // 事件对应的活动
    
    int       hallNum = 0;
    boolean[] isHallBusy;
    int[]     activeHall;       // 活动所在的教室
    
    public ActiveSelectorPlus(int[] s, int[] f) {
        
        int n = s.length;
        
        eventArray = new int[n*2];
        isActiveStart = new boolean[n*2];
        eventActive = new int[n*2];
        
        isHallBusy = new boolean[n];
        activeHall = new int[n];
        
        for (int i = 0; i < s.length; i++) {
            eventArray[2*i] = s[i];
            eventArray[2*i+1] = f[i];
            isActiveStart[2*i] = true;
            eventActive[2*i] = i; 
            eventActive[2*i+1] = i;
        }

        sortEvent();
        
        for (int i = 0; i < eventArray.length; i++) {
            handleEvent(i);
        }
        
    }
    
    /**
     * 处理事件
     * @param event
     */
    private void handleEvent(int eventIndex) {
        
        int activeIndex = eventActive[eventIndex]; // 事件对应的活动
        
        if (isActiveStart[eventIndex]) {
            // 是开始索引需要为活动找一个可用教室
            int hallIndex = 0;
            while (hallIndex < hallNum) {
                if (!isHallBusy[hallIndex]) break;
                hallIndex ++;
            }
            
            // 没有空闲的教室，本例里只要将计数+1，如果活动较多，不能简单的使用 n 作为教室的数组的大小，就可能需要调整数组等操作
            if (hallIndex == hallNum) hallNum ++;
            activeHall[activeIndex] = hallIndex;
            isHallBusy[hallIndex] = true;
            
        } else {
            // 是结束索引，需要设置教室可用
            int hallIndex = activeHall[activeIndex];
            isHallBusy[hallIndex] = false;
        }
        
    }

    private void sortEvent() {
        for (int i = 0; i < eventArray.length; i++) {
            int minIndex = ArrayUtil.indexOfMin(eventArray, i, eventArray.length - 1);
            ArrayUtil.swap(eventArray, i, minIndex);
            ArrayUtil.swap(isActiveStart, i, minIndex);
            ArrayUtil.swap(eventActive, i, minIndex);
        }
    }

    
    public static void main(String[] args) {
        
        int[] s = {1, 3, 0, 5, 3, 5,  6,  8,  8,  2, 12};
        int[] f = {4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16};
        ActiveSelectorPlus asp = new ActiveSelectorPlus(s, f);
        
        Out.p(asp.activeHall);
        
    }
    
}
