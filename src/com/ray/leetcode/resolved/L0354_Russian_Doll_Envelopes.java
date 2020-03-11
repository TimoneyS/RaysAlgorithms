package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Russian Doll Envelopes
 * -----------------------------------------------------------------------------
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 * Note:
 * Rotation is not allowed.
 *
 * Example:
 *      Example 1
 *      Input: [[5,4],[6,4],[6,7],[2,3]]
 *      Output: 3 
 *      Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/russian-doll-envelopes/
 * @since   2020-03-11 21:32:27
 */
public class L0354_Russian_Doll_Envelopes {
    /**
     * 将信封的长宽看做是坐标，则问题实际可以转换为二维平面上一些列的点，求最大的连续递增的点集。
     *
     * 然后将信封按照宽度排序，再按照高度逆排序，可以形成一个高度的数组
     *
     * 按照顺序，如果高度大于之前的高度，其对应的信封的宽度也一定大于之前的信封的宽度。因此只要寻找最大的高度递增子集即可。
     *
     * @author rays1
     *
     */
    static class Solution {

        public int maxEnvelopes(int[][] envelopes) {

            Arrays.sort(envelopes, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return (a[0] == b[0]) ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]);
                }
            });

            int dp[] = new int[envelopes.length];
            int rs = 0;
            for(int[] envelope : envelopes){
                int index = Arrays.binarySearch(dp, 0, rs, envelope[1]);
                if(index < 0) index = -index - 1;
                dp[index] = envelope[1];
                if (index == rs) rs++;
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
