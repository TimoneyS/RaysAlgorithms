package com.ray.LintCode.resolved;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.ray.io.Out;

/**
 * 编写程序寻找第 n 个超级丑数
 * 超级丑数是给定了质因数的集合，寻找从小到大的第n个丑数
 *
 * @author rays1
 *
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
