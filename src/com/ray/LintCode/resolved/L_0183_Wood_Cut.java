package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 *
 * n 块木板，长度为 L[i]。将其切割为更小的木板，确保至少有 k 个等长的木板。
 * 给定 L 和 k，返回最大长度
 * 
 * L = [232, 124, 456], k=7, 返回 114.
 *
 *
 * 挑战  O(n log Len), where Len is the longest length of the wood.
 *
 * @author rays1
 *
 */
public class L_0183_Wood_Cut {

    /**
     * 设最大长度为 m
     * 则  ∑ Li/m  >= k
     *    ∑ Li    >= m * k
     *   (∑ Li)/k >= m
     *  因此只要在 0 - (∑ Li)/k 中采用二分查找的方式，试探长度是否符合要求即可。
     *   
     * @author rays1
     *
     */
    static class Solution {
        
        public int woodCut(int[] L, int k) {
            
            long max = 0, min = 0, rs = 0;
            for (int i : L) max += i;
            max = max / k;
            
            while (max >= min) {
                long m = (max+min) / 2;
                if (countPices(L, m) >= k) {
                    min = m+1;
                    rs = m;
                } else {
                    max = m-1;
                }
            }
            
            return (int)rs;
        }
        
        private int countPices(int[] L, long len) {
            int count = 0;
            for (int i : L) count += i/len;
            return count;
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] L = {2147483644,2147483645,2147483646,2147483647};
        int k = 4;
        
        Out.p(new Solution().woodCut(L, k));
        
    }

}
