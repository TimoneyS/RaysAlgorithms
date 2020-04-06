package com.ray.LintCode.tostudy;

import java.util.ArrayList;
import java.util.List;

import com.ray.LintCode.util.Interval;

/**
 * 描述：
 *      Given an integer array (index from 0 to n-1, where n is the size of this array), and an query list. Each query has two integers `[start, end]`. For each query, calculate the sum number between index start and end in the given array, return the result list.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input: array = [1,2,7,8,5],  queries = [(0,4),(1,2),(2,4)]
 *      Output: [23,9,20]
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input: array : [4,3,1,2],  queries : [(1,2),(0,2)]
 *      Output: [4,8]
 *      ```
 *
 * 挑战：
 *      O(logN) time for each query
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/interval-sum/description
 * @date   2019-07-11 18:31:56
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
