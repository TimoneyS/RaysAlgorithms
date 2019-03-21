package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.List;

import com.ray.LintCode.util.Interval;
import com.ray.io.Out;

/**
 * Merge two sorted (ascending) lists of interval and return it as a new sorted list.
 * The new sorted list should be made by splicing together the intervals of the two lists and sorted in ascending order.
 * 
 * https://www.lintcode.com/problem/merge-two-sorted-interval-lists/description
 * @author rays1
 *
 */
public class L_0839_Merge_Two_Sorted_Interval_Lists {

    static class Solution {
    
        public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
            
            int i = 0, j = 0, k = -1;
            List<Interval> rs = new ArrayList<>();
            
            while (i < list1.size() || j < list2.size()) {
                Interval top = k < 0 ? null : rs.get(k);
                
                Interval next = i < list1.size() ? list1.get(i) : null;
                if (next == null || j < list2.size() && next.start > list2.get(j).start) {
                    next = list2.get(j);
                    j++;
                } else {
                    i++;
                }
                
                if (next == null) continue;
                
                if (top != null && top.end >= next.start) {
                    top.end = Math.max(next.end, top.end);
                } else {
                    rs.add(next);
                    k++;
                }
                
            }
            
            return rs;
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
