package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Sort Colors
 *
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 *
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/sort-colors/
 * @since   2020-02-28 23:26:47
 */
public class L0075_Sort_Colors {
    /**
     * 设置两个指针，指向左右，然后查看颜色
     * 如果是 0 则放入左边，如果是 2 放入右边。
     * 当遍历到达右侧指针位置，说明遍历完毕。
     *
     * 需要注意的是，如果从左侧开始遍历颜色，那么如果一个颜色和右侧交换
     * 交换后当前位置的元素是新元素，则遍历需要索引-1
     */
    static class Solution {
        public void sortColors(int[] nums) {
            int l = 0, r = nums.length - 1;
            for (int i = 0; i <= r; i++) {
                if (nums[i] == 0) {
                    swap(nums, i, l++);
                } else if (nums[i] == 2) {
                    swap(nums, i--, r--);
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
    
    public static void main(String[] args) {
        int[] nums = new int[]{
                1,1,2,2,0,0
        };
        new Solution().sortColors(nums);
        Out.p(nums);
    }
}
