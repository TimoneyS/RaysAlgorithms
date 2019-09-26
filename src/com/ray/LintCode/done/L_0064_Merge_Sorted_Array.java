package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述： 给定两个有序数组 A 和 B，将 B 合并到 A 中 用例： **Example 1:** ``` Input：[1, 2, 3] 3 [4,5]
 * 2 Output：[1,2,3,4,5] Explanation: After merge, A will be filled as [1, 2, 3,
 * 4, 5] ``` **Example 2:** ``` Input：[1,2,5] 3 [3,4] 2 Output：[1,2,3,4,5]
 * Explanation: After merge, A will be filled as [1, 2, 3, 4, 5] ``` 难度： Simple
 * 
 * @author rays1
 * @url https://www.lintcode.cn/problem/merge-sorted-array/description
 * @date 2019-07-11 18:29:41
 */
public class L_0064_Merge_Sorted_Array {

    /**
     * 类似 L_0006_Merge_Two_Sorted_Arrays，不同的是这里是合并到 A
     * 
     * 因此检查 A 和 B 中的元素，如果A的元素小或者相等，则A前进
     * 如果 B 的元素小，则把所有小于A当前元素的全部插入的A中的元素之前
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        public void mergeSortedArray(int[] A, int m, int[] B, int n) {
            
            for (int i = 0, j = 0; i < m + n && j < n;) {
                
                if (i == m ) {
                    A[i++] = B[j++];
                    m++;
                } else if (A[i] <= B[j]) {
                    i++;
                } else {
                    
                    // 统计
                    int c = 0;
                    while (j < n && B[j] <= A[i]) {
                        c ++;
                        j ++;
                    }
                
                    // 从 i 开始之后的数字需要挪出 c 个空间，一共有 m - i 个数字
                    for (int k = 0; k < m-i; k++) {
                        A[m + c - k - 1] = A[m - k - 1];
                    }
                    i += c;
                    m += c;
                    
                    // j-c ~ j-1 的数字 移动到 i-c ~ i-1
                    for (int k = 1; k <= c; k++) {
                        A[i-k] = B[j-k];
                    }
                    
                }
                
            }
            
        }

    }

    public static void main(String[] args) {

        int[] A = { 1, 3, 4, 6, 0, 0 };
        int[] B = { 2, 5 };
        int m = 4;
        int n = 2;
        new Solution().mergeSortedArray(A, m, B, n);
        Out.p(A);
    }

}
