package com.ray.LintCode.tostudy;

import com.ray.io.Out;

/**
 * 描述：
 *      给定一个安卓 3*3 的锁屏界面，和两个数字 m n（1 ≤ m ≤ n ≤ 9）。锁屏时最少包含 m 个键，最多 n 个键，统计所有可能的锁屏方式，
 *      规则：
 *          1. 每个锁屏模式必须链接 m 到 n 之间的键数。
 *          2. 每个键只能使用一次
 *          3. 不能越过一个键去链接一条线上的另一个键
 *          4. 不同的键的顺序是有关的
 *
 * 用例：
 *      **Example1**
 *      Input: m = 1, n = 1
 *      Output: 9
 *      
 *      **Example2**
 *      Input: m = 1, n = 2
 *      Output: 65
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/android-unlock-patterns/description
 * @date   2019-07-11 18:38:32
 */
public class L_0909_Android_Unlock_Patterns {


    /**
     * DFS 搜索，确定下一个可达的定点的时候需要注意同一行或同一列的点，当上一个点未被标记时不能直接访问下一个点。
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int numberOfPatterns(int m, int n) {
            boolean[][] marked = new boolean[3][3];
            int a = helper(0, 0, 1, m, n, marked);
            int b = helper(0, 1, 1, m, n, marked);
            int c = helper(1, 1, 1, m, n, marked);
            return a * 4 + b * 4 + c;
        }
        
        public int helper(int x, int y, int c, int m, int n, boolean[][] marked) {
            if (c > n) return 0;
            marked[x][y] = true;
            int rs = 0;
            for (int z = 0; z < 9; z++) {
                int i = z / 3;
                int j = z % 3;
                
                int d = Math.abs(x-i) + Math.abs(y-j);
                if (marked[i][j] || (d == 2 && (x == i || y == j) || d == 4) && !marked[(x+i)/2][(y+j)/2]) {
                    continue;
                }
                
                rs += helper(i, j, c + 1, m, n, marked);
            }
            marked[x][y] = false;
            if (c >= m && c <= n) rs ++;
            return rs;
        }
        
        
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
