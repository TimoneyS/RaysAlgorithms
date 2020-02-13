package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      给定一个排序数组，在原数组中“删除”重复出现的数字，使得每个元素只出现一次，并且返回“新”数组的长度。
 *      不要使用额外的数组空间，必须在不使用额外空间的条件下原地完成。
 * 用例：
 *      **Example 1:**
 *      Input:  [1,1,2]
 *      Output: 2	
 *      Explanation:  uniqued array: [1,2]
 * 难度： Simple
 *   
 * @author rays1
 * @link   https://www.lintcode.cn/problem/remove-duplicates-from-sorted-array/description
 * @since  2019-07-11 18:30:32
 */
public class L_0100_Remove_Duplicates_from_Sorted_Array {
    /**
     * 排序数组
     * 用两个指针遍历数组，快的指针遍历所有元素，慢的指针指向唯一元素。
     */
    static class Solution {
        public int removeDuplicates(int[] nums) {
            int cursor = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i == 0 || nums[i] != nums[i-1]) {
                    nums[cursor++] = nums[i];
                }
            }
            return cursor;
        }
    }

    public static void main(String[] args) {
        int[] arr = {};
        int rs = new Solution().removeDuplicates(arr);
        Out.p(arr);
        Out.p(rs);
    }
}
