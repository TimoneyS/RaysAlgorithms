package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.util.ArrayUtil;

/**
 * Rotate Array
 * -----------------------------------------------------------------------------
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example:
 *      Example 1
 *      Input: [1,2,3,4,5,6,7] and k = 3
 *      Output: [5,6,7,1,2,3,4]
 *      Explanation:
 *      rotate 1 steps to the right: [7,1,2,3,4,5,6]
 *      rotate 2 steps to the right: [6,7,1,2,3,4,5]
 *      rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *      Example 2
 *      Input: [-1,-100,3,99] and k = 2
 *      Output: [3,99,-1,-100]
 *      Explanation: 
 *      rotate 1 steps to the right: [99,-1,-100,3]
 *      rotate 2 steps to the right: [3,99,-1,-100]
 *      Note:
 *      	Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 *      	Could you do it in-place with O(1) extra space?
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/rotate-array/
 * @since   2020-03-08 20:33:54
 */
public class L0189_Rotate_Array {
    /**
     * 封装数组区域交换的方法
     *      交换数组两个区域 = 交换等比区域 + 交换剩余区域
     */
    static class Solution {
        public void rotate(int[] str, int offset) {
            if (str.length == 0) return;
            int size = str.length;
            offset %= size;
            if (offset == 0) return;
            swap(str, 0, size-offset-1, size-offset, size-1);
        }

        private void swap(int[] arr, int l1, int r1, int l2, int r2) {
            int diff = (r1 - l1) - (r2 - l2);
            if (diff > 0) {
                // 左边部分更大
                swap(arr, l1 + diff, r1, l2, r2);
                swap(arr, l1, l1 + diff - 1, l1 + diff, r1);
            } else if (diff < 0) {
                // 右边部分更大
                swap(arr, l1, r1, l2, r2 + diff);
                swap(arr, l2, r2 + diff, r2 + diff+1, r2);
            } else {
                for (int i = l1, j = l2; i <= r1 && j <= r2; i++, j++) {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
