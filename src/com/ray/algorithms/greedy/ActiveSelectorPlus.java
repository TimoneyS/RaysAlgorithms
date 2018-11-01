package com.ray.algorithms.greedy;

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
 * 
 * 
 * @author rays1
 *
 */
public class ActiveSelectorPlus {
    
    int[]     event;        // 事件
    boolean[] isStart;      // 事件是开始还是结束
    int[]     active;       // 事件对应的活动
    
    public ActiveSelectorPlus(int[] s, int[] f) {
        
        int n = s.length;
        
        event = new int[n*2];
        isStart = new boolean[n*2];
        active = new int[n*2];
        
        for (int i = 0; i < event.length; i++) {
            s[2*i] = s[i];
            s[2*i+1] = f[i];
            isStart[2*i] = true;
            active[2*i] = i; 
            active[2*i+1] = i;
        }
        
        sortEvent();
        
        
        
    }
    
    private void sortEvent() {
        
        for (int i = event.length-1; i > 0; i --) {
            for (int j = 0; j < i; j ++) {
                if (event[i] < event[i+1] && isStart[i]) {
                    eventSwap(i, i+1);
                }
            }
        }
        
    }

    private void eventSwap(int i, int j) {
        ArrayUtil.swap(event, i, j);
        ArrayUtil.swap(isStart, i, j);
        ArrayUtil.swap(active, i, j);
    }
    
}
