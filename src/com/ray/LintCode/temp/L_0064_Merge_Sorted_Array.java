package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      给定两个有序数组 A 和 B，将 B 合并到 A 中
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：[1, 2, 3] 3  [4,5]  2
 *      Output：[1,2,3,4,5]
 *      Explanation:
 *      After merge, A will be filled as [1, 2, 3, 4, 5]
 *      ```
 *      **Example 2:**
 *      ```
 *      Input：[1,2,5] 3 [3,4] 2
 *      Output：[1,2,3,4,5]
 *      Explanation:
 *      After merge, A will be filled as [1, 2, 3, 4, 5]
 *      ```
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/merge-sorted-array/description
 * @date   2019-07-11 18:29:41
 */
public class L_0064_Merge_Sorted_Array {

    /**
     * 类似 L_0006_Merge_Two_Sorted_Arrays，不同的是这里是合并到 A
     * 
     * 合并的时候，注意如果 A 的两个元素之间包含多个 B 的元素，那么可以一次性的挪出多个位置
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        public void mergeSortedArray(int[] A, int m, int[] B, int n) {
            
            int i=0,j=0;
            while (i <= m && j < n) {
                if (i == m) {
                    A[i++] = B[j++];
                    m++;
                } else if (A[i] <= B[j]) {
                    i++;
                } else {

                    // 统计需要挪出多少空间
                    int c = 0;
                    while (j < n) {
                        if (A[i] <= B[j]) break;
                        j++;
                        c++;
                    }
                    
                    // 挪出空间
                    for (int k = m+c-1; k >= i+c; k--) {
                        A[k] = A[k-c];
                    }
                    
                    // 插入 B 的元素
                    for (int k = c; k > 0; k--) {
                        A[i++] = B[j-k];
                        m++;
                    }
                    
                }
            }
            
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] A = {1,3,4,6,0,0};
        int[] B = {2,5};
        int m = 4;
        int n = 2;
        new Solution().mergeSortedArray(A, m, B, n);
        Out.p(A);
    }

}
