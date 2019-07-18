package com.ray.LintCode.temp;

import java.util.ArrayList;
import java.util.List;

import com.ray.LintCode.util.Interval;
import com.ray.io.Out;

/**
 * 描述：
 *      There is a garden with `N` slots. In each slot, there is a flower. The `N` flowers will bloom one by one in `N` days. In each day, there will be `exactly` one flower blooming and it will be in the status of blooming since then.
 *      
 *      Given an array `flowers` consists of number from `1` to `N`. Each number in the array represents the place where the flower will open in that day.
 *      
 *      For example, `flowers[i] = x` means that the unique flower that blooms at day `i` will be at position `x`, where `i` and `x` will be in the range from `1` to `N`.
 *      
 *      Also given an integer `k`, you need to output in which day there exists two flowers in the status of blooming, and also the number of flowers between them is `k` and these flowers are not blooming.
 *      
 *      If there are multiple answers, choose the smallest.
 *      If there isn't such day, output -1.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：[1,2,3,4]，k=1
 *      Output：-1
 *      Explanation：The first two flowers to open are next to each other.
 *      ```
 *      **Example 2:**
 *      ```
 *      Input：[1,3,2]，k=1
 *      Output：2
 *      Explanation：In the second day, the first and the third flower have become blooming.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/k-empty-slots/description
 * @date   2019-07-11 18:38:01
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
        
        Out.p(new Solution());
        
    }

}
