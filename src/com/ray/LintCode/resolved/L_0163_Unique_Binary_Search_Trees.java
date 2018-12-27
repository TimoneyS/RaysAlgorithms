package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 返回 n 个数字可能构成的二叉树的个数
 * @author rays1
 *
 */
public class L_0163_Unique_Binary_Search_Trees {

    static class Solution {
        
        int[] mem;
        
        public int numTrees(int n) {
            mem = new int[n+1];
            return nt(n);
        }
        
        public int nt(int n) {
            if (n <= 1) return 1;
            if (n == 2) return 2;
            
            if (mem[n] == 0) {
                int count = 0;
                for (int i = 0; i < n; i ++) {
                    int l = nt(i);
                    int r = nt(n-1-i);
                    count += l*r;
                }
                mem[n] = count;
            }
            return mem[n];
        }
        
    }
    
    public static void main(String[] args) {
        int n = 7;
        
        int rs = new Solution().numTrees(n);
        
        Out.p(rs);
    }

}
