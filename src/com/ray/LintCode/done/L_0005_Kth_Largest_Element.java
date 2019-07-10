package com.ray.LintCode.done;

import java.util.PriorityQueue;

import com.ray.io.Out;

/**
 * 描述：
 *      寻找数组中第 k 大的元素
 * 用例：
 *      输入: n = 3, nums = [9,3,2,4,8]
 *      输出: 4
 * 挑战：
 *      O(n) time, O(1) extra memory.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/kth-largest-element/description

 * @date   2019-07-10 15:14:14
 */
public class L_0005_Kth_Largest_Element {

    /**
     * 快速选择算法，和快速排序原理类似。
     * 
     * 任意挑选元素，调整数组使得元素左侧的元素都较小而右侧的元素都较大。
     * 然后判断元素的索引需要从左侧还是右侧继续操作，直到选择的元素正好位于期望位置。
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int kthLargestElement(int k, int[] nums) {
            return quickSelect(nums, nums.length-k, 0, nums.length-1);
        }
        
        private int quickSelect(int[] nums, int k, int s, int t) {
            int l = s + 1, r = t;
            while (true) {
                while (r > s && nums[s] <= nums[r]) { r --; }
                while (l < t && nums[l] < nums[s])  { l ++; }
                if (r > l) {
                    swap(nums, r, l);
                } else {
                    break;
                }
            }
            swap(nums, r, s);
            if (r == k) {
                return nums[r];
            } else if (r > k) {
                return quickSelect(nums, k, s, r-1);
            } else {
                return quickSelect(nums, k, r+1, t);
            }
        }
        
        private void swap(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    
    }
    
    /**
     * 维护一个堆，只保存前k个最大元素。
     * 
     * @author rays1
     *
     */
    static class Solution2 {
        
        public int kthLargestElement(int k, int[] nums) {
             PriorityQueue<Integer> pq = new PriorityQueue<>();
             for (int n : nums) {
                 if (pq.size() < k) {
                     pq.add(n);
                 } else if (pq.peek() < n) { 
                     pq.poll();
                     pq.add(n);
                 }
             }
            return pq.poll();
        }
        
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
