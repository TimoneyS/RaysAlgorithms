package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Find the Duplicate Number
 * -----------------------------------------------------------------------------
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 *
 * Example:
 *      Example 1
 *      Input: [1,3,4,2,2]
 *      Output: 2
 *      Example 2
 *      Input: [3,1,3,4,2]
 *      Output: 3
 *      Note:
 *      	You must not modify the array (assume the array is read only).
 *      	You must use only constant, O(1) extra space.
 *      	Your runtime complexity should be less than O(n2).
 *      	There is only one duplicate number in the array, but it could be repeated more than once.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/find-the-duplicate-number/
 * @since   2020-03-10 02:08:44
 */
public class L0287_Find_the_Duplicate_Number {
    /**
     * 数组中的数字的范围为 1~n，数组中有 n+1个数字，根据抽屉原理至少存在一对重复的数字。
     *
     * 根据坐标和其位置上的值，可以建立映射 f(i) = A[i]
     * 对于重复的数字可以表示为：i != j && f(i) = f(j)
     *
     * 首先考虑一种完美的情况，数组为 [ 1, 2, ...., n, x ]，x∈(1, n)，此时映射关系如下：
     *      f(0) = 1, f(1) = 2, f(2) = 3, ... , f(n) = x
     *      这种映射可以构成一个链式的关系，而且最终会有一个环。
     *      0 -> 1 -> 2 -> ... -> n
     *              ↖_ _ _ _ _ _ /
     *
     * 但是实际上数组的元素是杂乱无序的，比如 [3, 4, 1, 4, 2]
     *      f(0) = 3, f(3) = 4, f(4) = 2, f(2) = 1, f(1) = 4
     *      3 -> 4 -> 2 -> 1
     *            ↖_ _ _ _/
     *      此时映射依然构成了一个链式关系，并且有一个环
     *
     * 实际上从 f(0) 出发，假设
     *      f(0)    = x1
     *      f(x1)   = x2
     *      f(x2)   = x3
     *      ...
     *      如果新的映射值和之前的值不同，则链式关系会向前进
     *      如果新的映射值和之前的值相同，则链式关系构成环
     *      因为新的映射值有 n 中而映射关系有 n+1中，最终链式关系还是会构成环。
     *      构成环时有
     *          f(xi) = xi+1
     *          f(xj) = xi+1
     *      这个重复的值就是 xi+1，也是环的入口
     *
     * 因此题目可以转换为寻找链表的环的入口的问题，参见 L_0103_Linked_List_Cycle_II
     *
     */
    static class Solution {

        public int findDuplicate(int[] nums) {

            int slow = 0, fast = 0;
            while (true) {
                slow = nums[slow];
                fast = nums[nums[fast]];
                if (slow == fast) break;
            }

            int result = 0;
            while (true) {
                slow = nums[slow];
                result = nums[result];
                if (slow == result) return result;
            }
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
