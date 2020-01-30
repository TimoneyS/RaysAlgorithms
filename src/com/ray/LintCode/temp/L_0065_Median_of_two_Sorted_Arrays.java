package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 * 两个有序的数组 A 和 B，寻找两个数组的中位数
 * 如果数组长度是奇数，中位数是中间数字
 * 如果数组长度是偶数，中位数是中间两个数字的平均数。
 * <p>
 * 用例：
 * **Example 1**
 * Input:
 * A = [1,2,3,4,5,6]
 * B = [2,3,4,5]
 * Output: 3.5
 * <p>
 * **Example 2**
 * Input:
 * A = [1,2,3]
 * B = [4,5]
 * Output: 3
 * <p>
 * 挑战：
 * 时间复杂度 O(log (m +n))
 * 难度： Hard
 *
 * @author rays1
 * @link https://www.lintcode.cn/problem/median-of-two-sorted-arrays/description
 * @since 2019-07-11 18:29:42
 */
public class L_0065_Median_of_two_Sorted_Arrays {

    /**
     * 分析：
     * 两个数组长度 m + n,
     * 如果 m + n 是奇数，则中位数是第 (m+n)/2 + 1 个数字
     * 如果 m + n 是偶数，则中位数是第 (m+n)/2 + 1 和第 (m+n)/2 个数字的平均值
     * <p>
     * 算法：
     * 中位数是寻找第 k 个数字，先在 A, B 中分别寻找第 k/2 大的元素
     * 比较 A[k/2] 和 B[k/2]:
     * 如果 A[k/2] = B[k/2]，说明 A[k/2] 正好是第 k 大的元素
     * 如果 A[k/2] < B[k/2]，说明
     */
    static class Solution {
        public double findMedianSortedArrays(int[] A, int[] B) {
            int n1 = A.length, n2 = B.length;
            int r1 = (n1 + n2 + 1) / 2;
            int r2 = (n1 + n2 + 2) / 2;
            return (findK(A, B, 0, 0, r1) + findK(A, B, 0, 0, r2)) / 2.0;
        }

        int findK(int[] A, int[] B, int i, int j, int k) {
            while (k > 1) {
                int t1 = (i + k / 2 - 1 < A.length) ? A[i + k / 2 - 1] : Integer.MAX_VALUE;
                int t2 = (j + k / 2 - 1 < B.length) ? B[j + k / 2 - 1] : Integer.MAX_VALUE;
                if (t1 < t2) i += k / 2;
                else j += k / 2;
                k -= k / 2;
            }
            if (i == A.length) return B[j];
            if (j == B.length) return A[i];
            return Math.min(A[i], B[j]);
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 3};
        int[] B = {4, 5};

        Out.p(new Solution().findMedianSortedArrays(A, B));
    }
}
