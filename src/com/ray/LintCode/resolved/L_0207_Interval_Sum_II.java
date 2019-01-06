package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 *
 *
 * @author rays1
 *
 */
public class L_0207_Interval_Sum_II {

    static class Solution {

        long[] sum;
        int[]  A;

        public Solution(int[] A) {
            this.A = A;
            sum = new long[A.length + 1];
            sum(0);
        }

        private void sum(int start) {
            for (int i = start + 1; i < sum.length; i++)
                sum[i] = sum[i - 1] + A[i - 1];
        }

        public long query(int start, int end) {
            return sum[end + 1] - sum[start];
        }

        public void modify(int index, int value) {
            A[index] = value;
            sum(index);
        }
    }

    public static void main(String[] args) {

        int[] A = { 1, 2, 7, 8, 5 };

        Solution sol = new Solution(A);

        Out.p(sol.query(0, 2));
        sol.modify(0, 4);
        Out.p(sol.query(0, 1));
        sol.modify(2, 1);
        Out.p(sol.query(2, 4));

    }

}
