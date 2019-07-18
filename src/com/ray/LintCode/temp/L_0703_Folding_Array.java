package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array `nums` of length `n` and an array `req` of length `k` , you need to fold the array as required, and output the result of the fold.
 *      1.If `req[i] = 0` means you should fold from `left` to `right`
 *      for example:
 *      ```
 *      1 2 3 4 5 6 7 8  ==>   4 3 2 1
 *                             5 6 7 8
 *      ```
 *      2.If `req[i] = 1` means you should fold from `right` to `left`
 *      for example:
 *      ```
 *      1 2 3 4 5 6 7 8  ==>   8 7 6 5
 *                             1 2 3 4
 *      ```
 *      
 *      More example:
 *      ```
 *      fold from left to right
 *      4 3 2 1  ==>  6 5
 *      5 6 7 8       3 4
 *                    2 1
 *                    7 8
 *      
 *      
 *      fold from right to left
 *      6 5  ==>   8
 *      3 4        1
 *      2 1        4
 *      7 8        5
 *                 6
 *                 3
 *                 2
 *                 7 
 *      ```
 *
 * 用例：
 *      **Example 1**
 *      
 *      ```plain
 *      Input:
 *      nums = [1, 2, 3, 4, 5, 6, 7, 8]
 *      req = [0, 0, 1]
 *      
 *      Output: [8, 1, 4, 5, 6, 3, 2, 7]
 *      Explanation: Please see the description.
 *      ```
 *      
 *      **Example 2**
 *      
 *      ```plain
 *      Input:
 *      nums = [1,2,3,4]
 *      req = [0,1]
 *      
 *      Output: [4,1,2,3]
 *      ```
 *
 * 挑战：
 *      How to do in place?
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/folding-array/description
 * @date   2019-07-11 18:35:41
 */
public class L_0703_Folding_Array {

    /**
     * 无论左折叠还是右折叠，数组的列数减少一半，行数增加一倍。
     * 因为折叠是按行折叠，每一行折叠后成为两个区域，所以任意时刻，数组都可以分为 2n个区域，每个区域包含 l/2n 个元素 
     *     用二维的方式表示是：
     *          1,     2
     *          3,     4
     *          ...
     *          2n-1, 2n
     *          
     *      用一维的方式表示是：
     *          1, 2, 3, 4, ... 2n-1, 2n
     * 
     * 这样左折叠，就是将抽出奇数区域提前，整体奇数区域是逆序排列，并且每个区域内的元素也是逆序排列，可以表示为：
     *          2n-1, .. 3, 1, 2, 4, .., 2n
     *          
     *     右折叠，就是抽取偶数的区域提前，整体偶数区域是逆序排列，并且每个区域内的元素也是逆序排列，可以表示为：
     *          2n, .., 4, 2, 1, 3 .. 2n-1
     * 
     * 这次算法没有实现原地，如果要实现原地，时间复杂度理论来说比较高， 也可能有更好的算法，但是这里不再讨论。
     * 
     * 
     */
    static class Solution {
    
        public int[] folding(int[] nums, int[] req) {
            
            int width = nums.length/2;
            
            for (int i : req) {
                if (i == 0)
                    foldingL2R(nums, width);
                else
                    foldingR2L(nums, width);
                width /= 2;
            }
            
            return nums;
        }
        
        // 抽出奇数区域提前，整体奇数区域是逆序排列，并且每区域内的元素也是逆序排列
        void foldingL2R(int[] nums, int width) {
            int n = nums.length / width;
            int[] temp = new int[nums.length];
            
            // 逆序复制奇数区域，一共有 n/2 个奇数区域 
            for (int i = 1; i <= n/2; i++) {
                // 第 i 个奇数区域, id 为 i*2-1 放到 id 为 n/2+i 的区域位置，并且元素要逆序
                reverseCopy( width, nums, i*2-1, temp, n/2-i+1);
            }
            
            // 复制偶数区域，一共有 n/2 偶数区域 
            for (int i = 1; i <= n/2; i++) {
                // 第 i 个偶数区域, id 为 i*2 放到 id 为 n/2+i 的区域位置，并且元素要顺序
                copy( width, nums, i*2, temp, n/2+i);
            }
            
            for (int i = 0; i < temp.length; i++) {
                nums[i] = temp[i];
            }
            
        }
        
        // 抽取偶数的区域提前，整体偶数区域是逆序排列，并且偶数内部的元素也是逆序排列
        void foldingR2L(int[] nums, int width) {
            int n = nums.length / width;
            int[] temp = new int[nums.length];
            
            // 逆序复制偶数区域，一共有 n/2 个奇数区域
            for (int i = 1; i <= n/2; i++) {
                int ids = i*2; // 第 i 个偶数区域，对应的 id 是 ids = i*2
                // 区域的id要逆序排列，因此 ids 放到 idt = n/2-i+1 的位置，并且元素要逆序
                reverseCopy( width, nums, ids, temp, n/2-i+1);
            }
            
            // 复制奇数区域
            for (int i = 1; i <= n/2; i++) {
                int ids = i*2-1; // 第 i 个奇数区域，对应的 id 是 ids = i*2 - 1
                // 区域的id要逆序排列，因此 ids 放到 idt = n/2+i 的位置，并且元素要逆序
                copy( width, nums, ids, temp, n/2+i);
            }
            
            for (int i = 0; i < temp.length; i++) {
                nums[i] = temp[i];
            }
            
        }
        
        private void reverseCopy(int width, int[] nums, int id1, int[] temp, int id2) {
            int r1 = id1*width-1;
            int l2 = (id2-1)*width;
            for (int i = 0; i < width; i++)
                temp[l2+i] = nums[r1-i];
        }
        
        private void copy(int width, int[] nums, int id1, int[] temp, int id2) {
            int l1 = (id1-1)*width, l2 = (id2-1)*width;
            for (int i = 0; i < width; i++) temp[l2+i] = nums[l1+i];
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
