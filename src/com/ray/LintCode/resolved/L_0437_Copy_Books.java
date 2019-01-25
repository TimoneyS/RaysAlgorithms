package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 437. Copy Books [书籍抄录]
 * ---------------------------------------------------------------------
 * 给定 n 本书籍，每本书有 A[i] 页。k 个人来抄录这些书籍
 * 事先给每个人分配抄录书籍的范围，但是每个人分配的书籍序号必须是连续的。
 * 
 * 所有人同时开始抄录书籍，每个人抄一页需要 1 分钟，需要最优的分配策略，使得抄录工作可以尽快完成，
 *
 * 例如：
 *      三本书，两个人
 *      A = [3, 2, 4], k = 2.
 *
 *      分配第一个人抄 第一、第二本书， 第二个人抄 第三本书，则第一个人需要 5 分钟，第二个人需要 4 分钟。
 *      一共需要 5 分钟。
 * 
 * 时间复杂度 O(nk)
 *
 * @author rays1
 *
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
