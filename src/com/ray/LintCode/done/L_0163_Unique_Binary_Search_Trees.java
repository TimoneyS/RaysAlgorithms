package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given *n*, how many structurally unique **BST**s (binary search trees) that store values 1...*n*?
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:n = 3,
 *      Output: 5
 *      Explanation:there are a total of 5 unique BST's.
 *      ```
 *      
 *      	1           3    3       2      1
 *      	 \         /    /       / \      \
 *      	  3      2     1       1   3      2
 *      	 /      /       \                  \
 *      	2     1          2                  3
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/unique-binary-search-trees/description
 * @date   2019-07-11 18:31:25
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
