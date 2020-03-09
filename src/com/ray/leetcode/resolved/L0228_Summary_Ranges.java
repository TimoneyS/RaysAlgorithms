package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayList;
import java.util.List;

/**
 * Summary Ranges
 * -----------------------------------------------------------------------------
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 *
 * Example:
 *      Example 1
 *      Input:  [0,1,2,4,5,7]
 *      Output: [0->2,4->5,7]
 *      Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 *      Example 2
 *      Input:  [0,2,3,4,6,8,9]
 *      Output: [0,2->4,6,8->9]
 *      Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/summary-ranges/
 * @since   2020-03-09 21:30:03
 */
public class L0228_Summary_Ranges {
    static class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> rs = new ArrayList<>();
            if (nums.length == 0) return rs;
            int l = nums[0], r = nums[0];
            for (int i = 1; i <= nums.length; i++) {
                if (i == nums.length || nums[i] != r + 1) {
                    rs.add(l == r ? l + "" : l + "->" + r);
                    if (i < nums.length) {
                        l = nums[i];
                        r = nums[i];
                    }
                } else {
                    r ++;
                }
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
