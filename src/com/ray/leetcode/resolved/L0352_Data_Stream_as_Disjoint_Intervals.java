package com.ray.leetcode.resolved;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Data Stream as Disjoint Intervals
 * -----------------------------------------------------------------------------
 * Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.
 * For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:
 * [1, 1]
 * [1, 1], [3, 3]
 * [1, 1], [3, 3], [7, 7]
 * [1, 3], [7, 7]
 * [1, 3], [6, 7]
 * Follow up:
 * What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
 *
 * Example:
 *      
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals/
 * @since   2020-03-15 22:36:00
 */
public class L0352_Data_Stream_as_Disjoint_Intervals {
    /**
     * 维护一个将边界看错成对的数字，在map中存储双向的映射
     * 每次插入新的数字，就是对map中映射对的更新
     */
    static class SummaryRanges {
        TreeMap<Integer, Integer> inner = new TreeMap<>();

        /** Initialize your data structure here. */
        public SummaryRanges() {

        }

        public void addNum(int val) {
            Map.Entry<Integer, Integer> l = inner.lowerEntry(val);
            if (l != null && Math.max(l.getKey(), l.getValue()) == val - 1) {
                inner.remove(l.getKey());
                inner.remove(l.getValue());
                inner.put(l.getValue(), val);
                inner.put(val, l.getValue());
            } else if (!inner.containsKey(val) && (l == null || Math.max(l.getKey(), l.getValue()) < val-1)) {
                inner.put(val, val);
            }
            Map.Entry<Integer, Integer> h = inner.higherEntry(val);
            if (h != null && Math.min(h.getKey(), h.getValue()) == val + 1) {
                int left = inner.get(val);
                inner.remove(h.getKey());
                inner.remove(h.getValue());
                inner.remove(val);
                inner.put(left, h.getValue());
                inner.put(h.getValue(), left);
            }
        }

        public int[][] getIntervals() {
            List<int[]> intervals = new ArrayList<int[]>();
            int i = 0;
            for (Map.Entry<Integer, Integer> e : inner.entrySet()) {
                if (e.getKey() > e.getValue()) continue;
                intervals.add(new int[] {e.getKey(), e.getValue()});
                i ++;
            }
            return intervals.toArray(new int[0][0]);
        }
    }
    /**
     * Your SummaryRanges object will be instantiated and called as such:
     * SummaryRanges obj = new SummaryRanges();
     * obj.addNum(val);
     * int[][] param_2 = obj.getIntervals();
     */
    
    public static void main(String[] args) {
    }
}
