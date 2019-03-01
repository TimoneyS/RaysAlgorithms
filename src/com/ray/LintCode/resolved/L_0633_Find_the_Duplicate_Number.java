package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给出一个数组 nums 包含 n + 1 个整数，每个整数是从 1 到 n (包括边界)，保证至少存在一个重复的整数。
 * 假设只有一个重复的整数，找出这个重复的数。
 * 
 * 要求
 *      1.不能修改数组(假设数组只能读)
 *      2.只能用额外的O(1)的空间
 *      3.时间复杂度小于O(n^2)
 *      4.数组中只有一个重复的数，但可能重复超过一次
 *
 * @author rays1
 *
 */
public class L_0633_Find_the_Duplicate_Number {

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
     * @author rays1
     *
     */
    static class Solution {

        public int findDuplicate(int[] nums) {

            int slow = 0, fast = 0;
            while (true) {
                slow = nums[slow];
                fast = nums[nums[fast]];
                if (slow == fast) {
                    break;
                }
            }

            int result = 0;
            while (true) {
                slow = nums[slow];
                result = nums[result];
                if (slow == result) {
                    return result;
                }
            }

        }
        
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }

}
