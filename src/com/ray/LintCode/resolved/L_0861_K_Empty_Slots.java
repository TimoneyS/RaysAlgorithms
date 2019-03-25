package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.List;
import com.ray.LintCode.util.Interval;
import com.ray.io.Out;

/**
 * 花园里有 N 个位置，每个位置有一株花。 这些花在 N 天内会接连开放。在每天都会有一株花开放，并且一致保持盛开。
 * 
 * 给定一个数组 flowers , flowers[i] = x 表示第 i 天，位置 x 的花会开放。
 * 给定一个数字 K，返回恰好 K 朵连续的花没有开放的日子。
 * 如果没有这样的日子，返回 -1
 * 
 * 数组范围在 [1, 20000] 之间
 * @author rays1
 * @url    
 */
public class L_0861_K_Empty_Slots {

    /**
     * 采用区间表示该区间内的所有花都未开放
     * 然后每朵花儿开放，则一定会分割一个未开放的区间
     * 依次开放花朵，直到找到一个区间其大小正好为 k
     * 
     * 该算法里，区间用 list 保存，在查询位置所属区间时，搜索为线性算法
     * 实际上可以用二分的数据结构，如段树，这样搜索的复杂度可以降低。
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int kEmptySlots(int[] flowers, int k) {
            int N = flowers.length;
            
            List<Interval> list = new ArrayList<>();
            list.add(new Interval(Integer.MIN_VALUE, Integer.MAX_VALUE));
            
            for (int i = 1; i <= N; i++) {
                
                int x = flowers[i-1];
                Out.p(list);
                Out.p(x);
                
                int j = 0;
                Interval intv = null;
                while (j < list.size()) {
                    Interval temp = list.get(j);
                    if (temp.start <= x && temp.end >= x) {
                        intv = temp;
                        break;
                    }
                    j ++;
                }
                if (intv == null) continue;
                
                
                Interval intvRight = null;
                if (intv.start == x) {
                    intv.start = x+1;
                } else if (intv.end == x) {
                    intv.end = x-1;
                } else {
                    intvRight = new Interval(x+1, intv.end);
                    intv.end = x-1;
                }
                
                if (gap(intv) < k) {
                    list.remove(j);
                } else if (gap(intv) == k) {
                    return i;
                }
                
                if (gap(intvRight) > k) {
                    list.add(j, intvRight);
                } else if (gap(intvRight) == k) {
                    return i;
                }
                
            }
            
            return -1;
        }
        
        int gap(Interval interval) {
            return interval == null ? 0 : Math.abs(interval.end - interval.start) + 1;
        }
    
    }
    
    public static void main(String[] args) {
        
        int[] flowers = {6,5,8,9,7,1,10,2,3,4};
        int k = 2;
        
        Out.p(new Solution().kEmptySlots(flowers, k));
        
    }

}
