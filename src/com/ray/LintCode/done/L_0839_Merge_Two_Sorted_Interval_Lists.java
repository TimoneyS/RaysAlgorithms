package com.ray.LintCode.done;

import java.util.ArrayList;
import java.util.List;

import com.ray.LintCode.util.Interval;
import com.ray.io.Out;

/**
 * 描述：
 *      Merge two sorted (ascending) lists of interval and return it as a new sorted list. The new sorted list should be made by splicing together the intervals of the two lists and sorted in ascending order.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: list1 = [(1,2),(3,4)] and list2 = [(2,3),(5,6)]
 *      Output: [(1,4),(5,6)]
 *      Explanation:
 *      (1,2),(2,3),(3,4) --> (1,4)
 *      (5,6) --> (5,6)
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: list1 = [(1,2),(3,4)] and list2 = [(4,5),(6,7)]
 *      Output: [(1,2),(3,5),(6,7)]
 *      Explanation:
 *      (1,2) --> (1,2)
 *      (3,4),(4,5) --> (3,5)
 *      (6,7) --> (6,7)
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/merge-two-sorted-interval-lists/description
 * @date   2019-07-11 18:37:20
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
