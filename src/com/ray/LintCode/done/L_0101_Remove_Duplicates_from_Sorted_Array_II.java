package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      给你一个排序数组，删除其中的重复元素，使得每个数字最多出现两次，返回新的数组的长度。
 *      如果一个数字出现超过2次，则这个数字最后保留两个。
 * 用例：
 *      Example 1:
 *      	Input:  [1,1,1,2,2,3]
 *      	Output: 5
 *      	Explanation:
 *      	the length is 5: [1,1,2,2,3]
 * 难度： Simple
 *
 * @author rays1
 * @link   https://www.lintcode.cn/problem/remove-duplicates-from-sorted-array-ii/description
 * @since  2019-07-11 18:30:33
 */
public class L_0101_Remove_Duplicates_from_Sorted_Array_II {
    /**
     * 当遍历到一个元素时
     *      如果这个元素和前一个元素不同，那一定是新的元素，直接加入新的数组
     *      如果这个元素和前一个元素相同，那检查这个元素是否已经加入新的数组两次，是则不处理，否则加入
     *      也可以统计这个元素出现的次数，如果超过2则不加入
     */
    static class Solution {
        public int removeDuplicates(int[] nums) {
            int cursor = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i == 0 || nums[i] != nums[i-1]) {
                    nums[cursor++] = nums[i];
                } else if (nums[i] == nums[i-1]) {
                    if (cursor < 2 || nums[i] != nums[cursor-2]) {
                        nums[cursor++] = nums[i];
                    }
                }
            }
            return cursor;
        }
    }

    static class Solution2 {
        public int removeDuplicates(int[] nums) {
            int cursor = 0;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i != 0 && nums[i] != nums[i-1]) {
                    count = 1;
                } else {
                    count ++;
                }
                if (count <= 2) {
                    nums[cursor++] = nums[i];
                }
            }
            return cursor;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,2,3};
        int rs = new Solution2().removeDuplicates(arr);
        Out.p(arr);
        Out.p(rs);
    }

}
