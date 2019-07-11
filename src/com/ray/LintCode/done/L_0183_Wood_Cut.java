package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given n pieces of wood with length `L[i]` (integer array). Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length. What is the longest length you can get from the n pieces of wood? Given L & k, return the maximum length of the small pieces.
 *
 * 用例：
 *      **Example 1**
 *      
 *      ```plain
 *      Input:
 *      L = [232, 124, 456]
 *      k = 7
 *      Output: 114
 *      Explanation: We can cut it into 7 pieces if any piece is 114cm long, however we can't cut it into 7 pieces if any piece is 115cm long.
 *      ```
 *      
 *      **Example 2**
 *      
 *      ```plain
 *      Input:
 *      L = [1, 2, 3]
 *      k = 7
 *      Output: 0
 *      Explanation: It is obvious we can't make it.
 *      ```
 *
 * 挑战：
 *      O(n log Len), where Len is the longest length of the wood.
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/wood-cut/description
 * @date   2019-07-11 18:31:42
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
