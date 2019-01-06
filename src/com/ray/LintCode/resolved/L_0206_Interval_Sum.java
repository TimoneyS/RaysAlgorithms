package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author rays1
 *
 */
public class L_0206_Interval_Sum {

    static class Solution {
        /**
         * @param A: An integer list
         * @param queries: An query list
         * @return: The result list
         */
        public List<Long> intervalSum(int[] A, List<Interval> queries) {
            long[] sum = new long[A.length+1];
            sum[0] = 0;
            for (int i = 1; i < sum.length; i++) {
                sum[i] = sum[i-1] + A[i-1];
            }
            
            List<Long> rs = new ArrayList<>();
            
            for (Interval interval : queries) {
                rs.add(sum[interval.end+1] - sum[interval.start]);
            }
            
            return rs;
        }
    }

}
