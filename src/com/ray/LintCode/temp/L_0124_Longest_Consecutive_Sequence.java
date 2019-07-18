package com.ray.LintCode.temp;

import java.util.Arrays;

/**
 * 描述：
 *      <p>Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *      </p>
 *
 * 用例：
 *      ***Example 1***
 *      ```
 *      Input : [100, 4, 200, 1, 3, 2]
 *      Output : 4
 *      Explanation : The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length:4
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/longest-consecutive-sequence/description
 * @date   2019-07-11 18:30:52
 */
public class L_0124_Longest_Consecutive_Sequence {

    static class Solution {
        
        public int longestConsecutive(int[] num) {
            Arrays.sort(num);
            int max = 1;
            int t = 1;
            int prev = Integer.MIN_VALUE;
            for (int i : num) {
                if (prev + 1 == i) {
                    t ++;
                } else if (prev == i) {
                    continue;
                }else {
                    t = 1;
                }
                max = Math.max(t, max);
                prev = i;
            }
            return max;
        }
        
    }

}
