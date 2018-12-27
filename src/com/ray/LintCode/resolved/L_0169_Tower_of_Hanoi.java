package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.List;

/**
 * 汉诺塔问题
 * 有三个柱子 A, B, C
 * 将 n 个碟子从 A 移动到 C
 * 
 * 返回每一步的移动方法
 *  
 *  如 n = 2
 *  返回
 *      from A to B
 *      from A to C
 *      from B to C
 *  
 * @author rays1
 *
 */
public class L_0169_Tower_of_Hanoi {

    static class Solution {
        
        String[] NAME = {"A", "C", "B"};
        
        /**
         * @param n: the number of disks
         * @return: the order of moves
         */
        public List<String> towerOfHanoi(int n) {
            List<String> rs = new ArrayList<>();
            hanoi(rs, n, 0, 1, 2);
            return rs;
        }
        
        public void hanoi(List<String> rs, int n, int a, int b, int c) {
            
            if (n == 1) {
                rs.add("from "+ NAME[a] +" to " + NAME[b]);
                return;
            }
            
            hanoi(rs, n-1, a, c, b);
            hanoi(rs, 1,   a, b, c);
            hanoi(rs, n-1, c, b, a);
        }
        
    }
    
    public static void main(String[] args) {
        
        int n = 15;
        
        Solution sol = new Solution();
        sol.towerOfHanoi(n);
        
    }

}
