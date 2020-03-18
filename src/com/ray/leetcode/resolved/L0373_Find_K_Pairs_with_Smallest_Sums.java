package com.ray.leetcode.resolved;

import com.ray.io.In;
import com.ray.io.Out;

import java.util.*;

/**
 * Find K Pairs with Smallest Sums
 * -----------------------------------------------------------------------------
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 *
 * Example:
 *      Example 1
 *      Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 *      Output: [[1,2],[1,4],[1,6]] 
 *      Explanation: The first 3 pairs are returned from the sequence: 
 *                   [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 *      Example 2
 *      Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 *      Output: [1,1],[1,1]
 *      Explanation: The first 2 pairs are returned from the sequence: 
 *                   [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 *      Example 3
 *      Input: nums1 = [1,2], nums2 = [3], k = 3
 *      Output: [1,3],[2,3]
 *      Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/
 * @since   2020-03-18 22:29:39
 */
public class L0373_Find_K_Pairs_with_Smallest_Sums {
    /**
     * 每次从选择了 i j 为最小值后，(i+1，j) (i, j+1) 都可能是下一个最小值。
     * 因此那么这种最小值的选择和待选的对可以利用优先级队列来完成。
     * 每次取出最小的数字对，然后将待选的对加入队列。
     */
    static class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<List<Integer>> rs = new ArrayList<>();
            if (nums2.length * nums1.length == 0) return rs;
            PriorityQueue<List<Integer>> pq = new PriorityQueue<>(
                    Comparator.comparingInt(a -> nums1[a.get(0)] + nums2[a.get(1)]));
            pq.add(Arrays.asList(0, 0));

            boolean[][] marked = new boolean[nums1.length+1][nums2.length+1];
            marked[0][0] = true;

            while (!pq.isEmpty() && rs.size() < k) {
                List<Integer> l = pq.poll();
                rs.add(l);
                int i = l.get(0), j = l.get(1);
                if (i < nums1.length - 1 && !marked[i+1][j]) {
                    marked[i+1][j] = true;
                    pq.offer(Arrays.asList(i+1, j));
                }
                if (j < nums2.length - 1 && !marked[i][j+1]) {
                    marked[i][j+1] = true;
                    pq.offer(Arrays.asList(i, j+1));
                }
            }
            for (List<Integer> l : rs ) {
                l.set(0, nums1[l.get(0)]);
                l.set(1, nums2[l.get(1)]);
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        int[] a = {};
        int[] b = {1,2,3};
        int k = 10;
        Out.p(new Solution().kSmallestPairs(a, b, k));
    }
}
