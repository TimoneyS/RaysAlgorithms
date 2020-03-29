package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Arrays;

/**
 * Three Equal Parts
 * -----------------------------------------------------------------------------
 * Given an array A of 0s and 1s, divide the array into 3 non-empty parts such that all of these parts represent the same binary value.
 * If it is possible, return any [i, j] with i+1 < j, such that:
 * 	A[0], A[1], ..., A[i] is the first part;
 * 	A[i+1], A[i+2], ..., A[j-1] is the second part, and
 * 	A[j], A[j+1], ..., A[A.length - 1] is the third part.
 * 	All three parts have equal binary value.
 * If it is not possible, return [-1, -1].
 * Note that the entire part is used when considering what binary value it represents.  For example, [1,1,0] represents 6 in decimal, not 3.  Also, leading zeros are allowed, so [0,1,1] and [1,1] represent the same value.
 *
 * Example:
 *      Example 1
 *      Input: [1,0,1,0,1]
 *      Output: [0,3]
 *      Example 2
 *      Input: [1,1,0,1,1]
 *      Output: [-1,-1]
 *      Note:
 *      	3 <= A.length <= 30000
 *      	A[i] == 0 or A[i] == 1
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/three-equal-parts/
 * @since   2020-03-29 22:59:00
 */
public class L0963_Three_Equal_Parts {
    /**
     * 如果可以被分成三等分，那么三个等分中，1的数量一定是相等的
     * 所以先统计所有 1 的数量，如果不是 3 的倍数，则一定不能被三等分
     *
     * 因为起始的 0 可以有任意多个，每个三等分都可以认为是从 1 开始
     * 那么只要分别从第 1 个 1，第 k 个 1，第 2k 个1开始，依次向后比对
     * 如果每个指针划过 k 个 1 后，他们的结构一致，则这个数组可以被三等分。
     *     ↓
     * ....1...............
     *   ..1...............
     *  ...1...............
     *
     */
    static class Solution {
        public int[] threeEqualParts(int[] A) {
            int count = (int) Arrays.stream(A).filter(n -> n == 1).count();
            if (count % 3 != 0) return new int[] {-1, -1};
            if (count == 0) return new int[] {0, A.length - 1};
            int l = 0;
            while (A[l] == 0) l ++;
            int m = next(A, count / 3, l);
            int r = next(A, count / 3, m);
            int step = 0;
            while (r + step < A.length) {
                if (l + step >= m || m + step >= r || A[l + step] != A[m + step] || A[m + step] != A[r + step])
                    return new int[]{-1, -1};
                step++;
            }
            return new int[] {l + step - 1, m + step};
        }

        private int next(int[] A, int c, int start) {
            while (start < A.length) {
                if (A[start] == 1) {
                    if (c > 0) c --;
                    else break;
                }
                start ++;
            }
            return start;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
