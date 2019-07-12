package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given `n` books and the `i-th` book has `pages[i]` pages. There are `k` persons to copy these books.
 *      
 *      These books list in a row and each person can claim a continous range of books. For example, one copier can copy the books from `i-th` to `j-th` continously, but he can not copy the 1st book, 2nd book and 4th book (without 3rd book).
 *      
 *      They start copying books at the same time and they all cost 1 minute to copy 1 page of a book. What's the best strategy to assign books so that the slowest copier can finish at earliest time? 
 *      
 *      Return the shortest time that the slowest copier spends.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: pages = [3, 2, 4], k = 2
 *      Output: 5
 *      Explanation: 
 *          First person spends 5 minutes to copy book 1 and book 2.
 *          Second person spends 4 minutes to copy book 3.
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: pages = [3, 2, 4], k = 3
 *      Output: 4
 *      Explanation: Each person copies one of the books.
 *      ```
 *
 * 挑战：
 *      O(nk) time
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/copy-books/description
 * @date   2019-07-11 18:33:08
 */
public class L_0437_Copy_Books {

    /**
     * 问题的实质是将长度为 n 的数组，分割为 k 个子数组，寻找一种分割方式，使得所有子数组的和的最大值比其他的分割方案的情况要小。
     * 
     * 用  A[i][j] 表示将长度为 n 的数组 pages ，从 i 开始分割为 j 个子数组，最优分割方案下所有子数组和的最大值
     * 
     * 则  A[i][j] = min {
     *        max { ∑ pages[i..i],   A[i+1][j-1] },
     *        max { ∑ pages[i..i+1], A[i+2][j-1] }
     *        ...
     *        max { ∑ pages[i..t],   A[t+1][j-1] }
     *    }
     *    
     * rs = A[0][k]
     * 
     * 具体实现细节还可以优化
     * 
     */
    static class Solution {
    
        public int copyBooks(int[] pages, int k) {
            if (pages == null || pages.length == 0) return 0;
            
            int n = pages.length;
            int[] mem = new int[n];
            
            for (int i = n-1; i >= 0; i --) mem[i] = (i == n-1) ? pages[i] : mem[i+1] + pages[i];
            
            for (int j = 2; j <= k; j ++) {
                for (int i = 0; i < n-1; i ++) {
                    int sum = 0;
                    int rs  = Integer.MAX_VALUE;
                    for (int t = i; t < n-1; t ++ ) {
                        sum += pages[t];
                        rs = Math.min(rs, Integer.max(sum, mem[t+1]));
                    }
                    mem[i] = rs;
                }
                Out.p(mem);
            }
            
            return mem[0];
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] pages = {1, 2};
        int   k     = 5;
        
        Out.p(new Solution().copyBooks(pages, k));
        
    }

}
