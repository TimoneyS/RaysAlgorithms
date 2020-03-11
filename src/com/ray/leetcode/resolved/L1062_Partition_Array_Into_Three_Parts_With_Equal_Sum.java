package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Partition Array Into Three Parts With Equal Sum
 * -----------------------------------------------------------------------------
 * Given an array A of integers, return true if and only if we can partition the array into three non-empty parts
 * with equal sums.
 * Formally, we can partition the array if we can find indexes i+1 < j with (A[0] + A[1] + ... + A[i]
 *      == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])
 *
 * Example:
 *      Example 1
 *      Input: A = [0,2,1,-6,6,-7,9,1,2,0,1]
 *      Output: true
 *      Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 *      Example 2
 *      Input: A = [0,2,1,-6,6,7,9,-1,2,0,1]
 *      Output: false
 *      Example 3
 *      Input: A = [3,3,6,5,-2,2,5,1,-9,4]
 *      Output: true
 *      Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 *      Constraints:
 *      	3 <= A.length <= 50000
 *      	-10^4 <= A[i] <= 10^4
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/
 * @since   2020-03-11 00:21:14
 */
public class L1062_Partition_Array_Into_Three_Parts_With_Equal_Sum {
    static class Solution {
        public boolean canThreePartsEqualSum(int[] A) {
            for (int i = 0; i < A.length; i++) A[i] +=  i == 0 ? 0 : A[i-1];
            if (A[A.length-1] % 3 != 0) return false;
            int c = 0;
            for (int i = 0; i < A.length-1; i++) {
                if (A[i] == A[A.length - 1] / 3 * (c + 1))
                    c++;
                if (c == 2) return true;
            }
            return false;
        }
    }
    
    public static void main(String[] args) {

        int[] A = {1,-1,1,-1};
        Out.p(new Solution().canThreePartsEqualSum(A));
    }
}
