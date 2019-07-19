package com.ray.algorithms.greedy;

import com.ray.io.Out;
import com.ray.util.ArrayUtil;

/**
 * 活动选择问题
 * 假定n个活动的集合 S = { a1, a2, ... , an }，每个活动 ai 都有一个开始时间 si 和结束时间 fi
 * 寻找一间教室可以安排的最大的活动数量，的活动必须是兼容的（活动兼容：两个活动在时间轴上没有交叉）。
 * 
 * 贪心选择：每次选择一个活动，选择完这个活动后剩下的资源还能尽可能多的安排活动
 *          因此每次选择结束时间最早的活动，这样剩下的时间轴最长。
 * 
 * @author rays1
 *
 */
public class ActiveSelector {

    int[] s;
    int[] f;
    boolean[] marked;
    
    public ActiveSelector(int[] s, int[] f) {
        this.s = s;
        this.f = f;
        marked = new boolean[s.length];
        
        sortActive();
        
        int rs = 0, prev = -1;
        for (int i = 0; i < s.length; i++) {
            if (prev == -1 || f[prev] < s[i]) {
                rs ++;
                prev = i;
                marked[i] = true;
            }
        }
        
        Out.p(rs);
    }

    // 将活动按结束时间排序
    private void sortActive() {
        for (int i = 0; i < s.length-2;  i++) {
            int minIndex = ArrayUtil.indexOfMin(f, i, f.length - 1);
            ArrayUtil.swap(f, i, minIndex);
            ArrayUtil.swap(s, i, minIndex);
        }
    }
    
    public static void main(String[] args) {
        
        int[] s = {1, 3, 0, 5, 3, 5,  6,  8,  8,  2, 12};
        int[] f = {4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16};
        
        ActiveSelector as = new ActiveSelector(s, f);
        
        for (int i = 0; i < f.length; i++) {
            if (as.marked[i]) {
                Out.p(as.s[i] + " " + as.f[i]);
            }
        }
        
        
    }

}
