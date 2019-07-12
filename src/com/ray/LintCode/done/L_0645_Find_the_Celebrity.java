package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Suppose you are at a party with `n` people (labeled from `0` to `n - 1`) and among them, there may exist one celebrity. The definition of a celebrity is that all the other `n - 1` people know him/her but he/she does not know any of them.
 *      
 *      Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
 *      
 *      You are given a helper function `bool knows(a, b)` which tells you whether A knows B. Implement a function `int findCelebrity(n)`, your function should minimize the number of calls to `knows`.
 *
 * 用例：
 *      **Example1**
 *      ```
 *      Input:
 *      2 // next n * (n - 1) lines 
 *      0 knows 1
 *      1 does not know 0
 *      Output: 1
 *      Explanation:
 *      Everyone knows 1,and 1 knows no one.
 *      ```
 *      **Example2**
 *      ```
 *      Input:
 *      3 // next n * (n - 1) lines 
 *      0 does not know 1
 *      0 does not know 2
 *      1 knows 0
 *      1 does not know 2
 *      2 knows 0
 *      2 knows 1
 *      Output: 0
 *      Explanation:
 *      Everyone knows 0,and 0 knows no one.
 *      0 does not know 1,and 1 knows 0.
 *      2 knows everyone,but 1 does not know 2.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/find-the-celebrity/description
 * @date   2019-07-11 18:34:44
 */
public class L_0645_Find_the_Celebrity {

    static class Relation { 
        
        boolean knows(int a, int b) {
            return inner[a][b];
        }
        boolean[][] inner;
        public void initRela(int n, int[][] rela) {
            inner = new boolean[n][n];
            for (int[] r : rela) inner[r[0]][r[1]] = true;
        }
    };
    
    /**
     * 首先将人群分为两个圈子 q1 和 q2，在每个圈子中寻找名人 c1 c2，c1,c2 有可能是 -1 表示没有名人。
     * 即
     *      q1 -> c1
     *      q2 -> c2
     * 
     * 如果 两个圈子都没有名人，则说明两个圈子合并后也没有名人。
     * 如果 c1 在 q2 中是名人则说明两个圈子合并后名人是 c1（因为 c1 在q2中是名人，说明c2认识c1）
     *      同理，反过来也可能是 c2
     * 如果两个名人分别在对方的圈子都不是名人，则说明圈子合并后没有名人。
     * 
     * 在查找圈子时，采用递归的方式划分。
     * 这样圈子的划分复杂度为 log(n)，每一层合并圈子的复杂度为 n
     * 整体复杂度最坏情况为 n*logn
     * 
     * @author rays1
     *
     */
    static class Solution extends Relation {
        
        public int findCelebrity(int n) {
            return find(0, n-1);
        }
        
        // 在某个小圈子内找名人。
        int find(int l, int r) {
            if (l == r) return l;
            
            int m = (l + r)/2;
            int c1 = find(l, m), c2 = find(m+1, r);
            
            int rs = -1;
            if (c1 != -1 && isCel(c1, m + 1, r)) rs = c1;
            if (rs == -1 && c2 != -1 && isCel(c2, l, m)) rs = c2;
            
            return rs;
        }
        
        boolean isCel(int c, int start, int end) {
            for (int i = start; i <= end; i++)
                if (!knows(i, c) || knows(c, i))
                    return false;
            return true;
        }

    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
