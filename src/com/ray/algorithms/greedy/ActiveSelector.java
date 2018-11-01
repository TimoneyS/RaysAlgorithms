package com.ray.algorithms.greedy;

import com.ray.io.Out;

/**
 * 活动选择问题
 * <p>
 * 假定n个活动的集合 S = { a1, a2, ... , an }，每个活动 ai 都有一个开始时间 si 和结束时间 fi <br>
 * 活动兼容：活动 ai 和 aj 如果 si ≥ fj 或者  sj ≥ fi,，则称活动 ai 和 aj 兼容
 * <p>
 * 求S的最大兼容活动子集。
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
        int rs = maxSelector(0, s.length-1);
        
        Out.p(rs);
    }
    
    // 每次选择结束时间最早的活动，然后求解子问题
    private int maxSelector(int i, int j) {
        marked[i] = true;
        for (int k = i; k <= j; k++)
            if (s[k] >= f[i]) return 1 + maxSelector(k, j); 
        return 0;
    }

    // 将活动按结束时间排序
    private void sortActive() {
        for (int i = 0; i < s.length-1;  i++) {
            for (int j = 0; j < s.length-1;  j++) {
                if (f[i+1] < f[i]) swap(i, i+1);
            }    
        }
    }
    
    private void swap(int i, int j) {
        int temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        f[i] = f[j];
        f[j] = temp;
    }
    
    public static void main(String[] args) {
        
        int[] s = {1, 3, 0, 5, 3, 5,  6,  8,  8,  2, 12};
        int[] f = {4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16};
        
        ActiveSelector as = new ActiveSelector(s, f);
        
        for (int i = 0; i < f.length; i++) {
            
            if (as.marked[i])
                Out.p(as.s[i] + " " + as.f[i]);
        }
        
        
    }

}
