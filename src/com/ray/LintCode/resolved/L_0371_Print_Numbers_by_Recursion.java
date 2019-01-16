package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.List;

import com.ray.io.Out;

/**
 * 通过递归将数字从1打印到最大数字，N位数。
 *
 * N = 1，返回 [1,2,3,4,5,6,7,8,9]
 * N = 2，返回 [1,2,3,4,5,6,7,8,9,10,11,12,...,99]
 * @author rays1
 *
 */
public class L_0371_Print_Numbers_by_Recursion {

    static class Solution {
        public List<Integer> numbersByRecursion(int n) {
            ArrayList<Integer> rs = new ArrayList<>();
            if (n > 0)
                helper(rs, 0, n);
            return rs;
        }
        
        public void helper(List<Integer> rs, int base, int n) {
            base = base * 10;
            
            for (int i = 0; i < 10; i++) {
                if (n <= 1) {
                    if (base+i == 0) continue; 
                    rs.add(base + i);
                } else {
                    helper(rs, base + i, n-1);
                }
            }
            
        }
    }
    
    public static void main(String[] args) {
        int n = 0;
        Out.p(new Solution().numbersByRecursion(n));
    }

}
