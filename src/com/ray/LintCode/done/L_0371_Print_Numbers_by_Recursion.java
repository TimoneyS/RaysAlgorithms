package com.ray.LintCode.done;

import java.util.ArrayList;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      Print numbers from 1 to the largest number with N digits by recursion.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input : N = 1 
 *      Output :[1,2,3,4,5,6,7,8,9]
 *      ```
 *      **Example 2:**
 *      ```
 *      Input : N = 2 
 *      Output :[[1,2,3,4,5,6,7,8,9,10,11,12,...,99]
 *      ```
 *
 * 挑战：
 *      Do it in recursion, not for-loop.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/print-numbers-by-recursion/description
 * @date   2019-07-11 18:32:15
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
        
        Out.p(new Solution());
        
    }

}
