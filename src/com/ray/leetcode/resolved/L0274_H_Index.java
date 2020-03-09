package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Arrays;

/**
 * H-Index
 * -----------------------------------------------------------------------------
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 * According to the definition of h-index on Wikipedia: A scientist has index h if h of his/her N papers have at least h citations each, and the other N &minus; h papers have no more than h citations each.
 *
 * Example:
 *      Example 1
 *      Input: citations = [3,0,6,1,5]
 *      Output: 3 
 *      Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had 
 *                   received 3, 0, 6, 1, 5 citations respectively. 
 *                   Since the researcher has 3 papers with at least 3 citations each and the remaining 
 *                   two with no more than 3 citations each, her h-index is 3.
 *      Note: If there are several possible values for h, the maximum one is taken as the h-index.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/h-index/
 * @since   2020-03-10 01:10:23
 */
public class L0274_H_Index {

    /**
     * 如果指数为 h , 则至少有 h 个论文引用 大于等于 h
     * 反之，最多有 n - h 个论文，引用小于 h
     *
     * n-h+1>= h
     */
    static class Solution {
        public int hIndex(int[] citations) {
            Arrays.sort(citations);
            for (int h = citations.length; h > 0; h--) {
                if (citations[citations.length - h] >= h) {
                    return h;
                }
            }
            return 0;
        }
    }
    
    public static void main(String[] args) {
        int[] nums = new int[]{0,1};
        Out.p(new Solution().hIndex(nums));
    }
}
