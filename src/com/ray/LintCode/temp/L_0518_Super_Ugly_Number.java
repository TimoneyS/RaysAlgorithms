package com.ray.LintCode.temp;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.ray.io.Out;

/**
 * 描述：
 *      Write a program to find the nth super ugly number.
 *      
 *      A super ugly number is a positive integer in which all prime factors are within a given set of prime numbers. 
 *      
 *      For example, given `[2, 7, 13, 19]`, then `[1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32]` is the first 12 super ugly numbers.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: n = 6, [2,7,13,19]
 *      Output: 13
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: n = 11, [2,3,5]
 *      Output: 15
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/super-ugly-number/description
 * @date   2019-07-11 18:33:48
 */
public class L_0518_Super_Ugly_Number {

    /*
     * 
     * 不断的用之前的丑数，乘以每个质因数，得到的最小的丑数就是下一个
     * 
     */
    static class Solution {
    
        class Pair {
            int index;
            int value;
            public Pair(int index, int value) {
                this.index = index;
                this.value = value;
            }
        }
        
        class PairComparator implements Comparator<Pair> {
            public int compare(Pair o1, Pair o2) {
                return Integer.compare(o1.value, o2.value);
            }
        }
        
        public int nthSuperUglyNumber(int n, int[] primes) {
            
            int[] rank  = new int[primes.length];
            int[] rs    = new int[n];
            
            PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());
            
            rs[0] = 1;
            for (int i = 0; i < primes.length; i++) {
                pq.offer(new Pair(i, rs[rank[i]] * primes[i]));
            }
            
            for (int i = 1; i < rs.length; i++) {
            
                Pair min = pq.peek();
                rs[i] = min.value;
                
                while (!pq.isEmpty() && pq.peek().value == min.value) {
                    min = pq.poll();
                    rank[min.index] ++;
                    pq.offer(new Pair(min.index, rs[rank[min.index]] * primes[min.index]));
                }
                
            }
            
            return rs[n-1];
            
        }
    
    }
    
    public static void main(String[] args) {
        
        int n = 6;
        int[] primes = {2, 7, 13, 19};
        
        Out.p(new Solution().nthSuperUglyNumber(n, primes));
        
    }

}
