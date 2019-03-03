package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 假设一个派对上有 n 个人（标记为 0 到 n-1），人群中可能有 1 个名人。
 * 对于名人而言，其他 n-1个人均认识这个人，同时他不认识其他任何一个人。
 *
 * 如果试图寻找出这个名称，或者确认是否有名人，只能按照以下方式提问来进行：
 *      你好 A，请问你是否认识 B
 * 
 * 这个提问可以得到 A 是否认识 B 的信息。
 * 题目提供了辅助方法 boolean knows(a, b) 等效以上的提问，尽可能的少的提问，来达成目的
 * 
 * 例如：
 *      输入 ：2       // next n * (n - 1) lines
 *          knows(0, 1)     // false
 *          knows(1, 0)     // true
 *      输出：1 
 *      解释： 所有人都认识 1 但是 1不认识其他人
 *     ======================================
 *      输入：3       // next n * (n - 1) lines 
 *          knows(0, 1)     // false
 *          knows(0, 2)     // false
 *          knows(1, 0)     // true
 *          knows(1, 2)     // false
 *          knows(2, 0)     // true
 *          knows(2, 1)     // true
 *      输出：0
 *      解释：所有人都认识0，但是 0 不认识其他人
 * 
 * @author rays1
 *
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
        
        int n = 2;
        int[][] rela = {
                {0, 1},
        };
        
        Solution sol = new Solution();
        sol.initRela(n, rela);
        
        Out.p(sol.findCelebrity(n));
        
    }

}
