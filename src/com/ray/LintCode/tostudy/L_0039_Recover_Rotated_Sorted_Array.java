package com.ray.LintCode.tostudy;

import java.util.ArrayList;

import com.ray.io.Out;

/**
 * 描述：
 *      给定一个旋转有序的数组，将其转换为有序的数组。
 *
 * 用例：
 *      **Example 1:**
 *      [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
 *      **Example2:**
 *      [6, 8, 9, 1, 2] -> [1, 2, 6, 8, 9]
 *
 * 挑战：
 *      原地实现，空间复杂度O(1)，时间复杂度O(n)
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/recover-rotated-sorted-array/description
 * @date   2019-07-11 17:51:29
 */
public class L_0039_Recover_Rotated_Sorted_Array {

    /**
     *      /|
     *     / |
     *    /  |
     *   /   |  /|
     *   |   | / |
     *   |   |/  |
     *   l----c--r--------
     * 
     * 旋转数组可以理解为两个有序数组前后拼接，只要找到分割点，然后合并两个有序数组即可。
     * 合并时，和纯粹的两个有序数组不同，右半部分的元素一定是小于左半部分的。
     * 
     * 实际操作时可能有两种情况：
     *          （1） 左侧元素数量大于右侧
     *                  将右侧所有元素和最左侧的等量元素替换。
     *                  替换后，最小的元素到了最左侧，右侧继续变为右侧大，左侧小的模式
     *          （2）左侧元素数量小于（等于）右侧
     *                  将右侧的所有元素和最左侧的等量元素替换
     *                  替换后，左侧变为右侧大，左侧小的模式
     *                  
     * 寻找分割点
     *      时间复杂度 O(n),空间复杂度 O(1)
     * 
     * 合并
     *      时间复杂度 O(n),空间复杂度 O(1)
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
            
            int c = nums.size();
            for (int i = 1; i < nums.size(); i ++) {
                if (nums.get(i).compareTo(nums.get(i-1)) < 0) { 
                    c = i; 
                    break;
                }
            }
            
            int l = 0,
                r = nums.size()-1;
            int num = 0;
            while (c > l && c <= r) {
                if (c < (l + r + 2) / 2) {
                    num = c - l;
                    swap(nums, l, c, num);
                    l = c;
                    c = c + num;
                } else {
                    num = r + 1 - c;
                    swap(nums, l, c, num);
                    l = l + num;
                }
            }
            
        }
        
        public void swap(ArrayList<Integer>arr,  int l1, int l2, int size) {
            for (int i = 0; i < size; i ++) {
                Integer temp = arr.get(l1 + i);
                arr.set(l1 + i, arr.get(l2 + i));
                arr.set(l2 + i, temp);
            }
        }
        
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
