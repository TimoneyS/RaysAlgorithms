package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an Android `3x3` key lock screen and two integers `m` and `n`, where `1 ≤ m ≤ n ≤ 9`, count the total number of unlock patterns of the Android lock screen, which consist of minimum of `m` keys and maximum `n` keys.
 *      
 *      **Rules for a valid pattern:**
 *      1. Each pattern must connect at least `m` keys and at most `n` keys.
 *      2. All the keys must be distinct.
 *      3. If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must have previously selected in the pattern. No jumps through non selected key is allowed.
 *      4. The order of keys used matters.
 *      ![android unlock](https://lintcode-media.s3.amazonaws.com/problem/andriod-unlock.png "android unlock")
 *      **Explanation:**
 *      ```
 *      | 1 | 2 | 3 |
 *      | 4 | 5 | 6 |
 *      | 7 | 8 | 9 |
 *      ```
 *      **Invalid move:** `4 - 1 - 3 - 6`
 *      Line 1 - 3 passes through key 2 which had not been selected in the pattern.
 *      
 *      **Invalid move:** `4 - 1 - 9 - 2`
 *      Line 1 - 9 passes through key 5 which had not been selected in the pattern.
 *      
 *      **Valid move:** `2 - 4 - 1 - 3 - 6`
 *      Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern
 *      
 *      **Valid move:** `6 - 5 - 4 - 1 - 9 - 2`
 *      Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: m = 1, n = 1
 *      Output: 9
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: m = 1, n = 2
 *      Output: 65
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/android-unlock-patterns/description
 * @date   2019-07-11 18:38:32
 */
public class L_0909_Android_Unlock_Patterns {


    /**
     * 
     * DFS 搜索，确定下一个可达的定点的时候需要注意同一行或同一列的点，当上一个点未被标记时不能直接访问下一个点。
     * 
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
