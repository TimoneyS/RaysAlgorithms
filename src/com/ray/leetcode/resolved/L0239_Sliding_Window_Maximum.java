package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Sliding Window Maximum
 * -----------------------------------------------------------------------------
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 *
 * Example:
 *      Example 1
 *      Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 *      Output: [3,3,5,5,6,7] 
 *      Explanation: 
 *      Window position                Max
 *      ---------------               -----
 *      [1  3  -1] -3  5  3  6  7       3
 *       1 [3  -1  -3] 5  3  6  7       3
 *       1  3 [-1  -3  5] 3  6  7       5
 *       1  3  -1 [-3  5  3] 6  7       5
 *       1  3  -1  -3 [5  3  6] 7       6
 *       1  3  -1  -3  5 [3  6  7]      7
 *      Note: 
 *      You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 *      Follow up:
 *      Could you solve it in linear time?
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/sliding-window-maximum/
 * @since   2020-03-09 21:42:32
 */
public class L0239_Sliding_Window_Maximum {
    /**
     * 队列中只保存大于当前元素的元素
      */
    static class Solution {

        private void inQueue(Deque<Integer> deque, int num) {
            while (!deque.isEmpty() && deque.peekLast() < num)
                deque.pollLast();
            deque.add(num);
        }

        private void outQueue(Deque<Integer> deque, int num) {
            if (deque.peekFirst() == num)
                deque.pollFirst();
        }

        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length < k || k == 0) {
                return new int[0];
            }
            int[] rs = new int[nums.length - k + 1];

            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < k - 1; i++) {
                inQueue(deque, nums[i]);
            }

            for(int i = k - 1; i < nums.length; i++) {
                inQueue(deque, nums[i]);
                rs[i-k+1] = deque.peekFirst();
                outQueue(deque, nums[i - k + 1]);
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
