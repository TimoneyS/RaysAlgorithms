package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.PriorityQueue;

/**
 * 最小的k个数  LCOF
 * -----------------------------------------------------------------------------
 * English description is not available for the problem. Please switch to Chinese.
 *
 * Example:
 *      
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * @since   2020-03-23 21:58:39
 */
public class L100301_最小的k个数__LCOF {
    static class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
            for (int n : arr) {
                if (pq.size() < k) pq.offer(n);
                else if (pq.size() != 0 && pq.peek() > n) {
                    pq.poll();
                    pq.offer(n);
                }
            }
            int[] rs = new int[k];
            for (int i = k-1; i >= 0; i --) rs[i] = pq.poll();
            return rs;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
