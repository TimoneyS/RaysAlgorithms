package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Super Ugly Number
 * -----------------------------------------------------------------------------
 * Write a program to find the nth super ugly number.
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
 *
 * Example:
 *      Example 1
 *      Input: n = 12, primes = [2,7,13,19]
 *      Output: 32 
 *      Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12 
 *                   super ugly numbers given primes = [2,7,13,19] of size 4.
 *      Note:
 *      	1 is a super ugly number for any given primes.
 *      	The given numbers in primes are in ascending order.
 *      	0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 *      	The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/super-ugly-number/
 * @since   2020-03-11 19:17:38
 */
public class L0313_Super_Ugly_Number {
    /*
     *
     * 不断的用之前的丑数，乘以每个质因数，得到的最小的丑数就是下一个
     *
     */
    static class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {

            int[] rank  = new int[primes.length];
            int[] rs    = new int[n];

            Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            rs[0] = 1;
            for (int i = 0; i < primes.length; i++) pq.offer(new int[]{i, rs[rank[i]] * primes[i]});

            for (int i = 1; i < rs.length; i++) {
                int[] min = pq.peek();
                rs[i] = min[1];
                while (!pq.isEmpty() && pq.peek()[1] == min[1]) {
                    min = pq.poll();
                    rank[min[0]] ++;
                    pq.offer(new int[]{min[0], rs[rank[min[0]]] * primes[min[0]]});
                }
            }
            return rs[n-1];
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
